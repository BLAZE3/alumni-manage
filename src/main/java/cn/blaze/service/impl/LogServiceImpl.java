package cn.blaze.service.impl;

import cn.blaze.dao.LogDao;
import cn.blaze.domain.po.Log;
import cn.blaze.service.LogService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chengshuo on 2017/4/26.
 */
@Service
public class LogServiceImpl implements LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

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

}
