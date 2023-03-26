package com.service.impl;

import com.Dao.UserDao;
import com.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(){

    }
    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
    public void save() {
        userDao.save();
        System.out.println("userServiceImpl save");
    }
}
