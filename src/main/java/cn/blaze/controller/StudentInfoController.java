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
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardStudentInfoUpdate")
	public String forwardStudentInfoUpdate(String studentId, HttpServletRequest request){
//		String studentId = request.getParameter("studentId");// 获取登录的学生信息
		StudentInfo studentInfo = studentInfoService.queryStudentInfoById(studentId);// 学生信息
		UserInfo userInfo = userInfoService.queryUserInfoByStudentId(studentId);// 用户信息
		request.setAttribute("studentInfo", studentInfo);
		request.setAttribute("userInfo", userInfo);
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
	public String updateStudentInfo(StudentInfo studentInfo, HttpServletRequest request){
		studentInfoService.updateStudentInfoById(studentInfo);
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
		return "login";
	}
	
	/**
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
		
		List<Map<String, Object>> mapList = studentInfoService.queryUserStudentInfoMapByParameter(map);
		String[] title = new String[] { "账号", "性别", "创建时间", "更新时间", "状态",
				"是否删除", "姓名", "年龄", "手机", "地址", "邮箱", "微信号", "QQ" };
		String[] column = new String[] { "userName", "sex", "createTime",
				"updateTime", "status", "isvalid","studentName","age","telephone","address","email","wechat","qq"};
		exportExcel("",mapList, column, title, response);
	}
	
}
