package cn.blaze.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.EducationInfoDao;
import cn.blaze.domain.EducationInfo;
import cn.blaze.service.EducationInfoService;
import cn.blaze.vo.EducationInfoVo;

@Service
public class EducationInfoServiceImpl implements EducationInfoService {
	@Autowired
	private EducationInfoDao educationInfoDao;
	
	@Override
	public void addEductionInfo(EducationInfoVo educationInfoVo) {
		EducationInfo educationInfo = new EducationInfo();
		BeanUtils.copyProperties(educationInfoVo, educationInfo);
		educationInfoDao.insertEducationInfoWithAutoId(educationInfo);
		System.out.println("ok");
	}

	@Override
	public List<EducationInfo> findEducationInfoByStudentId(String studentId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("studentId", studentId);
		return educationInfoDao.selectByParameters(map);
	}

}
