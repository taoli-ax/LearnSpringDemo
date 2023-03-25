package com.app;

import com.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class appTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user =(User)classPathXmlApplicationContext.getBean("User");
        user.setUsername("admin");
        user.setPhone("123456789");
        System.out.println(user.toString());
    }
}
