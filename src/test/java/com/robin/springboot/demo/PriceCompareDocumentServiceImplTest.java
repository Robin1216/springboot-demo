package com.robin.springboot.demo;

import com.alibaba.fastjson.JSON;
import com.robin.springboot.demo.mongodb.PriceCompareDocument;
import com.robin.springboot.demo.mongodb.PriceCompareDocumentService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PriceCompareDocumentServiceImplTest extends BaseTest {

    @Autowired
    private PriceCompareDocumentService priceCompareDocumentService;

    @Test
    public void testGetPriceCompareDocumentByDateAndSupTypeAndSupSpotId() {
        String supType = "xie_cheng";
        String supSpotId = "1407638";
        String fromType = "web";
        String date = "2018-12-24";
        PriceCompareDocument document = priceCompareDocumentService.getPriceCompareDocumentByDateAndSupTypeAndSupSpotId(supType, supSpotId, fromType, date);
        System.out.println("testGetPriceCompareDocumentByDateAndSupTypeAndSupSpotId ++ " + document);
    }

    private void printList(List<PriceCompareDocument> list) {
        if (null != priceCompareDocumentService) {
            int i = 0;
            if (CollectionUtils.isNotEmpty(list)) {
                System.out.println("list.size() -- " + list.size());
//                spotMapDocuments.forEach(spotDocument -> System.out.println(JSON.toJSONString(spotDocument)));
                for (PriceCompareDocument document : list) {
                    System.out.println(JSON.toJSONString(document));
                    i++;
                    if (i == 3) break;
                }
            } else {
                System.out.println("printList --> null");
            }
        } else {
            System.out.println("printList service--> null");
        }
    }

}
