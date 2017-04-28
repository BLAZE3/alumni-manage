package cn.blaze.service.impl;

import cn.blaze.consts.Consts;
import cn.blaze.domain.News;
import cn.blaze.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by chengshuo on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = false, locations = { "classpath:spring/applicationContext.xml","classpath:spring/applicationContext-tx.xml" })
public class NewsServiceImplTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void queryNewList() throws Exception {

    }

    @Test
    public void insertNews() throws Exception {
        News news = new News();
        news.setInserttime(new Date());
        news.setEndtime(new Date());
        news.setStarttime(new Date());
        news.setAuthor("1");
        news.setContent("2");
        news.setPosition("3");
        news.setPublisher("4");
        news.setIsvalid(Consts.ISVALID.YES);
        news.setTitle("5");
        try {
            boolean result = newsService.insertNews(news);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(news.getId());
    }

}