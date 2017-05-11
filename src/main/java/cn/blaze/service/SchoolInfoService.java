package cn.blaze.service;

import java.util.List;

public interface SchoolInfoService {

	List<String> queryAllCountry();

	List<String> queryProvinceByCountry(String country);

	List<String> queryCityByProvince(String province);

	List<String> querySchoolNameByCity(String city);

}
