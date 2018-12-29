package com.robin.springboot.demo.mongodb;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @program scenic-core
 * @className 第三方平台比价后的价格日历
 * @description 根据价格日历表 d_snc_price 汇聚的各三方平台每日最低价格
 * @createDate 2018-12-20 18:30
 */
@Document(collection = "d_snc_price_rilis")
@Data
public class PriceCompareDocument {
    @Id
    private ObjectId id;

    /**
     * 供应商类型 -- 美团:mei_tuan, 自我游:zi_wo_you, 飞猪:fei_zhu, 马蜂窝:ma_feng_wo, 携程:xie_cheng, 去哪儿:qu_na_r, 驴妈妈:lu_ma_ma
     */
    @Field("sup_type")
    private String supType;

    /**
     * 供应商景点ID
     */
    @Field("sup_spot_id")
    private String supSpotId;

    /**
     * 供应商产品ID
     */
    @Field("sup_product_id")
    private String supProductId;

    /**
     * 数据来源
     */
    @Field("from_type")
    private String fromType;

    /**
     * 抓取平台预订跳转地址
     */
    @Field("booking_url")
    private String bookingUrl;

    /**
     * 价格日历
     */
    @Field("price_rilis")
    private List<PriceCalendarDocument> priceRilis;
}
