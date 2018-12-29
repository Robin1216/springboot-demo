package com.robin.springboot.demo.mongodb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class MongoSuperServiceImpl< R extends MongoRepository, T extends  Object, ID> implements MongoSuperService {

    //  能使用 JPA mongodb  操作的优先使用，jpa mongodb 操作， 不能满足，再使用 mongoTemplate 作为补充
    @Autowired
    protected R mongoRepository;
    @Autowired
    protected MongoTemplate mongoTemplate;

}
