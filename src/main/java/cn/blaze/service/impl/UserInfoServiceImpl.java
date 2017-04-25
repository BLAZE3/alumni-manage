package cn.blaze.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public UserInfo queryUserInfoById(String id) {
		return userInfoDao.selectById(id);
	}

	@Override
	public void updateUserInfoById(UserInfo db_userInfo) {
		userInfoDao.updateById(db_userInfo);
	}

	@Override
	public UserInfo queryUserInfoByStudentId(String studentId) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("studentId", studentId);
		List<UserInfo> list = userInfoDao.selectByParameter(map);
		return list!=null?list.get(0):null;
	}

	@Override
	public List<UserInfo> queryUserInfoByParameter(Map<String, Object> map) {
		return userInfoDao.selectByParameter(map);
	}

	@Override
	public UserInfo queryUserInfoByUserNameAndPassword(Map<String, Object> map) {
		List<UserInfo> list = this.queryUserInfoByParameter(map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
	}
	
}
