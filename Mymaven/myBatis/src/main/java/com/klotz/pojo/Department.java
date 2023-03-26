package com.klotz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
    private Integer deptNo;
    private String name;
    private String loc;

}
