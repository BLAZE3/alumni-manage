package cn.blaze.service;

import cn.blaze.domain.UserInfo;


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
	 * @param db_userInfo
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	void updateUserInfoById(UserInfo db_userInfo);

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

}
