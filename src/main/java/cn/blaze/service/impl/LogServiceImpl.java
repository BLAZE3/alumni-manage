package cn.blaze.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blaze.dao.LogDao;
import cn.blaze.domain.Log;
import cn.blaze.service.LogService;
import cn.blaze.utils.CommonUtils;
import cn.blaze.vo.LogVo;

/**
 * Created by chengshuo on 2017/4/26.
 */
@Service
public class LogServiceImpl implements LogService {
	
    @Autowired
    private LogDao logDao;

    /**
     * 查找日志列表
     * @param actorid 可空
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<Log> queryLogList(String actorid, Date startDate, Date endDate) {
        List<Log> logs = new ArrayList<>();
        if (StringUtils.isNotBlank(actorid)) {
            logs = logDao.selectByActorAndTime(actorid, startDate, endDate);
        } else {
            logs = logDao.selectByTime(startDate, endDate);
        }
        return logs;
    }

    /**
     * 添加日志，返回添加是否成功。
     * @param log
     * @return
     */
    @Override
    public boolean addLog(Log log) {
        return logDao.insert(log) > 0;
    }

    /**
     * @Title LogServiceImpl
     * @Description 插入日志
     * @param actorId
     * @param content
     * @return
     * @user LiuLei 2017年5月14日
     * @修改：
     */
	@Override
	public int insertLog(String actorId, String content) {
		Log log = new Log();
		log.setActorid(actorId);
		log.setActinfo(content);
		log.setInserttime(new Date());
		return logDao.insert(log);
	}

	@Override
	public List<LogVo> queryLogVoByMap(Map<String, Object> map) {
		CommonUtils.removeNullValue(map);
		return logDao.selectLogVoForLigerUIByParam(map);
	}

	@Override
	public int cancelLogByIds(String ids) {
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("ids", ids);
		return logDao.deleteByIds(ids);
	}

	@Override
	public String queryForLigerUIByMap(Map<String, Object> map,
			String sortName, String sortOrder, int page, int pageSize) {
		int total = this.queryLogCountByPara(map);
		
		map.put("sortName", sortName);
		map.put("sortOrder", sortOrder);
		map.put("start", String.valueOf((page-1)*pageSize));
		map.put("pageSize", String.valueOf(pageSize));
		List<LogVo> list = this.queryLogVoByMap(map);
		return CommonUtils.list2FlexigridJson(page+"", list, String.valueOf(total));
	}

	@Override
	public int queryLogCountByPara(Map<String, Object> map) {
		return logDao.queryLogCountByParam(map);
	}
	
}
