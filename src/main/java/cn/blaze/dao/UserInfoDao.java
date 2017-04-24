package cn.blaze.dao;

import cn.blaze.domain.UserInfo;

public interface UserInfoDao {

	/**
	 * @Title insertUserInfoWithIdAuto
	 * @Description：插入用户信息,主键自动生成
	 * @param userInfo
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	void insertUserInfoWithIdAuto(UserInfo userInfo);

}
