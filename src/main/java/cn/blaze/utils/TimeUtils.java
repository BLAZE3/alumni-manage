package cn.blaze.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by hzzhangchengshuo on 2017/3/27.
 */
public class TimeUtils {

    private static String formatStr="yyyy-MM-dd HH:mm:ss";

    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static String MM_DD_DATE_FORMAT = "MM月dd日";

    public static String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public static String DEFAULT_DATETIME_FORMAT = DEFAULT_DATE_FORMAT + " "
            + DEFAULT_TIME_FORMAT;

    /**
     * 根据日期格式生成时间Date
     *
     * @param time
     * @param formatStr
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseTime(String time, String formatStr)
            throws ParseException {
        DateFormat format = new java.text.SimpleDateFormat(formatStr);
        Date date = format.parse(time);

        return date;
    }

    /**
     * 根据默认日期格式生成时间Date
     *
     * @param time
     * @return
     * @throws java.text.ParseException
     */
    public static Date parseTime(String time)
            throws ParseException {
        return parseTime(time,formatStr);
    }

    /** 输出格式: MM月dd日 */
    public static String getTime(long d) {
        DateFormat format1 = new java.text.SimpleDateFormat(
                MM_DD_DATE_FORMAT);
        String s = format1.format(d);
        return s;
    }

    /**
     * 自定义输出格式
     * @param d
     * @param formaterStr
     * @return
     */
    public static String getTime(long d, String formaterStr) {
        DateFormat format1 = new java.text.SimpleDateFormat(formaterStr);
        String s = format1.format(d);
        return s;
    }
}
