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

import cn.blaze.domain.StudentInfo;
import cn.blaze.domain.UserInfo;
import cn.blaze.service.LogService;
import cn.blaze.service.StudentInfoService;
import cn.blaze.service.UserInfoService;
import cn.blaze.utils.BlazeConstants;
import cn.blaze.vo.StudentRegisterVo;

/**
 * 学生信息
 * @ClassName StudentController
 * @author LiuLei
 * @date 2017年4月18日 下午7:43:47
 */
@Controller
@RequestMapping("/studentInfo")
public class StudentInfoController extends BaseController{
	@Autowired
	private StudentInfoService studentInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private LogService logService;
	
	/**
	 * @Title forwardStudentRegister
	 * @Description：跳转到注册页面
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardStudentRegister")
	public String forwardStudentRegister(HttpServletRequest request){
		return "studentInfo/student_register";
	}
	
	/**
	 * @Title forwardStudentInfoUpdate
	 * @Description：跳转到学生信息修改
	 * @param request
	 * @param userId 用户表id
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardStudentInfoUpdate")
	public String forwardStudentInfoUpdate(String userId, HttpServletRequest request, HttpServletResponse response){
		if(userId==null || "".equals(userId)){
			printMessage(response, "对不起,用户账号有误!", false);
		}else {
			UserInfo userInfo = userInfoService.queryUserInfoById(userId);// 用户信息
			
			if(userInfo == null){
				printMessage(response, "对不起,用户不存在!", false);
			}else {// 用户存在
				request.setAttribute("userInfo", userInfo);
				String studentId = userInfo.getStudentId();
				if(studentId!=null && !"".equals(studentId)){// 学生id不为空则查询学生信息
					StudentInfo studentInfo = studentInfoService.queryStudentInfoById(studentId);// 学生信息
					request.setAttribute("studentInfo", studentInfo);
				}
			}
		}
		return "studentInfo/studentInfo_update";
	}
	
	/**
	 * @Title updateStudentInfo
	 * @Description：更新学生信息
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("updateStudentInfo")
	public String updateStudentInfo(StudentInfo studentInfo, HttpServletRequest request, HttpServletResponse response){
		UserInfo loginUser = this.getLoginUser(request);
		// 管理员可以修改,否则只能修改自己的信息
		if(loginUserIsAdmin(request) || (loginUser.getStudentId()!=null && loginUser.getStudentId().equals(studentInfo.getId()))){
			studentInfoService.updateStudentInfoById(studentInfo);
			// 添加日志
			logService.insertLog(loginUser.getId(), "更新"+loginUser.getUserName()+"的用户信息");
		}else {
			printMessage(response, "对不起,您无权操作!", false);
		}
		return "redirect:/studentInfo/forwardStudentInfoUpdate";
	}
	
	/**
	 * @Title studentRegister
	 * @Description：学生注册
	 * @param registerVo
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("studentRegister")
	public String studentRegister(StudentRegisterVo registerVo, HttpServletRequest request){
		// TODO 对传入的参数校验?
		registerVo.setCreateTime(new Date());
		studentInfoService.studentRegister(registerVo);
		UserInfo user = userInfoService.queryUserInfoById(registerVo.getId());
		this.saveLoginUser(request, user);//更新登录用户信息
		// 添加日志
		logService.insertLog(user.getId(), "用户"+user.getUserName()+"完成用户信息认证");
		request.setAttribute("user", user);
		return "index/userIndex";
	}
	
	/**
	 * TODO 似乎是垃圾代码
	 * @Title queryStudentInfo
	 * @Description：查询学生信息
	 * @param request
	 * @param response
	 * @return
	 * @user LiuLei 2017年4月30日
	 * @updater：
	 * @updateTime：
	 */
	@ResponseBody
	@RequestMapping("queryStudentInfo")
	public List<Map<String, Object>> queryStudentInfo(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentName", "唐三藏");
		List<Map<String, Object>> mapList = studentInfoService.queryStudentInfoMapByParameterMap(map);
		return mapList;
	}
	
	/**
	 * @Title exportStudentInfo
	 * @Description：导出学生信息
	 * @param request
	 * @param response
	 * @user LiuLei 2017年4月30日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("exportStudentInfo")
	public void exportStudentInfo(HttpServletRequest request, HttpServletResponse response){
		if(loginUserIsAdmin(request)){
			String userName = this.getNotNullValue(request.getParameter("userName"));
			String studentName = this.getNotNullValue(request.getParameter("studentName"));
			String status = this.getNotNullValue(request.getParameter("status"));
			String isvalid = this.getNotNullValue(request.getParameter("isvalid"));
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", userName);
			map.put("studentName", studentName);
			map.put("status", status);
			map.put("isvalid", isvalid);
			map.put("type", BlazeConstants.USER_TYPE_STUDENT);
			
			List<Map<String, Object>> mapList = studentInfoService.queryUserStudentInfoMapByPara(map);
			String[] title = new String[] { "账号", "性别", "创建时间", "更新时间", "状态",
					"是否删除", "姓名", "年龄", "手机", "地址", "邮箱", "微信号", "QQ" };
			String[] column = new String[] { "userName", "sex", "createTime",
					"updateTime", "status", "isvalid","studentName","age","telephone","address","email","wechat","qq"};
			exportExcel("",mapList, column, title, response);
			UserInfo loginUser = getLoginUser(request);
			// 添加日志
			logService.insertLog(loginUser.getId(), "用户"+loginUser.getUserName()+"导出用户信息数据!");
			
		}else {
			printMessage(response, "无权导出数据!", false);
		}
	}
	
	/**
	 * @Title forwardStudentInfoUpdate
	 * @Description：跳转到学生信息查看
	 * @param request
	 * @param userId 用户表id
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardStudentInfoView")
	public String forwardStudentInfoView(String userId, HttpServletRequest request, HttpServletResponse response){
		if(userId==null || "".equals(userId)){
			printMessage(response, "对不起,用户账号有误!", false);
		}else {
			UserInfo userInfo = userInfoService.queryUserInfoById(userId);// 用户信息
			if(userInfo == null){
				printMessage(response, "对不起,用户不存在!", false);
			}else {
				request.setAttribute("userInfo", userInfo);
				String studentId = userInfo.getStudentId();
				if(studentId!=null && !"".equals(studentId)){// 学生id不为空则查询学生信息
					StudentInfo studentInfo = studentInfoService.queryStudentInfoById(studentId);// 学生信息
					request.setAttribute("studentInfo", studentInfo);
				}
			}
		}
		return "studentInfo/studentInfo_update";
	}
}
