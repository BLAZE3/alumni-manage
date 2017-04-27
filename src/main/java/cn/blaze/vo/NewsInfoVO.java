package cn.blaze.vo;

import cn.blaze.domain.News;
import cn.blaze.utils.TimeUtils;

import java.util.Date;

/**
 * Created by chengshuo on 2017/4/27.
 */
public class NewsInfoVO {
    private String id;

    private String title;

    private String author;

    private String publisher;

    private String position;

    private String starttime;

    private String content;

    public NewsInfoVO(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.content = news.getContent();
        this.author = news.getTitle();
        this.position = news.getPosition();
        this.publisher = news.getPublisher();
        this.starttime = TimeUtils.getTime(news.getStarttime().getTime());
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
