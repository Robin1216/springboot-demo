package com.robin.springboot.demo.ElasticSearch.service;

import com.robin.springboot.demo.Application;
import com.robin.springboot.demo.ElasticSearch.domain.City;
import com.robin.springboot.demo.ElasticSearch.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Test
    public void findByDescriptionAndScoreTest(){
        List<City> cities = cityRepository.findByDescriptionAndScore("热城市",4);

//        cities.forEach(System.out::println);
//        cities.forEach(city -> System.out.println(city.toString()));
    }

}
