package cn.blaze.dao;

/**
 * Created by chengshuo on 2017/4/25.
 */

import cn.blaze.domain.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = false, locations = { "classpath:spring/applicationContext.xml","classpath:spring/applicationContext-tx.xml" })
public class LogDaoTest {

    @Autowired
    LogDao logDao;

    @Test
    public void insertTest(){
        Log log = new Log();
        log.setActorid("test");
        log.setActinfo("actinfo");
        log.setInserttime(new Date());
        logDao.insert(log);
        System.out.println(log.getId());
    }

    @Test
    public void selectByTimeTest(){
        List<Log> logList = logDao.selectByTime(new Date(System.currentTimeMillis()-24*60*60*1000),new Date());
        for (Log log:logList){
            System.out.println(log);
        }
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme