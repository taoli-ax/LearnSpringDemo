package com.util;

import com.Dao.impl.UserDaoImpl;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;

public class UserServiceFactoryBean implements FactoryBean<UserService> {
    /**
     *
     *
     * **/
    public UserService getObject() throws Exception {
        UserServiceImpl userService=new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl());
        return userService;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
