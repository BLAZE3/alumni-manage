package cn.blaze.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blaze.domain.EducationInfo;
import cn.blaze.service.EducationInfoService;
import cn.blaze.vo.EducationInfoVo;

@Controller
@RequestMapping("/educationInfo")
public class EducationInfoController extends BaseController{
	@Autowired
	private EducationInfoService educationInfoService;
	
	/**
	 * @Title forwardEducationInfoPage
	 * @Description：跳转到学历信息页面
	 * @param request
	 * @return
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("forwardEducationInfoPage")
	public String forwardEducationInfoPage(HttpServletRequest request){
//		String studentId = request.getParameter("studentId");
		String studentId = "d8b706386fc446289e0b93c18bd94a72";
		List<EducationInfo> educationInfoList = educationInfoService.findEducationInfoByStudentId(studentId);
		List<EducationInfoVo> educationInfoVoList = new LinkedList<EducationInfoVo>();
		for (EducationInfo educationInfo : educationInfoList) {
			EducationInfoVo educationInfoVo = new EducationInfoVo();
			BeanUtils.copyProperties(educationInfo, educationInfoVo);
			educationInfoVoList.add(educationInfoVo);
		}
		request.setAttribute("educationInfoList", educationInfoVoList);
		return "educationInfo/education_update";
	}
	
	/**
	 * @Title addEducationInfo
	 * @Description：添加学历信息
	 * @param request
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	@RequestMapping("addEducationInfo")
	public void addEducationInfo(EducationInfoVo educationInfoVo, HttpServletRequest request){
		String entranceTimeStr = educationInfoVo.getEntranceTimeStr();
		String graduationTimeStr = educationInfoVo.getGraduationTimeStr();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM");
		
		try {
			Date entrancetime = sf.parse(entranceTimeStr);
			educationInfoVo.setEntranceTime(entrancetime);
			Date graduationtime = sf.parse(graduationTimeStr);
			educationInfoVo.setGraduationTime(graduationtime);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		educationInfoService.addEductionInfo(educationInfoVo);
	}
	
	/**
	 * @Title delEducationById
	 * @Description：根据id删除学历信息
	 * @param request
	 * @user LiuLei 2017年4月25日
	 * @updater：
	 * @updateTime：
	 */
	@ResponseBody
	@RequestMapping("delEducationById")
	public Map<String, Object> delEducationById(HttpServletRequest request){
		String id = request.getParameter("id")!=null?request.getParameter("id"):"";
		if(!"".equals(id)){
			boolean res = educationInfoService.delEducationById(id);
			if(res){
				return buildJsonMap("success", null);
			}
		}
		return buildJsonMap("删除失败,或该条已被删除!", null);
	}
	
}
