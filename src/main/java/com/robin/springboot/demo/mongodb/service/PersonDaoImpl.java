package com.robin.springboot.demo.mongodb.service;

import com.robin.springboot.demo.mongodb.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Person findBbId(long id) {
        Criteria criteria = new Criteria();
        criteria.where("id").is(id);
        Query query = new Query(criteria);
        Person person = mongoTemplate.findOne(query, Person.class);
        return person;
    }

    @Override
    public void insert(Person person) {
        mongoTemplate.insert(person);
    }

    @Override
    public void update(Person person) {
        Query query = new Query(Criteria.where("id").is(person.getId()));
        Update update = new Update().set("name", person.getName()).set("age", person.getAge()).set("address", person.getAddress());

        // 更新查询犯忌讳结果集的第一条
        mongoTemplate.updateFirst(query, update, Person.class);

        // 更新查询结果集的所有
        mongoTemplate.updateMulti(query, update, Person.class);
    }

    @Override
    public void delete(long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Person.class);
    }
}
