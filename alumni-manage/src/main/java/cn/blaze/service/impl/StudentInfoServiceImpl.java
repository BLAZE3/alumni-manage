package cn.blaze.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.StudentInfoDao;
import cn.blaze.domain.StudentInfo;
import cn.blaze.service.StudentInfoService;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
	@Autowired
	private StudentInfoDao studentInfoDao;
	
	@Override
	public void studentRegister(StudentInfo studentInfo) {
		studentInfoDao.insertStudentInfo(studentInfo);
	}

	@Override
	public List<StudentInfo> queryStudentInfoByParameterMap(Map<String, Object> map) {
		List<StudentInfo> list = studentInfoDao.selectByPara(map);
		return list;
	}

}
