package cn.blaze.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.blaze.domain.StudentInfo;

@Repository
public interface StudentInfoDao {

	/**
	 * 插入学生信息,包括主键
	 * @Title insertStudentInfo
	 * @Description：
	 * @param studentInfo
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	void insertStudentInfo(StudentInfo studentInfo);
	
	/**
	 * 插入学生信息,主键自动生成
	 * @Title insertStudentInfoWithIdAuto
	 * @Description：
	 * @param studentInfo
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	void insertStudentInfoWithIdAuto(StudentInfo studentInfo);
	
	List<StudentInfo> selectByPara(Map<String, Object> map);

	List<Map<String, Object>> selectMapByPara(Map<String, Object> map);

	StudentInfo selectById(String studentId);

}
