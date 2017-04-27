package cn.blaze.service.impl;

import cn.blaze.dao.NewsDao;
import cn.blaze.domain.News;
import cn.blaze.vo.NewsVO;
import cn.blaze.service.NewsService;
import org.apache.commons.collections.CollectionUtils;
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
    public List<NewsVO> queryNewList(int size) {
        List<NewsVO> newsVOList = new ArrayList<>();
        List<News> newsList = newsDao.selectByTimeSize(size,new Date());
        if (CollectionUtils.isEmpty(newsList)){
            return newsVOList;
        }
        for (News news: newsList){
            newsVOList.add(new NewsVO(news));
        }
        return newsVOList;
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

    @Override
    public News queryNew(String id) {
        return newsDao.selectByPrimaryKey(id);
    }
}
