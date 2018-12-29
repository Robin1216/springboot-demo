package com.robin.springboot.demo.mongodb.service;

import com.robin.springboot.demo.mongodb.pojo.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person,String> {
    Person findById(long id);

    List<Person> findByName(String name);
}
