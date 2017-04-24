package cn.blaze.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blaze.domain.UserInfo;
import cn.blaze.service.UserInfoService;
import cn.blaze.vo.UserInfoVo;

/**
 * @ClassName UserController
 * @Description 用户登录
 * @author LiuLei
 * @date 2017年4月17日 下午7:44:54
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * @Title login
	 * @Description：用户登录
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月17日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request){
		return "login";
	}
	
	/**
	 * @Title forwardUpdatePassword
	 * @Description：跳转到修改密码页面
	 * @param userInfoVo
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardUpdatePassword")
	public String forwardUpdatePassword(HttpServletRequest request){
		String studentId = request.getParameter("studentId");
		studentId="d8b706386fc446289e0b93c18bd94a72";
		UserInfo userInfo = userInfoService.queryUserInfoByStudentId(studentId);
		request.setAttribute("userInfo", userInfo);
		return "userInfo/update_password";
	}
	
	/**
	 * @Title updatePassword
	 * @Description：修改用户密码
	 * @param userInfoVo
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	@ResponseBody
	@RequestMapping("updatePassword")
	public Object updatePassword(UserInfoVo userInfoVo, HttpServletRequest request){
		UserInfo db_userInfo = userInfoService.queryUserInfoByStudentId(userInfoVo.getStudentId());
		String pwd = db_userInfo.getPassword();
		if(pwd!=null && pwd.equals(userInfoVo.getPassword())){
			db_userInfo.setPassword(userInfoVo.getNewPassword());
			userInfoService.updateUserInfoById(db_userInfo);
			return buildJsonMap("success", null);
		}
		return buildJsonMap("密码错误,请重新输入正确密码!", null);
	}
}
