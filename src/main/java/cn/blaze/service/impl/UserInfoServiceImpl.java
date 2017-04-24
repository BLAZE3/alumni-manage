package cn.blaze.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.UserInfoDao;
import cn.blaze.domain.UserInfo;
import cn.blaze.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo queryStudentInfoByStudentId(String studentId) {
		return null;
	}
	
}
