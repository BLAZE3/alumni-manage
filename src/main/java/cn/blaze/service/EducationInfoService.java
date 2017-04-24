package cn.blaze.service;

import java.util.List;

import cn.blaze.domain.EducationInfo;
import cn.blaze.vo.EducationInfoVo;

public interface EducationInfoService {

	/**
	 * @Title addEductionInfo
	 * @Description：增加学历信息
	 * @param educationInfoVo
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	void addEductionInfo(EducationInfoVo educationInfoVo);

	/**
	 * @Title findEducationInfoByStudentId
	 * @Description：根据studentId查询学生的学历信息
	 * @param studentId
	 * @return
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	List<EducationInfo> findEducationInfoByStudentId(String studentId);

}
