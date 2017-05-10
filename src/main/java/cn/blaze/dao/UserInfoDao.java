package cn.blaze.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.blaze.domain.UserInfo;

public interface UserInfoDao {

	/**
	 * @Title insertUserInfoWithIdAuto
	 * @Description：插入用户信息,主键自动生成
	 * @param userInfo
	 * @return 
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	int insertUserInfoWithIdAuto(UserInfo userInfo);

	/**
	 * @Title selectUserInfoByPara
	 * @Description：条件查询用户信息
	 * @param map
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	List<UserInfo> selectUserInfoByPara(Map<String, Object> map);

	/**
	 * @Title selectById
	 * @Description：根据id查询
	 * @param id
	 * @return
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	UserInfo selectById(@Param("id")String id);

	/**
	 * @Title updateById
	 * @Description：根据Id更新
	 * @param db_userInfo
	 * @user LiuLei 2017年4月24日
	 * @updater：
	 * @updateTime：
	 */
	int updateById(UserInfo db_userInfo);

	/**
	 * @Title updateByStudentId
	 * @Description：根据studentId更新
	 * @param db_userInfo 待更新的字段
	 * @return 
	 * @user LiuLei 2017年4月28日
	 * @updater：
	 * @updateTime：
	 */
	int updateByStudentId(UserInfo db_userInfo);

}
