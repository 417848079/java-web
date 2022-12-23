package com.xxq.mapper;

import com.xxq.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectById(int id);
}
