/**
 * @(#)AdmController.java, 2017年3月14日.
 *
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.blaze.controller;


import cn.blaze.consts.Consts;
import cn.blaze.consts.RetCode;
import cn.blaze.domain.News;
import cn.blaze.vo.NewsInfoVO;
import cn.blaze.vo.NewsVO;
import cn.blaze.service.NewsService;
import cn.blaze.utils.TimeUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * News相关的业务处理接口
 */
@RestController
@RequestMapping("news/")
public class NewsController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    /**
     * 获取新闻列表
     * @param request
     * @param response
     * @param size
     * @throws IOException
     */
    @RequestMapping("ajax/newsList")
    public void newsList(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam(defaultValue = "10",required = false) int size
    ) throws IOException {
        Map<String, Object> result = new HashedMap();
        List<NewsVO> newsList = newsService.queryNewList(size);
        result.put("newsList",newsList);
        writeJsonP(request, response,
                initAjaxResult(RetCode.SUCCESS.code, result));
        return;
    }

    /**
     * 获取所有新闻列表
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("ajax/newsAllList")
    public void newsAllList(HttpServletRequest request,
                         HttpServletResponse response
    ) throws IOException {
        Map<String, Object> result = new HashedMap();
        List<News> newsList = newsService.queryAllNewsList();
        result.put("newsList",newsList);
        writeJsonP(request, response,
                initAjaxResult(RetCode.SUCCESS.code, result));
        return;
    }

    /**
     * 获取新闻详情
     * @param request
     * @param response
     * @param id
     * @throws IOException
     */
    @RequestMapping("ajax/newsInfo")
    public void newsInfo(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam String id
    ) throws IOException {
        Map<String, Object> result = new HashedMap();
        News news = newsService.queryNew(id);
        result.put("news",new NewsInfoVO(news));
        writeJsonP(request, response,
                initAjaxResult(RetCode.SUCCESS.code, result));
        return;
    }

    /**
     * 发布新闻
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("ajax/addNews")
    public void addNews(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam String title,
                         @RequestParam String content,
                         @RequestParam String author,
                         @RequestParam String publisher,
                         @RequestParam String position,
                         @RequestParam String starttime,
                         @RequestParam String endtime) throws IOException {
        Map<String, Object> result = new HashedMap();
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = TimeUtils.parseTime(starttime);
            endDate = TimeUtils.parseTime(endtime);
        }catch (Exception e){
            logger.error("[NewsController parseTime error],starttime={},endtime={}", starttime, endtime);
            writeJsonP(request, response,
                    initAjaxResult(RetCode.BAD_PARAMETER.code, result));
            return;
        }

        News news = new News();
        news.setInserttime(new Date());
        news.setEndtime(endDate);
        news.setStarttime(startDate);
        news.setAuthor(author);
        news.setContent(content);
        news.setPosition(position);
        news.setPublisher(publisher);
        news.setIsvalid(Consts.ISVALID.YES);
        news.setTitle(title);
        boolean insertResult = newsService.insertNews(news);
        if (insertResult){
            writeJsonP(request, response,
                    initAjaxResult(RetCode.SUCCESS.code));
            return;
        }else {
            writeJsonP(request, response,
                    initAjaxResult(RetCode.SERVER_ERROR.code));
            return;
        }

    }

    /**
     * 删除新闻
     * @param request
     * @param response
     * @param id
     * @throws IOException
     */
    @RequestMapping("ajax/delete")
    public void delete(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestParam String id
    ) throws IOException {
        boolean deleteResult = newsService.deleteNews(id);
        if (deleteResult) {
            writeJsonP(request, response,
                    initAjaxResult(RetCode.SUCCESS.code));
            return;
        }else {
            writeJsonP(request, response,
                    initAjaxResult(RetCode.SERVER_ERROR.code));
            return;
        }
    }

    /**
     * 更新新闻
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("ajax/update")
    public void update(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam String title,
                        @RequestParam String content,
                        @RequestParam String author,
                        @RequestParam String publisher,
                        @RequestParam String position,
                        @RequestParam String starttime,
                        @RequestParam String id,
                        @RequestParam String endtime) throws IOException {
        Map<String, Object> result = new HashedMap();
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = TimeUtils.parseTime(starttime);
            endDate = TimeUtils.parseTime(endtime);
        }catch (Exception e){
            logger.error("[NewsController parseTime error],starttime={},endtime={}", starttime, endtime);
            writeJsonP(request, response,
                    initAjaxResult(RetCode.BAD_PARAMETER.code, result));
            return;
        }

        News news = new News();
        news.setInserttime(new Date());
        news.setEndtime(endDate);
        news.setStarttime(startDate);
        news.setAuthor(author);
        news.setContent(content);
        news.setPosition(position);
        news.setPublisher(publisher);
        news.setIsvalid(Consts.ISVALID.YES);
        news.setTitle(title);
        news.setId(id);
        boolean updateResult = newsService.updateNews(news);
        if (updateResult){
            writeJsonP(request, response,
                    initAjaxResult(RetCode.SUCCESS.code));
            return;
        }else {
            writeJsonP(request, response,
                    initAjaxResult(RetCode.SERVER_ERROR.code));
            return;
        }
    }
}
