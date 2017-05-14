/**
 * @(#)AdmController.java, 2017年3月14日.
 *
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.blaze.controller;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blaze.consts.RetCode;
import cn.blaze.domain.Log;
import cn.blaze.domain.UserInfo;
import cn.blaze.service.LogService;
import cn.blaze.utils.CommonUtils;
import cn.blaze.utils.TimeUtils;

/**
 * log相关的业务处理接口
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService logService;
    /**
     * 根据时间范围获取日志列表
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("ajax/logList")
    public void logList(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(defaultValue = "", required = false) String actorid,
                        @RequestParam String starttime,
                        @RequestParam String endtime
    ) throws IOException {
        Map<String, Object> result = new HashedMap();
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = TimeUtils.parseTime(starttime);
            endDate = TimeUtils.parseTime(endtime);
        } catch (Exception e) {
            logger.error("[LogController parseTime error],starttime={},endtime={}", starttime, endtime);
            writeJsonP(request, response,
                    initAjaxResult(RetCode.BAD_PARAMETER.code, result));
            return;
        }
        List<Log> logList = logService.queryLogList(actorid, startDate, endDate);
        result.put("logs", logList);
        writeJsonP(request, response,
                initAjaxResult(RetCode.SUCCESS.code, result));
        return;
    }
    
    /**
     * @Title forwardLogList
     * @Description：跳转到日志列表
     * @param request
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
    @RequestMapping("forwardLogList")
    public String forwardLogList(HttpServletRequest request){
    	return "log/logList";
    }
    
    /**
     * @Title queryLogForLigerUI
     * @Description：日志信息列表
     * @param request
     * @param response
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
    @ResponseBody
    @RequestMapping("queryLogForLigerUI")
    public String queryLogForLigerUI(HttpServletRequest request, HttpServletResponse response){
    	try{
    		String actorid = getRequestNotNullValue("actorid", request);
    		String userName = getRequestNotNullValue("userName", request);
    		Date startTime = null;
    		Date endTime = null;
    		if(!"".equals(getRequestNotNullValue("startTime", request))){
    			startTime = TimeUtils.parseTime(getRequestNotNullValue("startTime", request), TimeUtils.DEFAULT_DATE_FORMAT);
    			startTime = TimeUtils.getArroundDate(startTime, -1);
    			
    		}
    		if(!"".equals(getRequestNotNullValue("endTime", request))){
    			endTime = TimeUtils.parseTime(getRequestNotNullValue("endTime", request), TimeUtils.DEFAULT_DATE_FORMAT);
    			endTime = TimeUtils.getArroundDate(endTime, 1);
    		}
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("actorid", actorid);
    		map.put("userName", userName);
    		map.put("startTime", startTime);
    		map.put("endTime", endTime);
    		
    		String sortName = getRequestNotNullValue("sortname", request);
    		String sortOrder = getRequestNotNullValue("sortorder", request);
    		int page = getRequestNotNullValueToInt("page", request);
    		int pageSize = getRequestNotNullValueToInt("pagesize", request);
    		
    		return logService.queryForLigerUIByMap(map , sortName, sortOrder, page, pageSize);
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return "";
    }
    
    /**
     * @Title cancelLogByIds
     * @Description：删除日志
     * @param request
     * @param response
     * @return
     * @user LiuLei 2017年5月14日
     * @updater：
     * @updateTime：
     */
    @ResponseBody
    @RequestMapping("cancelLogByIds")
    public String cancelLogByIds(HttpServletRequest request, HttpServletResponse response){
    	String idsStr = null;
    	int res = 0;
    	try{
    		idsStr = getRequestNotNullValue("ids", request);
    		String inIds = CommonUtils.stringForWhereIn(idsStr); // 转换成'1','2','3'
    		res = logService.cancelLogByIds(inIds);
    	}catch (Exception e){
    		e.printStackTrace();
    		return "删除出错,ids="+idsStr;
    	}
    	
    	try{
	    	if(res>0){
	    		// 添加日志
				UserInfo loginUser = getLoginUser(request);
				logService.insertLog(loginUser.getId(), "用户"+loginUser.getUserName()+"删除了日志"+res+"条");
			}else {
				return "删除失败,可能日志已被删除";
			} 
    	}catch(Exception e){
			e.printStackTrace();
		}
    	return "success";
    }
}
