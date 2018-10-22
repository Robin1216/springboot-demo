package com.robin.springboot.demo.db.mybatis.mapper;

import com.robin.springboot.demo.db.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
