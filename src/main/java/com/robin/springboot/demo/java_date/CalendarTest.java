package com.robin.springboot.demo.java_date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: silkNets
 * @since: 2019/1/3 10:57
 * @Description:
 */
public class CalendarTest {
    static Calendar calendar = Calendar.getInstance();
    private static final int START_HOUR = 9;
    private static final int END_HOUR = 21;
    private static final int NUM_MONDAY = 1;
    private static final int END_SUNDAY = 7;

    public static void main(String[] args) {
//        System.out.println(getCountDownTime());
//        System.out.println(getCurrentWeekInfo());
        List<String> test =  new ArrayList();
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");
        test.add("e");
        test.add("f");
        List<String> test2 = test.subList(0,1);
        test2.forEach(n -> System.out.println(n));
    }

    // 参考 https://www.cnblogs.com/huangminwen/p/6041168.html
    public static void test() {

        // 获取年
        int year = calendar.get(Calendar.YEAR);

        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
        int month = calendar.get(Calendar.MONTH) + 1;

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // 获取时
        int hour = calendar.get(Calendar.HOUR);
        // int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示

        // 获取分
        int minute = calendar.get(Calendar.MINUTE);

        // 获取秒
        int second = calendar.get(Calendar.SECOND);

        // 星期，英语国家星期从星期日开始计算
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("现在是" + year + "年" + month + "月" + day + "日" + hour
                + "时" + minute + "分" + second + "秒" + "星期" + weekday);

    }

    // 参考 https://blog.csdn.net/u011974797/article/details/39545885
    // https://www.cnblogs.com/sanhuan/p/4649243.html
    private static void test2() {
        SimpleDateFormat sdf = new SimpleDateFormat("M.d");
        StringBuilder sb = new StringBuilder();

        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();

        int day_of_week = startCalendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        startCalendar.add(Calendar.DATE, -day_of_week + 1);
        endCalendar.add(Calendar.DATE, -day_of_week + 7);
        String startWeekday = sdf.format(startCalendar.getTime());
        String endWeekday = sdf.format(endCalendar.getTime());

        sb.append(year).append("年第").append(week).append("周(")
                .append(startWeekday).append("-").append(endWeekday).append(")");
        System.out.println(sb);
    }

    private static void test3() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();

        int day_of_week = startCalendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        startCalendar.add(Calendar.DATE, -day_of_week + 1);
        Date startTime = MyDateUtils.addHours(MyDateUtils.getStartOfDay(startCalendar.getTime()), 9);

        endCalendar.add(Calendar.DATE, -day_of_week + 7);
        Date endTime = MyDateUtils.addHours(MyDateUtils.getStartOfDay(endCalendar.getTime()), 21);
        long countDownTime = endTime.getTime() - startTime.getTime();

        System.out.println(day_of_week);
        System.out.println(sdf.format(startTime));
        System.out.println(sdf.format(endTime));
        System.out.println(countDownTime);
    }


    public static long getCountDownTime() {
        Date startTime = getDateTimeOfWeek(NUM_MONDAY, START_HOUR);
        Date endTime = getDateTimeOfWeek(3, END_HOUR);
        System.out.println(MyDateUtils.formatDateTime(startTime));
        System.out.println(MyDateUtils.formatDateTime(endTime));
        Date currentTime = Calendar.getInstance().getTime();
        long intervalTime = endTime.getTime() - currentTime.getTime();
        long countDownTime = intervalTime >= 0 ? intervalTime : 0L;
        return countDownTime;
    }


    public static String getCurrentWeekInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("M.d");
        StringBuilder sb = new StringBuilder();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        String startWeekday = sdf.format(getDateTimeOfWeek(NUM_MONDAY, 0));
        String endWeekday = sdf.format(getDateTimeOfWeek(END_SUNDAY, 0));

        sb.append(year).append("年第").append(week).append("周(").append(startWeekday).append("-").append(endWeekday).append(")");
        return sb.toString();
    }

    /**
     * 获得一周的具体的时间，精确到小时，如：周日晚上9点 2019-01-06 21:00:00
     *
     * @param numOfWeekday 一周的第几天，如：周一 1,
     * @param hours        当天的几点，如：晚上9点 21
     * @return Date
     */
    private static Date getDateTimeOfWeek(int numOfWeekday, int hours) {
        Calendar calendar = Calendar.getInstance();
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        calendar.add(Calendar.DATE, -day_of_week + numOfWeekday);

        return MyDateUtils.addHours(MyDateUtils.getStartOfDay(calendar.getTime()), hours);
    }


}
