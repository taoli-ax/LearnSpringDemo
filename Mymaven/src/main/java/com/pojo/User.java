package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class User {
    private  String username;
    private  String phone;
    public User(){
        System.out.println("User.user");
    }
}
