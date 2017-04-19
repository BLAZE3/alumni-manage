package cn.blaze.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.blaze.domain.StudentInfo;

@Repository
public interface StudentInfoDao {

	void insertStudentInfo(StudentInfo studentInfo);
	
	StudentInfo selectbyId(@Param("id")String id);
	
	List<StudentInfo> selectByPara(Map<String, Object> map);

}
