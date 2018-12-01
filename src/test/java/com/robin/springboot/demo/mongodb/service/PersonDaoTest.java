package com.robin.springboot.demo.mongodb.service;

import com.robin.springboot.demo.Application;
import com.robin.springboot.demo.mongodb.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Test
    public void testInsert(){
        Person person= new Person();
        person.setId(3l);
        person.setName("test");
        person.setAddress("测试地址");
        person.setAge(20);
        personDao.insert(person);

    }

    @Test
    public void testUpdate(){
        Person person = personDao.findBbId(1l);
        System.out.println(person);
        person.setName("更新名字");
        person.setAddress("更新地址");
        personDao.update(person);
        System.out.println(personDao.findBbId(1l));
    }

    @Test
    public void testFind(){
        System.out.println(personDao.findBbId(1l));
        System.out.println(personDao.findBbId(2l));
    }


}
