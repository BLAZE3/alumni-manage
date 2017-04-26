/**
 * @(#)AdmController.java, 2017年3月14日.
 *
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.blaze.controller;


import cn.blaze.consts.RetCode;
import cn.blaze.controller.BaseController;
import cn.blaze.domain.po.Log;
import cn.blaze.domain.vo.AjaxResult;
import cn.blaze.service.LogService;
import cn.blaze.utils.TimeUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.http.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * log相关的业务处理接口
 */
@RestController
@RequestMapping("log/")
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
    @RequestMapping("ajax/logList")
    public void logList(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestParam(value = "", required = false) String actorid,
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
}
