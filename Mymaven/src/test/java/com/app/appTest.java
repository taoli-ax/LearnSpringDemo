package com.app;

import com.config.JavaConfig;
import com.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class appTest {
    @Test
    public void test(){
        // 方式一
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 方式二
        ApplicationContext applicationContext1=new AnnotationConfigApplicationContext(JavaConfig.class);
        User user =(User)applicationContext.getBean("User");
        user.setUsername("admin");
        user.setPhone("123456789");
        System.out.println(user.toString());
    }
    @Test
    public void BeanFactoryTest(){
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        User user =(User)beanFactory.getBean("User");
        user.setUsername("admin");
        user.setPhone("123456789");
        System.out.println(user.toString());
    }
}
