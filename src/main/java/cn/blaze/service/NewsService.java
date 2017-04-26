package cn.blaze.service;

import cn.blaze.domain.po.News;

import java.util.List;

/**
 * Created by chengshuo on 2017/4/26.
 */
public interface NewsService {
    public List<News> queryNewList(int size);

    boolean insertNews(News news);

    boolean deleteNews(String id);

    boolean updateNews(News news);
}
