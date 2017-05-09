package cn.blaze.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blaze.domain.FileResources;
import cn.blaze.domain.StudentInfo;
import cn.blaze.domain.UserInfo;
import cn.blaze.service.FileResourcesService;
import cn.blaze.service.StudentInfoService;
import cn.blaze.utils.BlazeConstants;
import cn.blaze.utils.FileOperateUtils;
import cn.blaze.vo.FileResourcesVo;

/**
 * @ClassName FileOperateController
 * @Description 文件操作
 * @author LiuLei
 * @date 2017年5月8日 下午10:27:52
 */
@Controller
@RequestMapping("/fileOperate")
public class FileOperateController extends BaseController{
	@Autowired
	private StudentInfoService studentInfoService;
	@Autowired
	private FileResourcesService fileResourcesService;
	
	@RequestMapping("showFileResourceById")
	public String showFileResourceById(HttpServletRequest request){
		String id = this.getNotNullValue(request.getParameter("id"));
		FileResourcesVo resource = fileResourcesService.queryFileResourcesById(id);
		request.setAttribute("file", resource);
		return "file/fileDetail";
	}
	
	/**
	 * @Title forwardFileList
	 * @Description：跳转到资源列表页面
	 * @param request
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardFileList")
	public String forwardFileList(HttpServletRequest request){
		String type = this.getNotNullValue(request.getParameter("type"));// recycle表示回收站
		if("recycle".equals(type)){
			request.setAttribute("is_recycle", "recycle");
		}
		return "file/fileList";
	}
	
	/**
	 * @Title queryFileResourcesJson
	 * @Description：查询文件资源的json数据
	 * @param request
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	@ResponseBody
	@RequestMapping("queryFileResourcesJson")
	public String queryFileResourcesJson(HttpServletRequest request){
		UserInfo loginUser = this.getLoginUser(request);
		// TODO 对非注册的用户过滤数据
		Map<String, Object> map = new HashMap<String, Object>();
		String fileName = this.getNotNullValue(request.getParameter("fileName"));
		String publisherName = this.getNotNullValue(request.getParameter("publisherName"));
		String type = this.getNotNullValue(request.getParameter("type"));// recycle表示回收站
		
		map.put("fileName", fileName);
		map.put("publisherName", publisherName);
		
		// 判断是不是输出回收站的文件
		if("recycle".equals(type) && BlazeConstants.USER_TYPE_ADMIN.equals(loginUser.getType())){// 只有管理员可见回收站数据
			map.put("isvalid", BlazeConstants.ISVALID_NO);
		}else {
			map.put("isvalid", BlazeConstants.ISVALID_YES);
		}
		
		String sortName = this.getNotNullValue(request.getParameter("sortname"));
		String sortOrder = this.getNotNullValue(request.getParameter("sortorder"));
		int page = this.getNotNullValueToInt(request.getParameter("page"));
		int size = this.getNotNullValueToInt(request.getParameter("pagesize"));
		return fileResourcesService.queryFileResourcesByParamForLigerUI(map, sortName, sortOrder, page, size);
	}
	
	/**
	 * @Title forwardUpload
	 * @Description：跳转到上传页面
	 * @return
	 * @user LiuLei 2017年5月8日
	 * @updater：
	 * @updateTime：
	 */
    @RequestMapping("forwardUpload")  
    public String forwardUpload(HttpServletRequest request, HttpServletResponse response) {
		UserInfo loginUser = this.getLoginUser(request);
		String type = loginUser.getType();
		if(BlazeConstants.USER_TYPE_ADMIN.equals(type) || BlazeConstants.USER_TYPE_STUDENT.equals(type)){
			return "file/fileUpload";
		}
		printMessage(response, "对不起未认证的用户无权上传!", false);
        return null;
    }
  
    /**
     * @Title upload
     * @Description：文件上传
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @user LiuLei 2017年5月8日
     * @updater：
     * @updateTime：
     */
    @RequestMapping("upload")  
    public String upload(HttpServletRequest request, HttpServletResponse response) {
    	try{
    		UserInfo loginUser = this.getLoginUser(request);
    		List<Map<String, Object>> result = FileOperateUtils.upload(request);
    		String fileDesc = this.getNotNullValue(request.getParameter("fileDesc"));
    		
    		for (Map<String, Object> map : result) {
    			FileResources resource = new FileResources();
    			String realName = (String) map.get(FileOperateUtils.REALNAME);
    			String filePath = (String) map.get(FileOperateUtils.STOREPATH);
    			long fileSize = (long) map.get(FileOperateUtils.SIZE);
    			String sizeView = String.valueOf(fileSize)+"B";
    			resource.setFileSize(sizeView);
    			resource.setDownCount(0);
    			resource.setFileName(realName);// 上传文件名
    			resource.setFileDesc(fileDesc);// 文件描述
    			resource.setPublishTime(new Date());
    			resource.setFilePath(filePath);// 文件存储物理地址
    			resource.setIsvalid(BlazeConstants.ISVALID_YES);
    			resource.setPublisherId(loginUser.getId());// 上传者id
    			// 上传者姓名
    			if(BlazeConstants.USER_TYPE_ADMIN.equals(loginUser.getType())){
    				resource.setPublisherName("管理员");
    			}else if(BlazeConstants.USER_TYPE_STUDENT.equals(loginUser.getType())){
    				StudentInfo studentInfo = studentInfoService.queryStudentInfoById(loginUser.getStudentId());
    				resource.setPublisherName(studentInfo.getStudentName());
    			}
    			fileResourcesService.saveFileResource(resource);
    		}
    	}catch(Exception e){
    		// 上传出错
    		e.printStackTrace();
    		printMessage(response, "上传出错!", false);
    	}
        return "redirect:fileOperate/forwardUpload";
    }
  
    /**
     * @Title download
     * @Description：文件下载
     * @param request
     * @param response
     * @throws Exception
     * @user LiuLei 2017年5月8日
     * @updater：
     * @updateTime：
     */
    @RequestMapping(value = "download")  
    public void download(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {
  
//        String storeName = "201205051340364510870879724.zip";
//        String realName = "Java设计模式.zip";
//        String contentType = "application/octet-stream";
//        FileOperateUtils.download(request, response, storeName, contentType, realName);
    }
}
