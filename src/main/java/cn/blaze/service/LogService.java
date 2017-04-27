package cn.blaze.service;

import cn.blaze.domain.Log;

import java.util.Date;
import java.util.List;

/**
 * Created by chengshuo on 2017/4/26.
 */
public interface LogService {
    List<Log> queryLogList(String actorid, Date startDate, Date endDate);
    boolean addLog(Log log);
}
