package com.service.impl;

import com.Dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService1")
public class UserServiceImpl implements UserService {
    @Autowired
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
