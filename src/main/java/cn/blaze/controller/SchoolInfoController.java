package cn.blaze.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blaze.service.SchoolInfoService;

/**
 * @ClassName SchoolInfoController
 * @Description 学校
 * @author LiuLei
 * @date 2017年5月11日 下午11:33:31
 */
@Controller
@RequestMapping("/school")
public class SchoolInfoController extends BaseController{
	@Autowired
	private SchoolInfoService schoolInfoService;
	
	@ResponseBody
	@RequestMapping("queryAllCountry")
	public List<String> queryAllCountry(HttpServletRequest request, HttpServletResponse response){
		List<String> countryList = schoolInfoService.queryAllCountry();
		return countryList;
	}
	
	@ResponseBody
	@RequestMapping("queryProvinceByCountry")
	public List<String> queryProvinceByCountry(HttpServletRequest request, HttpServletResponse response){
		String para = getNotNullValue(request.getParameter("country"));
		List<String> provinceList = schoolInfoService.queryProvinceByCountry(para);
		return provinceList;
	}
	
	@ResponseBody
	@RequestMapping("queryCityByProvince")
	public List<String> queryCityByProvince(HttpServletRequest request, HttpServletResponse response){
		String para = getNotNullValue(request.getParameter("province"));
		List<String> cityList = schoolInfoService.queryCityByProvince(para);
		return cityList;
	}

	@ResponseBody
	@RequestMapping("querySchoolNameByCity")
	public List<String> querySchoolNameByCity(HttpServletRequest request, HttpServletResponse response){
		String para = getNotNullValue(request.getParameter("city"));
		List<String> schoolList = schoolInfoService.querySchoolNameByCity(para);
		return schoolList;
	}
}
