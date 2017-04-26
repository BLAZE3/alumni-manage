/**
 * @(#)AdmController.java, 2017年3月14日.
 *
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.blaze.controller;


import cn.blaze.consts.RetCode;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * News相关的业务处理接口
 */
@RestController
@RequestMapping("news/")
public class NewsController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @RequestMapping("ajax/newsList")
    public void newsList(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        Map<String,Object> result = new HashedMap();
        writeJsonP(request, response,
                initAjaxResult(RetCode.SUCCESS.code,result));
        return;
    }
}
