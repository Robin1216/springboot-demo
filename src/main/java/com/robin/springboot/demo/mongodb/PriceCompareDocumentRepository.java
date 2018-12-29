package com.robin.springboot.demo.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceCompareDocumentRepository extends MongoRepository<PriceCompareDocument, ObjectId> {


    /**
     * 通过供应商类型、供应商景点Id、信息来源，获取价格日历
     *
     * @param supType   供应商类型， 美团:mei_tuan, 自我游:zi_wo_you, 飞猪:fei_zhu, 马蜂窝:ma_feng_wo, 携程:xie_cheng, 去哪儿:qu_na_r, 驴妈妈:lu_ma_ma
     * @param supSpotId 供应商景点id
     * @param fromType  信息来源类型： web, api
     * @return PriceCalendarDocument
     */
    @Query("{'sup_type':'?0','sup_spot_id':{'$eq':'?1'},'from_type':'?2'}")
    PriceCompareDocument findBySupTypeAndSupSpotIdAndFromType(String supType, String supSpotId, String fromType);
}
