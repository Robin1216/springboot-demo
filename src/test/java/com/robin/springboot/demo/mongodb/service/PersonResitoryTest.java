package com.robin.springboot.demo.mongodb.service;

import com.robin.springboot.demo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PersonResitoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testFindById() {
        System.out.println(personRepository.findById(1l));
    }

    @Test
    public void testFindByName() {
        System.out.println(personRepository.findByName("更新名字"));
    }
}
