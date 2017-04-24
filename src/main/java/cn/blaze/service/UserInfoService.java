package cn.blaze.service;

import cn.blaze.domain.UserInfo;


public interface UserInfoService {

	/**
	 * @Title queryStudentInfoByStudentId
	 * @Description：根据学生信息表主键查找用户信息
	 * @param studentId
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	UserInfo queryStudentInfoByStudentId(String studentId);

}
