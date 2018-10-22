package com.robin.springboot.demo.db.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Date createTime;
    private  Date updateTime;
}
