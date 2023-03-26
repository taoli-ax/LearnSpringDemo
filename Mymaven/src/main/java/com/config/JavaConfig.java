package com.config;

import com.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public User user(){
        System.out.println("hello user");
        return new User();
    }
}
