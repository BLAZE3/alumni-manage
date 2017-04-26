package cn.blaze.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by hzzhangchengshuo on 2017/3/27.
 */
public class TimeUtils {

    private static String formatStr="yyyy-MM-dd HH:mm:ss";

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
}
