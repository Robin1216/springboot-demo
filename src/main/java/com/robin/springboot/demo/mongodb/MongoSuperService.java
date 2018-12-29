package com.robin.springboot.demo.mongodb;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoSuperService< R extends MongoRepository, T, ID>{

}
