package cn.blaze.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.blaze.utils.FileOperateUtils;

/**
 * @ClassName FileOperateController
 * @Description 文件操作
 * @author LiuLei
 * @date 2017年5月8日 下午10:27:52
 */
@Controller
@RequestMapping("/fileOperate")
public class FileOperateController {
	
	/**
	 * @Title forwardUpload
	 * @Description：跳转到上传页面
	 * @return
	 * @user LiuLei 2017年5月8日
	 * @updater：
	 * @updateTime：
	 */
    @RequestMapping("forwardUpload")  
    public String forwardUpload() {  
        return null;
    }
  
    /**
     * @Title upload
     * @Description：文件上传
     * @param request
     * @return
     * @throws Exception
     * @user LiuLei 2017年5月8日
     * @updater：
     * @updateTime：
     */
    @RequestMapping("upload")  
    public String upload(HttpServletRequest request) throws Exception {  
  
        List<Map<String, Object>> result = FileOperateUtils.upload(request);
        return null;
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
  
        String storeName = "201205051340364510870879724.zip";
        String realName = "Java设计模式.zip";
        String contentType = "application/octet-stream";
//        FileOperateUtils.download(request, response, storeName, contentType, realName);
    }
}
