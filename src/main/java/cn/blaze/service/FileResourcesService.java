package cn.blaze.service;

import java.util.List;
import java.util.Map;

import cn.blaze.domain.FileResources;
import cn.blaze.vo.FileResourcesVo;

public interface FileResourcesService {

	/**
	 * @Title saveFileResource
	 * @Description：保存上传文件的信息
	 * @param resource 文件信息
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int saveFileResource(FileResources resource);
	
	/**
	 * @Title updateFileResourceById
	 * @Description：根据Id更新
	 * @param resource
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int updateFileResourceById(FileResources resource);
	
	/**
	 * @Title queryFileResourcesByParam
	 * @Description：条件查询
	 * @param map
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	List<FileResourcesVo> queryFileResourcesByParam(Map<String, Object> map);
	
	/**
s	 * @Title cancelFileResourceById
	 * @Description：根据id删除(软删)
	 * @param id
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int cancelFileResourceById(String id);

	/**
	 * @Title delFileResourceById
	 * @Description：根据id恢复软删
	 * @param id
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int restoreFileResourceById(String id);

	/**
	 * @Title queryFileResourcesByParamForLigerUI
	 * @Description：查询供ligerUI显示的json数据
	 * @param map 条件
	 * @param sortName 排序列
	 * @param sortOrder 排序方式
	 * @param page 当前页
	 * @param pageSize 页大小
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	String queryFileResourcesByParamForLigerUI(Map<String, Object> map,
			String sortName, String sortOrder, int page, int pageSize);
	
	/**
	 * @Title queryFileResourcesCountByParam
	 * @Description：查询数据条数
	 * @param map 条件
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int queryFileResourcesCountByParam(Map<String, Object> map);

	/**
	 * @Title queryFileResourcesById
	 * @Description：根据id查找
	 * @param id
	 * @return
	 * @user LiuLei 2017年5月10日
	 * @updater：
	 * @updateTime：
	 */
	FileResourcesVo queryFileResourcesById(String id);
}
