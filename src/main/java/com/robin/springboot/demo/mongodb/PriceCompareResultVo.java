package com.robin.springboot.demo.mongodb;

import lombok.Data;

/**
 * @author: silkNets
 * @since: 2018/12/26 10:00
 * @Description:
 */
@Data
public class PriceCompareResultVo {
    /**
     * 供应商类型 -- 美团:mei_tuan, 自我游:zi_wo_you, 飞猪:fei_zhu, 马蜂窝:ma_feng_wo, 携程:xie_cheng, 去哪儿:qu_na_r, 驴妈妈:lu_ma_ma
     */
    private String sup_type;

    /**
     * 供应商景点ID
     */
    private String sup_spot_id;

    /**
     * 供应商产品ID
     */
    private String sup_product_id;

    /**
     * 数据来源
     */
    private String from_type;

    /**
     * 抓取平台预订跳转地址
     */
    private String booking_url;

    /**
     * 价格日历
     */
    private PriceCalendarDocument price_rilis;
}
