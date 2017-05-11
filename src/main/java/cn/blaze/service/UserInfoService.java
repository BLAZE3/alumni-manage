package cn.blaze.service;

import java.util.List;
import java.util.Map;

import cn.blaze.domain.StudentInfo;
import cn.blaze.domain.UserInfo;
import cn.blaze.vo.UserInfoVo;


public interface UserInfoService {

	/**
	 * @Title queryUserInfoById
	 * @Description：根据Id查找用户信息
	 * @param id
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	UserInfo queryUserInfoById(String id);

	/**
	 * @Title updateUserInfoById
	 * @Description：根据id更新用户信息
	 * @param db_userInfo 存放待更新的字段
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	int updateUserInfoById(UserInfo db_userInfo);
	
	/**
	 * @Title updateUserInfoByStudentId
	 * @Description：根据studentId更新用户信息
	 * @param db_userInfo 存放待更新的字段
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	int updateUserInfoByStudentId(UserInfo db_userInfo);

	/**
	 * @Title queryUserInfoByStudentId
	 * @Description：根据学生信息系表Id查询学生的用户信息
	 * @param studentId
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	UserInfo queryUserInfoByStudentId(String studentId);

	/**
	 * @Title queryUserInfoByParameter
	 * @Description：条件查询用户信息
	 * @param map
	 * @return
	 * @user LiuLei 2017年4月25日
	 * @updater：
	 * @updateTime：
	 */
	List<UserInfo> queryUserInfoByParameter(Map<String, Object> map);

	/**
	 * @Title queryUserInfoByUserNameAndPassword
	 * @Description：根据用户名密码查询用户信息
	 * @param map 存储用户名userName、密码password和用户类型type
	 * @return  查询不到返回null
	 * @user LiuLei 2017年4月25日
	 * @updater：
	 * @updateTime：
	 */
	UserInfo queryUserInfoByUserNameAndPassword(Map<String, Object> map);

	/**
	 * @Title cancelUserByStudentId
	 * @Description：注销用户
	 * @param studentId
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	int cancelUserByStudentId(String studentId);

	/**
	 * @Title enableUserByStudentId
	 * @Description：启用被注销的账号
	 * @param studentId
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	int enableUserByStudentId(String studentId);

	/**
	 * @Title resetuserPasswordById
	 * @Description：根据用户id重置用户密码为000000
	 * @param id 用户id
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	int resetuserPasswordById(String id);

	/**
	 * @Title cancelUserById
	 * @Description：根据用户id注销用户
	 * @param id
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	int cancelUserById(String id);

	/**
	 * @Title enableUserById
	 * @Description：根据用户id启用
	 * @param id
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	int enableUserById(String id);

	/**
	 * @Title userRegister
	 * @Description：用户注册
	 * @param userInfo
	 * @user LiuLei 2017年5月4日
	 * @updater：
	 * @updateTime：
	 */
	int userRegister(UserInfo userInfo);

	/**
	 * @Title importExcelRegister
	 * @Description：excel导入时注册
	 * @param user
	 * @param student
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	int importExcelRegister(UserInfo user, StudentInfo student);

}
