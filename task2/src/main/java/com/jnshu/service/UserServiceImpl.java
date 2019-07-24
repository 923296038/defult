package com.jnshu.service;

import com.jnshu.dao.UserDao;
import com.jnshu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public int addUser(User user) {
        userDao.addUser(user);
        return user.getId();
    }
}
