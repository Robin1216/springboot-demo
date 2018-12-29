package com.robin.springboot.demo.java_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
//        String startDateStr = "2018-12-01";
//        String endDateStr = "2019-01-01";
//        String dealDateStr = "2018-12-14";
//        System.out.println(getStartDateStrForRound(startDateStr, endDateStr, dealDateStr));

        System.out.println(getLatestBookTimeForAhead(1, 60));
    }

    private static void isRang(Date date,Date star){

    }

    // 判断日期是否在允许范围内：如果在，返回最早日期；如果不在，返回 null
    private static String getStartDateStrForRound(String startDateStr, String endDateStr, String dealDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date starDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            Date dealDate = sdf.parse(dealDateStr);

            if (starDate.getTime() <= dealDate.getTime() && dealDate.getTime() < endDate.getTime()) {
                return dealDateStr;
            } else if (starDate.getTime() > dealDate.getTime()) {
                return startDateStr;
            } else {
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BookDateDesc getStarDateForAheadTime(Integer aheadTimeType, Integer aheadMinutes) {
        BookDateDesc dateDesc = new BookDateDesc();
        if (2 == aheadTimeType) {
            dateDesc.setType(2);
            Date startDate = new Date(new Date().getTime() + aheadMinutes * 60 * 1000);
            if (MyDateUtils.getEndOfDay(startDate).getTime() > startDate.getTime()) {
                dateDesc.setDateStr(MyDateUtils.formatDate(startDate));
            } else {
                dateDesc.setDateStr(MyDateUtils.formatDate(MyDateUtils.addDays(startDate, 1)));
            }
        } else if (3 == aheadTimeType) {
            Date currentTime = new Date();
            if (currentTime.getTime() + aheadMinutes * 60 * 1000 > MyDateUtils.getEndOfDay(currentTime).getTime()) {
                dateDesc.setType(2);
                dateDesc.setDateStr(MyDateUtils.formatDate(MyDateUtils.addDays(currentTime, 1)));
            } else {
                dateDesc.setType(1);
                long dateInterval = MyDateUtils.getEndOfDay(currentTime).getTime() - aheadMinutes * 60 * 1000;
                String pattern = "HH:mm";
                dateDesc.setDateStr(MyDateUtils.formatDate(new Date(dateInterval), pattern));
            }
        } else {
            dateDesc.setType(0);
        }
        return dateDesc;
    }

    private static Date getLatestBookTimeForAhead(Integer aheadTimeType, Integer aheadMinutes) {
        Date currentTime = new Date();
        long gap = aheadMinutes * 60 * 1000;
        long oneDay = 24 * 60 * 60 * 1000;
        long oneSecond = 1000;
        switch (aheadTimeType) {
            case 1:
                return MyDateUtils.getEndOfDay(currentTime);
            case 2:
                gap = gap + oneDay;
            case 3:
                Date tempDate = new Date(currentTime.getTime() + gap);
                if (MyDateUtils.getEndOfDay(currentTime).getTime() > tempDate.getTime()) {
                    return new Date(MyDateUtils.getEndOfDay(currentTime).getTime() + oneSecond - gap);
                } else {
                    return MyDateUtils.getStartOfDay(tempDate);
                }
        }
        return MyDateUtils.getEndOfDay(currentTime);
    }

}
