/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.robin.springboot.demo.java_date;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 日期工具类, 继承org.apache.commons.lang.datetime.DateUtils类
 */
public class MyDateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd HH:mm", "yyyy.MM", "yyyy-MM-dd'T'HH:mm:ssXXX", "yyyy-MM-dd'T'HH:mm:ssz",
            "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ssSSS", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE MMM ddHH:mm:ss 'GMT' yyyy"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * Date得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * LocalDateTime 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(LocalDateTime date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(date);
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 1、小于一小时用“XX分钟前”表示；2、小于24小时用“XX小时前”；3、小于5天（含）用“X天前”；4、大于5天用具体日期显示
     *
     * @param date
     * @return
     */
    public static String getPastTime(String date) {
        if (date != null) {
            date = date.replace("T", " ");
            date = date.replace("+00:00", "");
        }

        Date dateObj = parseDate(date);
        if (dateObj == null) {
            return getDate();
        }
        long t = new Date().getTime() - dateObj.getTime();
        if (t < 0) {
            return getDate();
        }
        if (t / (60 * 1000) < 60) {
            return t / (60 * 1000) + "分钟前";
        }
        if (t / (60 * 60 * 1000) >= 1 && t / (60 * 60 * 1000) < 24) {
            return t / (60 * 60 * 1000) + "小时前";
        }
        if (t / (24 * 60 * 60 * 1000) >= 1 && t / (24 * 60 * 60 * 1000) <= 5) {
            return t / (24 * 60 * 60 * 1000) + "天前";
        }
        return MyDateUtils.formatDate(dateObj, "yyyy-MM-dd");
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000D * 60D * 60D * 24D);
    }

    /**
     * 将时间变成"yyyy-MM-dd'T'HH:mm:ss'Z'"这种格式
     *
     * @param date
     * @return
     */
    public static String asUTCFormat(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(date);
    }

    /**
     * 将时间变成"yyyy-MM-dd'T'HH:mm:ss'Z'"这种格式
     *
     * @param milliSeconds
     * @return
     */
    public static String asUTCFormat(long milliSeconds) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(new Date(milliSeconds));
    }

    public static Date addYears(Date date, int year) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, year);
            return calendar.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某天的23:59:59秒
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        Date endDate = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());

        // 将毫米变为零，避免MySQL数据库对于毫秒大于500的数据进行进位。避免 23:59:59 变成 次日的 00:00:00
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(endDate);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }

    /**
     * 获得某天最小时间 2017-10-15 00:00:00
     *
     * @return
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前时间点离当天结束剩余秒数
     */
    public static long getRemainSecondsOfToday() {
        Date currentDate = new Date();
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return seconds;
    }



    /**
     * 获取两个时间区间 [startTime1, endTime1] 和 [startTime2, endTime2] 的交集
     *
     * @param startTime1 开始时间1
     * @param endTime1   结束时间1
     * @param startTime2 开始时间2
     * @param endTime2   结束时间2
     * @return Map
     */
    public static Map<String, Date> getTimeIntersection(Date startTime1, Date endTime1, Date startTime2, Date endTime2) {
        Date star;
        Date end;

        long lst = startTime1.getTime();
        long let = endTime1.getTime();

        long rst = startTime2.getTime();
        long ret = endTime2.getTime();

        if (lst >= let || rst >= ret) {
//            throw new Exception("时间区间错误，结束时间要大于开始时间");
            return null;
        }

        if (let <= rst || lst >= ret) {
            return null;
        }

        if (let > ret) {
            end = endTime2;
            if (lst <= ret) {
                star = startTime2;
            } else {
                star = startTime1;
            }
        } else {
            end = endTime1;
            if (lst >= rst) {
                star = startTime1;
            } else {
                star = startTime2;
            }
        }
        return HashMapLinkUtil.newInstance().add("startDate", star).add("endDate", end);
    }

    /**
     * 获取两个时间区间 [startTime1, endTime1] 和 [startTime2, endTime2] 的交集
     *
     * @param startTime1 开始时间1
     * @param endTime1   结束时间1
     * @param startTime2 开始时间2
     * @param endTime2   结束时间2
     * @return {"startDate":"String, 开始时间","endDate":"String, 结束时间"}
     * @throws Exception
     */
    public static Map<String, String> getTimeIntersectionForStr(String startTime1, String endTime1, String startTime2, String endTime2) {
        String star;
        String end;

        long lst = parseDate(startTime1).getTime();
        long let = parseDate(endTime1).getTime();

        long rst = parseDate(startTime2).getTime();
        long ret = parseDate(endTime2).getTime();

        if (lst >= let || rst >= ret) {
//            throw new Exception("时间区间错误，结束时间要大于开始时间");
            return null;
        }

        if (let <= rst || lst >= ret) {
            return null;
        }

        if (let > ret) {
            end = endTime2;
            if (lst <= ret) {
                star = startTime2;
            } else {
                star = startTime1;
            }
        } else {
            end = endTime1;
            if (lst >= rst) {
                star = startTime1;
            } else {
                star = startTime2;
            }
        }
        return HashMapLinkUtil.newInstance().add("startDate", star).add("endDate", end);
    }

    public static void main(String[] args) {
        Date date = MyDateUtils.addMinutes(new Date(), 1);

        System.out.println(addDays(getStartOfDay(date),1));

        System.out.println(addDays(getEndOfDay(date),-1));

        System.out.println(addMinutes(getStartOfDay(date),10));

        System.out.println(addMinutes(getEndOfDay(date),-10));

        System.out.println(new Date().compareTo(date));
    }


}
