package cn.blaze.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.SchoolInfoDao;
import cn.blaze.service.SchoolInfoService;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {
	@Autowired
	private SchoolInfoDao schoolInfoDao;
	
	@Override
	public List<String> queryAllCountry() {
		return schoolInfoDao.selectAllCountry();
	}

	@Override
	public List<String> queryProvinceByCountry(String country) {
		return schoolInfoDao.selectProvinceByCountry(country);
	}

	@Override
	public List<String> queryCityByProvince(String province) {
		return schoolInfoDao.selectCityByProvince(province);
	}

	@Override
	public List<String> querySchoolNameByCity(String city) {
		return schoolInfoDao.selectSchoolNameByCity(city);
	}

}
