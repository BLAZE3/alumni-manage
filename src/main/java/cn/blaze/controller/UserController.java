package cn.blaze.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blaze.domain.StudentInfo;
import cn.blaze.domain.UserInfo;
import cn.blaze.service.MailService;
import cn.blaze.service.StudentInfoService;
import cn.blaze.service.UserInfoService;
import cn.blaze.utils.BlazeConstants;
import cn.blaze.utils.CommonUtils;
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
	@Autowired 
	private StudentInfoService studentInfoService;
	@Autowired
	private MailService mailService;
	/**
	 * @Title forwardQueryUserInfo
	 * @Description：跳转到用户信息列表
	 * @param type 用户的类型 admin-管理员,student-学生
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardQueryUserInfo")
	public String forwardQueryUserInfo(String type, HttpServletRequest request){
		if("admin".equals(type)){
			return "userInfo/userInfo_admin";
		}else {
			return "userInfo/userInfo_student";
		}
	}
	
	/**
	 * @Title queryAllUserStudentInfo
	 * @Description：查询所有用户学生信息
	 * @param type 用户的类型 admin-管理员,student-学生
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	@ResponseBody
	@RequestMapping("queryUserInfoJson")
	public String queryUserInfoJson(String type, HttpServletRequest request){
		
		if(!this.isRealUser(request)){// 不是认证用户,过滤数据
			return CommonUtils.list2FlexigridJson("1", null, "0");
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			if("admin".equals(type) && loginUserIsAdmin(request)){// 管理员列表数据-管理员才能看
				map.put("type",BlazeConstants.USER_TYPE_ADMIN);
			}else {// 学生类表数据
				map.put("type",BlazeConstants.USER_TYPE_STUDENT);
			}
			String userName = this.getNotNullValue(request.getParameter("userName"));
			String studentName = this.getNotNullValue(request.getParameter("studentName"));
			String status = this.getNotNullValue(request.getParameter("status"));
			String isvalid = this.getNotNullValue(request.getParameter("isvalid"));
			map.put("userName", userName);
			map.put("studentName", studentName);
			map.put("status", status);
			map.put("isvalid", isvalid);
			
			String sortName = this.getNotNullValue(request.getParameter("sortname"));
			String sortOrder = this.getNotNullValue(request.getParameter("sortorder"));
			int page = this.getNotNullValueToInt(request.getParameter("page"));
			int size = this.getNotNullValueToInt(request.getParameter("pagesize"));
			
			if(loginUserIsAdmin(request)){// 是管理员用户,添加可操作标记
				request.setAttribute("operate_tag", "yes");
			}
			
			return studentInfoService.queryUserStudentInfoByParameterForLigerUI(map, sortName, sortOrder, page, size);
		}
	}
	
	/**
	 * @Title resetUserPasswordById
	 * @Description：根据用户id重置用户密码
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	@ResponseBody
	@RequestMapping("resetUserPasswordById")
	public Map<String, Object> resetUserPasswordById(HttpServletRequest request){
		String id = getNotNullValue(request.getParameter("id"));
		UserInfo loginUser = this.getLoginUser(request);
		// 判断是否是管理员,管理员才具有重置密码权限
		if(!BlazeConstants.USER_TYPE_ADMIN.equals(loginUser.getType())){// 不是管理员无权重置
			return buildJsonMap("fail", "不是管理员无权操作");
		}
		userInfoService.resetuserPasswordById(id);
		return buildJsonMap("success", "");
	}
	
	/**
	 * @Title cancelUser
	 * @Description：注销/恢复用户
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	@ResponseBody
	@RequestMapping("changeUserValidById")
	public Map<String, Object> changeUserValidById(HttpServletRequest request){
		String id = getNotNullValue(request.getParameter("id"));
		String isvalid = getNotNullValue(request.getParameter("isvalid"));
		
		if(!BlazeConstants.USER_TYPE_ADMIN.equals(this.getLoginUser(request).getType())){// 不是管理员无权注销
			return buildJsonMap("fail", "不是管理员无权操作");
		}
		
		if(BlazeConstants.ISVALID_NO.equals(isvalid)){
			int res = userInfoService.cancelUserById(id);
			if(res > 0){
				// TODO 添加日志--注销成功
			}
		}else if(BlazeConstants.ISVALID_YES.equals(isvalid)){
			int res = userInfoService.enableUserById(id);
			if(res > 0){
				// TODO 添加日志--恢复成功
			}
		}
		return buildJsonMap("success", "");
	}

	/**
	 * @Title userLogin
	 * @Description：跳转到用户登录界面
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("userLogin")
	public String userLogin(HttpServletRequest request){
		return "index/login";
	}
	
	/**
	 * @Title adminLogin
	 * @Description：跳转到管理员用户登录界面
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("admin")
	public String adminLogin(HttpServletRequest request){
		return "index/adminLogin";
	}
	
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
	public String login(UserInfo userInfo, HttpServletRequest request){
		String userName = userInfo.getUserName()!=null?userInfo.getUserName():"";
		String password = userInfo.getPassword()!=null?userInfo.getPassword():"";
		String type = userInfo.getType()!=null?userInfo.getType():"";
		
		if(!"".equals(userName) && !"".equals(password)){
			
			Map<String, Object> map = new HashMap<String, Object>(2);
			map.put("userName", userName);
			map.put("password", password);
			map.put("type", type);
			CommonUtils.removeNullValue(map);
			UserInfo user = userInfoService.queryUserInfoByUserNameAndPassword(map);
			
			if(user != null){// 用户存在
				if(BlazeConstants.USER_TYPE_ADMIN.equals(type)){// 管理员登录
					this.saveLoginUser(request, user);// 保存用户信息到session
					return "index/adminIndex";
				}else {// 学生或者普通用户登录
					this.saveLoginUser(request, user);// 保存用户信息到session
					request.setAttribute("user", user);
					return "index/userIndex";
				}
			}
		}
		
		request.setAttribute("msg", "用户名或密码错误!");
		/***** 登录失败  *****/
		if(BlazeConstants.USER_TYPE_ADMIN.equals(type)){// 管理员登录
			return "index/adminLogin";
		}else {// 学生登录
			return "index/login";
		}
	}
	
	/**
	 * @Title logout
	 * @Description：用户登出,注销
	 * @param request
	 * @return
	 * @user LiuLei 2017年5月6日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute(BlazeConstants.SESSION_SAVE_LOGIN);// 用户注销
		return "index/login";
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
		UserInfo user = this.getLoginUser(request);
		request.setAttribute("userInfo", user);
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
		UserInfo loginUser = this.getLoginUser(request);
		// 管理员可以修改,否则只能修改自己密码
		if(loginUserIsAdmin(request) || (loginUser.getId()!=null && loginUser.getId().equals(userInfoVo.getId()))){
			UserInfo db_userInfo = userInfoService.queryUserInfoById(userInfoVo.getId());
			String pwd = db_userInfo.getPassword();
			if(pwd!=null && pwd.equals(userInfoVo.getPassword())){
				db_userInfo.setPassword(userInfoVo.getNewPassword());
				db_userInfo.setUpdateTime(new Date());
				int res = userInfoService.updateUserInfoById(db_userInfo);
				if(res > 0){
					// TODO 添加日志
				}
				return buildJsonMap("success", null);
			}else {
				return buildJsonMap("密码错误,请重新输入正确密码!", null);
			}
			
		}else {
			return buildJsonMap("你没有操作权限!", null);
		}
		
	}
	
	/**
	 * @Title userRegister
	 * @Description：用户注册
	 * @param userInfo
	 * @param request
	 * @return
	 * @user LiuLei 2017年5月4日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("userRegister")
	public String userRegister(UserInfo userInfo, HttpServletRequest request){
		userInfo.setCreateTime(new Date());
		userInfo.setIsvalid(BlazeConstants.ISVALID_YES);
		userInfo.setType(BlazeConstants.USER_TYPE_COMMON);
		userInfo.setStatus("0");
		int res = userInfoService.userRegister(userInfo);
		if(res > 0){
			// TODO 添加日志
		}
		return "index/login";
	}
	
	/**
	 * @Title forwardImportExcel
	 * @Description：跳转到导入页面
	 * @param request
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardImportExcel")
	public String forwardImportExcel(HttpServletRequest request){
		return "file/importExcel";
	}
	
	/**
	 * @Title importExcels
	 * @Description：数据导入
	 * @param request
	 * @param response
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("importExcels")
	public String importExcels(HttpServletRequest request, HttpServletResponse response) {
		Workbook readwb = null;
		List<String> errorList = new ArrayList<String>();//存储导入的错误信息
		try {
//			List<UserInfo> userList = new ArrayList<UserInfo>();
//			List<StudentInfo> studentList = new ArrayList<StudentInfo>();
			
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			InputStream instream = new FileInputStream("E:/test.xls");
			readwb = Workbook.getWorkbook(instream);
			// 获取第一张Sheet表 ,Sheet的下标是从0开始
			Sheet sheet = readwb.getSheet(0);
//			// 获取Sheet表中所包含的总列数
//			int rsColumns = sheet.getColumns();
			// 获取Sheet表中所包含的总行数
			int rsRows = sheet.getRows();
	
			int beginRowIndex = 1;// 开始行,第一行为0
			// 获取指定单元格的对象引用
			for (int rowIndex = beginRowIndex; rowIndex < rsRows; rowIndex++) {
				Cell[] cells 		= sheet.getRow(rowIndex);// 读取每一行
				String userName 	= getNotNullValue(cells[0].getContents()).trim();// 账户名-必填
				String sex 			= getNotNullValue(cells[1].getContents()).trim();// 性别
				String studentName 	= getNotNullValue(cells[2].getContents()).trim();// 姓名-必填
				String age 			= getNotNullValue(cells[3].getContents()).trim();// 年龄
				String tel 			= getNotNullValue(cells[4].getContents()).trim();// 手机
				String address 		= getNotNullValue(cells[5].getContents()).trim();// 地址
				String email 		= getNotNullValue(cells[6].getContents()).trim();// 邮箱-必填
				String wechat 		= getNotNullValue(cells[7].getContents()).trim();// 微信
				String qq 			= getNotNullValue(cells[8].getContents()).trim();// QQ
				
				if("".equals(userName)){
					errorList.add("第"+rowIndex+"行账号名不可为空");
					continue;
				}else if("".equals(studentName)){
					errorList.add("第"+rowIndex+"行姓名不可为空");
					continue;
				}else if("".equals(email)){
					errorList.add("第"+rowIndex+"行邮箱不可为空");
					continue;
				}else if("".equals(age)){
					try {
						Integer.parseInt(age);// 判断年龄转换是否会有异常
					} catch (Exception e) {
						errorList.add("第"+rowIndex+"行年龄有误");
						continue;
					}
				}else {
					
					StudentInfo student = new StudentInfo();
					student.setAge(Integer.parseInt(age));
					student.setEmail(email);
					student.setAddress(address);
					student.setQq(qq);
					student.setTelephone(tel);
					student.setStudentName(studentName);
					student.setWechat(wechat);
					student.setSex(sex);
					student.setId(CommonUtils.buildUniqueId());
					
					UserInfo user = new UserInfo();
					user.setUserName(userName);
					user.setCreateTime(new Date());
					user.setStatus("0");
					user.setPassword(userName);
					user.setIsvalid(BlazeConstants.ISVALID_YES);
					user.setStudentId(student.getId());
					user.setId(CommonUtils.buildUniqueId());
//					userList.add(user);
//					studentList.add(student);
					
					try {
						userInfoService.importExcelRegister(user, student);
					} catch (Exception e) {
						e.printStackTrace();
						errorList.add("第"+rowIndex+"行插入错误");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(readwb != null)
				readwb.close();
		}
		int error_count = errorList.size();
		if(error_count>0){
			request.setAttribute("error_count", error_count);
			request.setAttribute("error_list", errorList);
		}else {
			request.setAttribute("operate", "close");
		}
		return "file/importExcel";// 跳回导入页面
	}
}
