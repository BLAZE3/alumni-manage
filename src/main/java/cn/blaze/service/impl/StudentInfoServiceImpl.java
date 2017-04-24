package cn.blaze.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.StudentInfoDao;
import cn.blaze.dao.UserInfoDao;
import cn.blaze.domain.StudentInfo;
import cn.blaze.domain.UserInfo;
import cn.blaze.service.StudentInfoService;
import cn.blaze.utils.SystemUtils;
import cn.blaze.vo.StudentRegisterVo;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
	@Autowired
	private StudentInfoDao studentInfoDao;
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public void studentRegister(StudentRegisterVo registerVo) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setId(SystemUtils.buildUniqueId());
		studentInfo.setAddress(registerVo.getAddress());
		studentInfo.setAge(registerVo.getAge());
		studentInfo.setEmail(registerVo.getEmail());
		studentInfo.setImagePath(registerVo.getImagePath());
		studentInfo.setQq(registerVo.getQq());
		studentInfo.setStudentName(registerVo.getStudentName());
		studentInfo.setTelephone(registerVo.getTelephone());
		studentInfo.setWechat(registerVo.getWechat());
		studentInfoDao.insertStudentInfo(studentInfo);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setIsvalid("Y");// 有效性设置为Y 有效
		userInfo.setUserName(registerVo.getUserName());//用户名
		userInfo.setPassword(registerVo.getPassword());//密码
		userInfo.setStatus("0");// 状态0 表示待审核
		userInfo.setStudentId(studentInfo.getId());
		userInfo.setType("1");// type设置为1 表示学生
		userInfoDao.insertUserInfoWithIdAuto(userInfo);
	}

	@Override
	public List<StudentInfo> queryStudentInfoByParameterMap(Map<String, Object> map) {
		List<StudentInfo> list = studentInfoDao.selectByPara(map);
		return list;
	}

	@Override
	public List<Map<String, Object>> queryStudentInfoMapByParameterMap(Map<String, Object> map) {
		List<Map<String, Object>> mapList = studentInfoDao.selectMapByPara(map);
		return mapList;
	}

	@Override
	public StudentInfo queryStudentInfoById(String studentId) {
		return studentInfoDao.selectById(studentId);
	}

	@Override
	public void updateStudentInfoById(StudentInfo studentInfo) {
		studentInfoDao.updateById(studentInfo);
	}

}
