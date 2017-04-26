package cn.blaze.domain.vo;

import cn.blaze.domain.po.News;
import cn.blaze.utils.TimeUtils;

/**
 * Created by chengshuo on 2017/4/26.
 */
public class NewsVO {
    private String id;
    private String title;
    private String time;

    public NewsVO(News news){
        this.id = news.getId();
        this.title = news.getTitle();
        this.time = TimeUtils.getTime(news.getStarttime().getTime());
    }

    public NewsVO(String id, String title, String time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
