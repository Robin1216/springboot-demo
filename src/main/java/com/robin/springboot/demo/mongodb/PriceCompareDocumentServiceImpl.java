package com.robin.springboot.demo.mongodb;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Slf4j
@Service
public class PriceCompareDocumentServiceImpl extends MongoSuperServiceImpl<PriceCompareDocumentRepository, PriceCompareDocument, ObjectId> implements PriceCompareDocumentService {

    @Override
    public PriceCompareDocument getPriceCompareDocumentByDateAndSupTypeAndSupSpotId(String supType, String supSpotId, String fromType, String date) {

        // https://blog.csdn.net/bicheng4769/article/details/79629227
        Aggregation agg = newAggregation(
                unwind("$price_rilis"),
                match(Criteria.where("sup_type").is(supType)
                        .and("from_type").is(fromType)
                        .and("sup_spot_id").is(supSpotId)
                        .and("price_rilis.date").is(date)),
                project("sup_type","sup_spot_id","sup_product_id","from_type","booking_url","price_rilis")
        );
        AggregationResults<PriceCompareResultVo> results = mongoTemplate.aggregate(agg, "d_snc_price_rilis", PriceCompareResultVo.class);
        List<PriceCompareResultVo> resultList = results.getMappedResults();
        for (PriceCompareResultVo o : resultList) {
            System.out.println(o.toString());
        }
//        PriceCompareDocument document = this.mongoRepository.findBySupTypeAndSupSpotIdAndFromType(supType, supSpotId, fromType);
//        PriceCompareDocument document = this.mongoRepository.findBySupTypeAndSupSpotIdAndFromTypeAndDate(supType, supSpotId, fromType, date);
//        if (null != document) return document;

        log.error("getPriceCompareDocumentByDateAndSupTypeAndSupSpotId -- priceCompareDocument is null. supType:{}, supSpotId:{}, fromType:{}, date:{}", supType, supSpotId, fromType, date);
        return null;
    }

    @Override
    public PriceCompareDocument findBySupTypeAndSupSpotIdAndFromTypeAndDate(String supType, String supSpotId, String fromType, String date) {
        return null;
    }
}
