package cn.blaze.service;

import java.util.List;
import java.util.Map;

import cn.blaze.domain.StudentInfo;

public interface StudentInfoService {

	void studentRegister(StudentInfo studentInfo);

	List<StudentInfo> queryStudentInfoByParameterMap(Map<String, Object> map);
}
