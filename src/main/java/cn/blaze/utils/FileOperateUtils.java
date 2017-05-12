package cn.blaze.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @ClassName FileOperateUtils
 * @Description 文件操作工具类
 * @author LiuLei
 * @date 2017年5月8日 下午10:14:30
 */
public class FileOperateUtils {
	public static final String REALNAME = "realName";
	public static final String STOREPATH = "storePath";
	public static final String SIZE = "size";
	public static final String CONTENTTYPE = "contentType";
  
    /**
     * @Title rename
     * @Description：重命名上传的文件名,用时间和随机数组成
     * @param name 带后缀的原文件名
     * @return
     * @user LiuLei 2017年5月8日
     * @updater：
     * @updateTime：
     */
    private static String rename(String name){
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        Long random = (long)(Math.random()* now);
        String fileName = now + "" + random;
        // 加上后缀
        if (name.indexOf(".")!= -1){
            fileName += name.substring(name.lastIndexOf("."));
       }
        return fileName;
   }
  
    /**
     * @Title zipName
     * @Description：将文件名的后缀换成zip
     * @param name 压缩前的文件名
     * @return
     * @user LiuLei 2017年5月8日
     * @updater：
     * @updateTime：
     */
    private static String zipName(String name){
        String prefix = "";
        if (name.indexOf(".")!= -1){
            prefix = name.substring(0, name.lastIndexOf("."));
       } else {
            prefix = name;
       }
        return prefix + ".zip";
   }
  
    /**
     * @Title upload
     * @Description：多文件上传-压缩存储
     * @param request 包含上传文件的请求
     * @return 返回封装每个文件上传后的参数对应的map的List集合
     * map中的key和value分别对应如下:
     * 	FileOperateUtils.REALNAME:上传文件的原文件名,但是后缀变为zip,用于前端显示;
     * 	FileOperateUtils.STOREPATH:文件存储的全路径;
     * 	FileOperateUtils.SIZE:文件存储的大小,单位B;
     * 	FileOperateUtils.CONTENTTYPE:application/octet-stream.
     * @throws Exception
     * @user LiuLei 2017年5月8日
     * @updater：
     * @updateTime：
     */
    public static List<Map<String, Object>> upload(HttpServletRequest request) throws Exception {

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = mRequest.getFileMap();

		String uploadDir = CommonUtils.getPropertiesValue("upload_dir");// 从properties中读取资源存储的根目录
		File file = new File(uploadDir);
		if (!file.exists()) {
			file.mkdir();
		}
  
        String fileName = null;
		for (Iterator<Entry<String, MultipartFile>> it = fileMap.entrySet().iterator(); it.hasNext();) {

			Entry<String, MultipartFile> entry = it.next();
			MultipartFile mFile = entry.getValue();

			fileName = mFile.getOriginalFilename();
			String storePath = zipName(uploadDir + rename(fileName));// 文件存储的全路径名

			// 上传成为压缩文件
			ZipOutputStream outputStream = new ZipOutputStream(
					new BufferedOutputStream(new FileOutputStream(storePath)));
			outputStream.putNextEntry(new ZipEntry(fileName));
			outputStream.setEncoding("GBK");

			FileCopyUtils.copy(mFile.getInputStream(), outputStream);

			Map<String, Object> map = new HashMap<String, Object>();
			// 固定参数值对
			map.put(FileOperateUtils.REALNAME, zipName(fileName)); // 文件上传时的文件名,后缀变为zip,用于前端显示
			map.put(FileOperateUtils.STOREPATH, storePath);// 文件存储的全路径名
			map.put(FileOperateUtils.SIZE, new File(storePath).length());// 文件大小
			map.put(FileOperateUtils.CONTENTTYPE, "application/octet-stream");

			result.add(map);
		}
		return result;
	}

	/**
	 * @Title download
	 * @Description：文件下载
	 * @param response
	 * @param storePath
	 *            文件的存储路径
	 * @param contentType
	 * @param viewName
	 *            前台显示的名称(文件上传时的文件名)
	 * @return 成功返回字符串success,否则返回错误提示
	 * @throws Exception
	 * @user LiuLei 2017年5月10日
	 * @updater：
	 * @updateTime：
	 */
	public static String download(HttpServletResponse response,
			String storePath, String contentType, String viewName)
			throws Exception {
		String message = "success";
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		viewName = viewName == null || "".equals(viewName) ? "未命名资源文件.zip"
				: viewName;
		contentType = contentType == null || "".equals(contentType) ? "application/octet-stream":contentType;
		long fileLength = new File(storePath).length();

		try {

			bis = new BufferedInputStream(new FileInputStream(storePath));
			bos = new BufferedOutputStream(response.getOutputStream());

			response.setHeader("Content-disposition", "attachment; filename="+new String(viewName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			response.setContentType(contentType);

			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			message = "文件名下载时编码错误";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			message = "文件未找到";
		} catch (IOException e) {
			e.printStackTrace();
	        message = "文件输出错误";
		}finally {
			if(bis != null)
				bis.close();
			if(bos != null)
				bos.close();
		}
        return message;
    }
    
}
