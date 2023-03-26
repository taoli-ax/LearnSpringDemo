package com.app;

import com.config.JavaConfig;
import com.pojo.User;
import com.service.UserService;
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
    @Test
    public void testConstructor(){
        // 通过无参构造生成实例
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        User u1 =(User)applicationContext.getBean("User");
        System.out.println("无参构造生成实例："+u1);
        // 静态工厂
        User u2 =(User)applicationContext.getBean("User2");
        System.out.println("静态工厂生成实例："+u2);
        // 实例工厂
        User u3=(User) applicationContext.getBean("User3");
        System.out.println("实例工厂生成实例: "+u3);
    }
    @Test
    public void testSetterDI(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService)applicationContext.getBean("userService1");
        userService.save();
    }
    @Test
    public void testConstructorDI(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService)applicationContext.getBean("userService2");
        userService.save();
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService)applicationContext.getBean("FactoryBean");
        userService.save();
    }


}
