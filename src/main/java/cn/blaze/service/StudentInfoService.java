package cn.blaze.service;

import java.util.List;
import java.util.Map;

import cn.blaze.domain.StudentInfo;
import cn.blaze.vo.StudentRegisterVo;

public interface StudentInfoService {

	/**
	 * @Title studentRegister
	 * @Description：学会注册
	 * @param registerVo
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	void studentRegister(StudentRegisterVo registerVo);

	/**
	 * @Title queryStudentInfoByParameterMap
	 * @Description：条件查询,查询结果是学生信息对象对应的map
	 * @param map 条件
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	List<StudentInfo> queryStudentInfoByParameterMap(Map<String, Object> map);
	
	/**
	 * @Title queryStudentInfoMapByParameterMap
	 * @Description：条件查询
	 * @param map
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	List<Map<String, Object>> queryStudentInfoMapByParameterMap(Map<String, Object> map);

	/**
	 * @Title queryStudentInfoById
	 * @Description：根据主键查询
	 * @param studentId
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	StudentInfo queryStudentInfoById(String studentId);

	/**
	 * @Title updateStudentInfoById
	 * @Description：根据Id更新学生信息
	 * @param studentInfo
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	void updateStudentInfoById(StudentInfo studentInfo);
}
