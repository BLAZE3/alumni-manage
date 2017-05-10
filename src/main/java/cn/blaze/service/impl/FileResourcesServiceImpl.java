package cn.blaze.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.FileResourcesDao;
import cn.blaze.domain.FileResources;
import cn.blaze.service.FileResourcesService;
import cn.blaze.utils.BlazeConstants;
import cn.blaze.utils.CommonUtils;
import cn.blaze.vo.FileResourcesVo;

@Service
public class FileResourcesServiceImpl implements FileResourcesService {
	@Autowired
	private FileResourcesDao fileResourcesDao;
	
	@Override
	public int saveFileResource(FileResources resource) {
		return fileResourcesDao.insertFileResource(resource);
	}

	@Override
	public int updateFileResourceById(FileResources resource) {
		return fileResourcesDao.updateFileResourceById(resource);
	}

	@Override
	public List<FileResourcesVo> queryFileResourcesVoByParam(Map<String, Object> map) {
		return fileResourcesDao.selectFileResourcesVoByParam(map);
	}

	@Override
	public List<FileResources> queryFileResourcesByParam(Map<String, Object> map) {
		return fileResourcesDao.selectFileResourcesByParam(map);
	}
	
	@Override
	public int cancelFileResourceById(String id) {
		FileResources resource = new FileResources();
		resource.setId(id);
		resource.setIsvalid(BlazeConstants.ISVALID_NO);
		return this.updateFileResourceById(resource);
	}

	@Override
	public int restoreFileResourceById(String id) {
		FileResources resource = new FileResources();
		resource.setId(id);
		resource.setIsvalid(BlazeConstants.ISVALID_YES);
		return this.updateFileResourceById(resource);
	}

	@Override
	public String queryFileResourcesVoByParamForLigerUI(Map<String, Object> map,
			String sortName, String sortOrder, int page, int pageSize) {
		int total = this.queryFileResourcesCountByParam(map);
		
		map.put("sortName", sortName);
		map.put("sortOrder", sortOrder);
		map.put("start", String.valueOf((page-1)*pageSize));
		map.put("pageSize", String.valueOf(pageSize));
		CommonUtils.removeNullValue(map);
		List<FileResourcesVo> list = this.queryFileResourcesVoByParam(map);
		return CommonUtils.list2FlexigridJson(page+"", list, String.valueOf(total));
	}

	@Override
	public int queryFileResourcesCountByParam(Map<String, Object> map) {
		return fileResourcesDao.queryFileResourcesCountByParam(map);
	}

	@Override
	public FileResources queryFileResourcesById(String id) {
		if(id==null || "".equals(id)){
			return null;
		}else {
			Map<String,Object> map = new HashMap<String, Object>(1);
			map.put("id", id);
			List<FileResources> list = this.queryFileResourcesByParam(map);
			return list!=null&&list.size()>0?list.get(0):null;
		}
	}

	@Override
	public void updateFileResourceDownCount(FileResources dbfile) {
		Integer downCount = dbfile.getDownCount()==null?1:dbfile.getDownCount()+1;
		dbfile.setDownCount(downCount);
		this.updateFileResourceById(dbfile);
	}
	
}
