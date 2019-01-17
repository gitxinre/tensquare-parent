package com.xinre.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xinre
 * @date 2019/1/17 16:49
 */
public class DateUtils {

    /**
     * 时间戳转日期
     *
     * @param s 时间戳字符串
     * @return 日期
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 日期转时间戳
     *
     * @param s 格式必须为：yyyy-MM-dd
     * @return 时间戳
     * @throws ParseException 日期解析异常
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
}
