package com.xiongliang.service.impl;

import com.xiongliang.entity.User;
import com.xiongliang.repository.IUserRepository;
import com.xiongliang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByLoginName(String loginName) {
        return userRepository.findByUsername(loginName);
    }
}
