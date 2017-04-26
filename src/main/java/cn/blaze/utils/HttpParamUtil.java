/**
 * @(#)ParamUtil.java, 2013-5-20.
 *
 * Copyright 2013 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.blaze.utils;

import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hzlibaohua@corp.netease.com
 */
public class HttpParamUtil {
    /**
     * Get one string parameter from request firstly, if not existing, the
     * method will check request's attribute
     * 
     * @param name
     * @return
     */
    public static String getRequestStringParam(HttpServletRequest request,
        String name, String defaultVal) {
        String rlt = ServletRequestUtils.getStringParameter(request, name,
            defaultVal);
        if (rlt.equals(defaultVal)) {
            try {
                rlt = (String) request.getAttribute(name);
            } catch (Exception e) {}
            if (rlt == null) {
                rlt = defaultVal;
            }
        }
        return rlt;
    }

    public static String[] getRequestStringParams(HttpServletRequest request,
        String name) {
        String[] rlt = ServletRequestUtils.getStringParameters(request, name);
        if (rlt.length == 0) {
            try {
                rlt = (String[]) request.getAttribute(name);
            } catch (Exception e) {}
        }
        return rlt;
    }

    public static int[] getRequestIntParams(HttpServletRequest request,
        String name) {
        int[] rlt = ServletRequestUtils.getIntParameters(request, name);
        if (rlt.length == 0) {
            try {
                rlt = (int[]) request.getAttribute(name);
            } catch (Exception e) {}
        }
        return rlt;
    }

    public static long[] getRequestLongParams(HttpServletRequest request,
        String name) {
        long[] rlt = ServletRequestUtils.getLongParameters(request, name);
        if (rlt.length == 0) {
            try {
                rlt = (long[]) request.getAttribute(name);
            } catch (Exception e) {}
        }
        return rlt;
    }

    public static boolean getRequestBoolParam(HttpServletRequest request,
        String name, boolean defaultVal) {
        Boolean rlt = ServletRequestUtils.getBooleanParameter(request, name,
            defaultVal);
        if (rlt == defaultVal) {
            try {
                rlt = (Boolean) request.getAttribute(name);
            } catch (Exception e) {}
            if (rlt == null) {
                rlt = defaultVal;
            }
        }
        return rlt;
    }

    public static int getRequestIntParam(HttpServletRequest request,
        String name, int defaultVal) {
        Integer rlt = ServletRequestUtils.getIntParameter(request, name,
            defaultVal);
        if (rlt == defaultVal) {
            try {
                rlt = (Integer) request.getAttribute(name);
            } catch (Exception e) {}
            if (rlt == null) {
                rlt = defaultVal;
            }
        }
        return rlt;
    }

    public static long getRequestLongParam(HttpServletRequest request,
        String name, long defaultVal) {
        Long rlt = ServletRequestUtils.getLongParameter(request, name,
            defaultVal);
        if (rlt == defaultVal) {
            try {
                rlt = (Long) request.getAttribute(name);
            } catch (Exception e) {}
            if (rlt == null) {
                rlt = defaultVal;
            }
        }
        return rlt;
    }

    public static String encodeUrl(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeUrlGBK(String url) {
        try {
            return URLEncoder.encode(url, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decodeUrl(String url) {
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decodeUrlGBK(String url) {
        try {
            return URLDecoder.decode(url, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void sendRedirect(HttpServletResponse response, String url)
        throws IOException {
        response.setContentType("text/html; charset=utf8");
        response.sendRedirect(url);
    }

    public static void sendRedirect(HttpServletResponse response, String url,
        String contentType) throws IOException {
        response.setContentType(contentType);
        response.sendRedirect(url);
    }

    /**
     * 替换用户输入文本中的特殊字符
     * 
     * @param chars
     * @param offset
     * @param length
     * @return
     */
    private static String getXHTMLString(char[] chars, int offset, int length) {
        StringBuilder builder = new StringBuilder((int) (length * 1.2));
        for (int counter = offset; counter < length; counter++) {
            // This will change, we need better support character level
            // entities.
            switch (chars[counter]) {
            // Character level entities.
                case '<':
                    builder.append("&lt;");
                    break;
                case '>':
                    builder.append("&gt;");
                    break;
                case '&':
                    builder.append("&amp;");
                    break;
                case '"':
                    builder.append("&quot;");
                    break;
                // Special characters
                case '\n':
                    builder.append("<br/>");
                    break;
                case '\t':
                    builder.append(" ");
                    break;
                case '\r':
                    break;
                default:
                    if (chars[counter] > 127 && chars[counter] < 256) {
                        builder.append("&#");
                        builder.append(String.valueOf((int) chars[counter]));
                        builder.append(';');
                    } else if (chars[counter] >= ' ') {
                        builder.append(chars[counter]);
                    }
                    break;
            }
        }
        return builder.toString();
    }

    /**
     * 计算当前页码
     * 
     * @param page
     * @param totalPages
     * @return
     */
    public static int getPage(int page, int totalPages) {
        page = Math.min(page, totalPages);
        page = Math.max(1, page);
        return page;
    }

    /**
     * 替换用户输入文本中的特殊字符及换行回车符等
     * 
     * @param str
     * @return
     */
    public static String getXHTMLString(String str) {
        return getXHTMLString(str.toCharArray(), 0, str.length());
    }

    public static boolean checkEmailFormat(String email) {
        Pattern p = Pattern.compile("^[^@,]+@[\\w-]+(\\.[\\w-]+)+$");
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static String getCurrentUrl(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String query = req.getQueryString();
        if (query == null) {
            query = "";
        } else {
            query = "?" + query;
        }
        return uri + query;
    }
}
