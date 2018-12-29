package com.robin.springboot.demo.java_date;

import lombok.Data;

@Data
public class BookDateDesc {

    /**
     * 可预订类型：0 随时可定， 1 当天可订，2 当天不可定
     */
    Integer type;

    /**
     * 可预定的时间的字符串: type = 0, null;type = 1 , hh:mm ; type = 2 , yyyy-MM-dd
     */
    String dateStr;
}
