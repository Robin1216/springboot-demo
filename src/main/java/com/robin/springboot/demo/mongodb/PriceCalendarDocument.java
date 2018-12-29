package com.robin.springboot.demo.mongodb;

import lombok.Data;

/**
 * @author: silkNets
 * @since: 2018/12/24 23:33
 * @Description: 价格日历信息对象
 */
@Data
public class PriceCalendarDocument {
    /**
     * 日期
     */
    private String date;

    /**
     * 当日价格
     */
    private Double price;

}
