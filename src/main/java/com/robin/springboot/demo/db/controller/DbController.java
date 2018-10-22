package com.robin.springboot.demo.db.controller;

import com.robin.springboot.demo.db.jdbc.JDBCService;
import com.robin.springboot.demo.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private JDBCService jdbcService;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/jdbc/list")
    public List<User> getList() {
        return jdbcService.getAllUsers();
    }


}
