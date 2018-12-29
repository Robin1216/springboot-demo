package com.robin.springboot.demo.mongodb;


public interface PriceCompareDocumentService {

    /**
     * 通过供应商类型、供应商景点Id、信息来源、日期，获取价格日历
     *
     * @param supType   供应商类型， 美团:mei_tuan, 自我游:zi_wo_you, 飞猪:fei_zhu, 马蜂窝:ma_feng_wo, 携程:xie_cheng, 去哪儿:qu_na_r, 驴妈妈:lu_ma_ma
     * @param supSpotId 供应商景点id
     * @param fromType  信息来源类型： web, api
     * @param date      日期，格式： yyyy-MM-dd 日期
     * @return PriceCompareDocument
     */
    PriceCompareDocument getPriceCompareDocumentByDateAndSupTypeAndSupSpotId(String supType, String supSpotId, String fromType, String date);

    /**
     * 通过供应商类型、供应商景点Id、信息来源、日期，获取价格日历
     *
     * @param supType 供应商类型， 美团:mei_tuan, 自我游:zi_wo_you, 飞猪:fei_zhu, 马蜂窝:ma_feng_wo, 携程:xie_cheng, 去哪儿:qu_na_r, 驴妈妈:lu_ma_ma
     * @param supSpotId 供应商景点id
     * @param fromType 信息来源类型： web, api
     * @param date 日期，格式： yyyy-MM-dd 日期
     * @return PriceCalendarDocument
     */
    PriceCompareDocument findBySupTypeAndSupSpotIdAndFromTypeAndDate(String supType, String supSpotId, String fromType, String date);
}
