package cn.blaze.dao;

import java.util.List;
import java.util.Map;

import cn.blaze.domain.EducationInfo;

public interface EducationInfoDao {

	/**
	 * @Title insertEducationInfoWithAutoId
	 * @Description：插入学历信息,主键自动生成
	 * @param educationInfo
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	void insertEducationInfoWithAutoId(EducationInfo educationInfo);

	/**
	 * @Title selectByParameters
	 * @Description：条件查询学生学历信息
	 * @param map 条件
	 * @return
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	List<EducationInfo> selectByParameters(Map<String, Object> map);

	/**
	 * @Title deleteById
	 * @Description：根据id删除
	 * @param id
	 * @return 受影响条数
	 * @user LiuLei 2017年4月25日
	 * @updater：
	 * @updateTime：
	 */
	int deleteById(String id);

}
