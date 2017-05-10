package cn.blaze.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
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
import cn.blaze.utils.CommonUtils;
import cn.blaze.utils.FileOperateUtils;

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
		FileResources resource = fileResourcesService.queryFileResourcesById(id);
		FileResources fileVo = new FileResources();
		BeanUtils.copyProperties(resource, fileVo);
		request.setAttribute("file", fileVo);
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
		if("recycle".equals(type)){// 回收站
			request.setAttribute("is_recycle", "yes");
			if(loginUserIsAdmin(request)){
				request.setAttribute("file_restore", "yes");
			}
		}else {
			if(loginUserIsAdmin(request)){
				request.setAttribute("file_cancel", "yes");
			}
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
		if(!this.isRealUser(request)){// 不是认证用户,过滤数据
			return CommonUtils.list2FlexigridJson("1", null, "0");
		}else {
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
			return fileResourcesService.queryFileResourcesVoByParamForLigerUI(map, sortName, sortOrder, page, size);
		}
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
    			// TODO 添加日志
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
     * @Description：文件下载,需给出资源的id
     * @param request
     * @param response
     * @throws Exception
     * @user LiuLei 2017年5月8日
     * @updater：
     * @updateTime：
     */
    @RequestMapping("download")  
    public void download(HttpServletRequest request,  
            HttpServletResponse response) throws Exception {
    	if(this.isRealUser(request)){// 注册的用户有权下载
    		String id = this.getNotNullValue(request.getParameter("id"));
    		FileResources file = fileResourcesService.queryFileResourcesById(id);
    		if(BlazeConstants.ISVALID_YES.equals(file.getIsvalid())){
    			String res = FileOperateUtils.download(response, file.getFilePath(), "", file.getFileName());
    			if(!"success".equals(res)){// 下载错误是返回错误信息
    				printMessage(response, res, false);
    			}else {
    				fileResourcesService.updateFileResourceDownCount(file);
    			}
    		}else {
    			printMessage(response, "对不起,该资源已失效!", false);
    		}
    	}else {// 未注册无权下载
    		printMessage(response, "对不起,为注册用户无权下载!", false);
    	}
    }
    
    /**
     * @Title cancelFile
     * @Description：删除资源(软删)
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @user LiuLei 2017年5月10日
     * @updater：
     * @updateTime：
     */
    @ResponseBody
    @RequestMapping("cancelFile")  
    public String cancelFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if(loginUserIsAdmin(request)){
    		String id = this.getNotNullValue(request.getParameter("id"));
    		int res = fileResourcesService.cancelFileResourceById(id);
    		if(res > 0){
    			// TODO 添加日志-删除成功
    		}
    		return "success";
    	}else {
    		printMessage(response, "未登录或权限不足!", false);
    		return "fail";
    	}
    }
    
    /**
     * @Title cancelFile
     * @Description：恢复资源
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @user LiuLei 2017年5月10日
     * @updater：
     * @updateTime：
     */
    @ResponseBody
    @RequestMapping("restoreFile")  
    public String restoreFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if(loginUserIsAdmin(request)){
    		String id = this.getNotNullValue(request.getParameter("id"));
    		int res = fileResourcesService.restoreFileResourceById(id);
    		if(res > 0){
    			// TODO 添加日志-恢复成功
    		}
    		return "success";
    	}else {
    		printMessage(response, "未登录或权限不足!", false);
    		return "fail";
    	}
    }
}
