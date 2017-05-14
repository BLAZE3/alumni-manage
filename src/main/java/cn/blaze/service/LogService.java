package cn.blaze.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.blaze.domain.Log;
import cn.blaze.vo.LogVo;

/**
 * Created by chengshuo on 2017/4/26.
 */
public interface LogService {
    
	List<Log> queryLogList(String actorid, Date startDate, Date endDate);
	
    boolean addLog(Log log);
    
    /**
     * @Title insertLog
     * @Description：插入日志
     * @param actorId 操作者用户id
     * @param content 日志内容
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
    int insertLog(String actorId, String content);
    
    /**
     * @Title queryLogVoByMap
     * @Description：条件查询日志信息
     * @param map
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
    List<LogVo> queryLogVoByMap(Map<String, Object> map);
    
    /**
     * @Title cancelLogByIds
     * @Description：根据id批量删除
     * @param ids 类似'1','2'
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
    int cancelLogByIds(String ids);
    
    /**
     * @Title queryForLigerUIByMap
     * @Description：条件查询日志信息
     * @param map
     * @param map
     * @param sortName
     * @param sortOrder
     * @param page
     * @param pageSize
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
    String queryForLigerUIByMap(Map<String, Object> map, String sortName, 
			String sortOrder, int page, int pageSize);

    /**
     * @Title queryLogCountByPara
     * @Description：查询条数
     * @param map
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
	int queryLogCountByPara(Map<String, Object> map);
}
