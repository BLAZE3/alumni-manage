package cn.blaze.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.blaze.domain.Log;
import cn.blaze.vo.LogVo;

public interface LogDao {
	
    int deleteByPrimaryKey(String id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

    List<Log> selectByActorAndTime(@Param("actorid") String actorid, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Log> selectByTime(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    List<LogVo> selectByParam(Map<String,Object> map);

    /**
     * @Title deleteByIds
     * @Description：根据ids批量删除
     * @param ids
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
	int deleteByIds(@Param("ids")String ids);

	/**
	 * @Title queryLogCountByParam
	 * @Description：查询条数
	 * @param map
	 * @return
	 * @user LiuLei 2017年5月14日
	 * @updater：
	 * @updateTime：
	 */
	int queryLogCountByParam(Map<String, Object> map);

	List<LogVo> selectLogVoForLigerUIByParam(Map<String, Object> map);
}