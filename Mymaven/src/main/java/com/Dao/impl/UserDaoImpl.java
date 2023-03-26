package com.Dao.impl;

import com.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("userDao save method");
    }
}
