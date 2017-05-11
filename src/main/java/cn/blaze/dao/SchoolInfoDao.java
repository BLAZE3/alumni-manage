package cn.blaze.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SchoolInfoDao {
	
	/**
	 * @Title selectAllCountry
	 * @Description：所有国家
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	List<String> selectAllCountry();
	
	/**
	 * @Title selectProvinceByCountry
	 * @Description：所有省
	 * @param country
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	List<String> selectProvinceByCountry(@Param("country")String country);
	
	/**
	 * @Title selectCityByProvince
	 * @Description：所有城市
	 * @param province
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	List<String> selectCityByProvince(@Param("province")String province);
	
	/**
	 * @Title selectSchoolNameByCity
	 * @Description：所有学校名
	 * @param city
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	List<String> selectSchoolNameByCity(@Param("city")String city);
	
}
