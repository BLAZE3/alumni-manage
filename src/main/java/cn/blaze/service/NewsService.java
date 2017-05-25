package cn.blaze.service;

import cn.blaze.domain.News;
import cn.blaze.vo.NewsVO;

import java.util.List;

/**
 * Created by chengshuo on 2017/4/26.
 */
public interface NewsService {
    public List<NewsVO> queryNewList(int size);

    boolean insertNews(News news);

    boolean deleteNews(String id);

    boolean updateNews(News news);

    News queryNew(String id);

    List<News> queryAllNewsList();

}
