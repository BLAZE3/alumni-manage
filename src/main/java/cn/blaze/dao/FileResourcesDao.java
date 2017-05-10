package cn.blaze.dao;

import java.util.List;
import java.util.Map;

import cn.blaze.domain.FileResources;
import cn.blaze.vo.FileResourcesVo;

public interface FileResourcesDao {

	/**
	 * @Title insertFileResource
	 * @Description：插入上传的文件资源记录
	 * @param resource
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int insertFileResource(FileResources resource);

	/**
	 * @Title updateFileResourceById
	 * @Description：根据id更新
	 * @param resource
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int updateFileResourceById(FileResources resource);

	/**
	 * @Title selectFileResourcesByParam
	 * @Description：条件查询
	 * @param map
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	List<FileResources> selectFileResourcesByParam(Map<String, Object> map);

	/**
	 * @Title queryFileResourcesCountByParam
	 * @Description：查询记录条数
	 * @param map
	 * @return
	 * @user LiuLei 2017年5月9日
	 * @updater：
	 * @updateTime：
	 */
	int queryFileResourcesCountByParam(Map<String, Object> map);

	/**
	 * @Title selectFileResourcesVoByParam
	 * @Description：条件查询
	 * @param map
	 * @return
	 * @user LiuLei 2017年5月10日
	 * @updater：
	 * @updateTime：
	 */
	List<FileResourcesVo> selectFileResourcesVoByParam(Map<String, Object> map);

}
