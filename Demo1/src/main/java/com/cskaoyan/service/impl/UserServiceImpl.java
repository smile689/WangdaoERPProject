package com.cskaoyan.service.impl;

import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper mapper;

    @Override
    public User Login(String username, String password) {
        return mapper.findUserByUsernameAndPassword(username,password);
    }


}
