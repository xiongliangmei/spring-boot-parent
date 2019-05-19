package com.xiongliang.service;

import com.xiongliang.entity.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    List<User> findAll();
    User findByLoginName(String loginName);
}
