package cn.blaze.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.UserInfoDao;
import cn.blaze.domain.StudentInfo;
import cn.blaze.domain.UserInfo;
import cn.blaze.service.MailService;
import cn.blaze.service.StudentInfoService;
import cn.blaze.service.UserInfoService;
import cn.blaze.utils.BlazeConstants;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private StudentInfoService studentInfoService;
	@Autowired
	private MailService mailService;
	
	@Override
	public UserInfo queryUserInfoById(String id) {
		return userInfoDao.selectById(id);
	}

	@Override
	public void updateUserInfoById(UserInfo db_userInfo) {
		userInfoDao.updateById(db_userInfo);
	}

	@Override
	public UserInfo queryUserInfoByStudentId(String studentId) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("studentId", studentId);
		List<UserInfo> list = userInfoDao.selectUserInfoByPara(map);
		return list!=null?list.get(0):null;
	}

	@Override
	public List<UserInfo> queryUserInfoByParameter(Map<String, Object> map) {
		map.put("isvaild", BlazeConstants.ISVALID_YES);
		return userInfoDao.selectUserInfoByPara(map);
	}

	@Override
	public UserInfo queryUserInfoByUserNameAndPassword(Map<String, Object> map) {
		List<UserInfo> list = this.queryUserInfoByParameter(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void cancelUserByStudentId(String studentId) {
		UserInfo user = new UserInfo();
		user.setIsvalid(BlazeConstants.ISVALID_NO);
		user.setStudentId(studentId);
		this.updateUserInfoByStudentId(user);;
	}

	@Override
	public void updateUserInfoByStudentId(UserInfo db_userInfo) {
		userInfoDao.updateByStudentId(db_userInfo);
	}

	@Override
	public void enableUserByStudentId(String studentId) {
		UserInfo user = new UserInfo();
		user.setIsvalid(BlazeConstants.ISVALID_YES);
		user.setStudentId(studentId);
		this.updateUserInfoByStudentId(user);
	}

	@Override
	public void resetuserPasswordById(String id) {
		UserInfo user = new UserInfo();
		String password = RandomStringUtils.randomNumeric(6);;
		user.setPassword(password);
		user.setId(id);
		this.updateUserInfoById(user);
		// 如果是学生用户,则发送邮件
		UserInfo db_user = this.queryUserInfoById(id);
		if(BlazeConstants.USER_TYPE_STUDENT.equals(db_user.getType())){//是学生
			StudentInfo student = studentInfoService.queryStudentInfoById(db_user.getStudentId());
			mailService.sendMail(student.getEmail(), "校友管理系统密码重置--"+user.getUserName(), "您的密码已经重置为:"+password);
		}
	}

	@Override
	public void cancelUserById(String id) {
		UserInfo user = new UserInfo();
		user.setIsvalid(BlazeConstants.ISVALID_NO);
		user.setId(id);
		this.updateUserInfoById(user);
	}

	@Override
	public void enableUserById(String id) {
		UserInfo user = new UserInfo();
		user.setIsvalid(BlazeConstants.ISVALID_YES);
		user.setId(id);
		this.updateUserInfoById(user);
	}
	
}
