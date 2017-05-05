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
import cn.blaze.utils.BlazeConstants;
import cn.blaze.utils.CommonUtils;
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
		/***插入学生信息***/
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
		
		/***更新用户信息,使用户信息与学生信息表关联***/
		UserInfo userInfo = new UserInfo();
		userInfo.setId(registerVo.getId());
		userInfo.setType(BlazeConstants.USER_TYPE_STUDENT);// type设置为1 表示学生
		userInfo.setStudentId(studentInfo.getId());// 更新用户的学生信息
		userInfoDao.updateById(userInfo);
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

	@Override
	public List<StudentRegisterVo> queryUserStudentInfoByPara(Map<String, Object> map) {
		return studentInfoDao.selectUserStudentInfoByPara(map);
	}

	@Override
	public String queryUserStudentInfoByParameterForLigerUI(Map<String, Object> map, String sortName, 
			String sortOrder, int page, int pageSize) {
		int total = this.queryUserStudentInfoCountByPara(map);
		
		map.put("sortName", sortName);
		map.put("sortOrder", sortOrder);
		map.put("start", String.valueOf((page-1)*pageSize));
		map.put("pageSize", String.valueOf(pageSize));
		List<StudentRegisterVo> list = this.queryUserStudentInfoByPara(map);
		return CommonUtils.list2FlexigridJson(page+"", list, String.valueOf(total));
	}

	@Override
	public int queryUserStudentInfoCountByPara(Map<String, Object> map) {
		return studentInfoDao.queryUserStudentInfoCountByPara(map);
	}

	@Override
	public List<Map<String, Object>> queryUserStudentInfoMapByPara(Map<String, Object> map) {
		return studentInfoDao.selectUserStudentInfoMapByPara(map);
	}

}
