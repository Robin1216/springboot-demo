package com.robin.springboot.demo.mongodb.service;

import com.robin.springboot.demo.mongodb.pojo.Person;

public interface PersonDao {
    Person findBbId(long id);

    void insert(Person person);

    void update(Person person);

    void delete(long id);
}
