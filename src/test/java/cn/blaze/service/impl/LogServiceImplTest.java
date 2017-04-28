package cn.blaze.service.impl;

import cn.blaze.service.LogService;
import org.junit.Test;

/**
 * Created by chengshuo on 2017/4/26.
 */
import cn.blaze.domain.Log;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = false, locations = { "classpath:spring/applicationContext.xml","classpath:spring/applicationContext-tx.xml" })
public class LogServiceImplTest {

    @Autowired
    private LogService logService;

    @Test
    public void queryLogList() throws Exception {
        List<Log> logList = logService.queryLogList("",new Date(System.currentTimeMillis()-3600*24),new Date());
        for (Log log:logList){
            System.out.println(log.getId());
        }
    }

    @Test
    public void addLog() throws Exception {

    }

}