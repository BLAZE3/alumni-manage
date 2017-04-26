package cn.blaze.service.impl;

import cn.blaze.dao.NewsDao;
import cn.blaze.domain.po.News;
import cn.blaze.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by chengshuo on 2017/4/26.
 */
@Service
public class NewsServiceImpl implements NewsService {
    private static final Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsDao newsDao;

    /**
     * 获取size个当前有效的新闻
     * @param size
     * @return
     */
    @Override
    public List<News> queryNewList(int size) {
        return newsDao.selectByTimeSize(size,new Date());
    }

    @Override
    public boolean insertNews(News news) {
        return newsDao.insert(news) > 0;
    }

    @Override
    public boolean deleteNews(String id) {
        return newsDao.updateValid(id) > 0;
    }

    @Override
    public boolean updateNews(News news) {
        return newsDao.updateByPrimaryKey(news) > 0;
    }


}
