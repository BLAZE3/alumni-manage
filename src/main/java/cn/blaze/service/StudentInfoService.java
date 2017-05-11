package cn.blaze.service;

import java.util.List;
import java.util.Map;

import cn.blaze.domain.StudentInfo;
import cn.blaze.vo.StudentRegisterVo;
import cn.blaze.vo.UserInfoVo;

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

	/**
	 * @Title queryUserStudentInfoByParameter
	 * @Description：条件查询用户学生信息
	 * @param map
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	List<StudentRegisterVo> queryUserStudentInfoByPara(Map<String, Object> map);
	
	/**
	 * @Title queryUserStudentInfoMapByParameter
	 * @Description：条件查询用户学生信息
	 * @param map 条件
	 * @return 返回map封装的用户学生信息
	 * @user LiuLei 2017年5月4日
	 * @updater：
	 * @updateTime：
	 */
	List<Map<String, Object>> queryUserStudentInfoMapByPara(Map<String, Object> map);
	
	/**
	 * @Title queryUserStudentInfoByParameterForLigerUI
	 * @Description：分页条件查询学生用户信息或管理员用户信息 供ligui显示
	 * @param map 条件
	 * @param sortName 排序的列
	 * @param sortOrder 排序方式
	 * @param page 当前页
	 * @param size 页面显示数据条数
	 * @return
	 * @user LiuLei 2017年4月30日
	 * @updater：
	 * @updateTime：
	 */
	String queryUserStudentInfoByParameterForLigerUI(Map<String, Object> map, String sortName,String sortOrder, int page, int size);
	
	/**
	 * @Title queryUserStudentInfoCountByPara
	 * @Description：统计用户学生信息的条数
	 * @param map 条件
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	int queryUserStudentInfoCountByPara(Map<String, Object> map);

	/**
	 * @Title insertStudent
	 * @Description：注册用户
	 * @param student
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	int insertStudent(StudentInfo student);
}
