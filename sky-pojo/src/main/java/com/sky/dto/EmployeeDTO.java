package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    // 注意一下，这个类型中并没有定义 get,set，tostring 方法，
    // 而是直接使用 Lombok 库中的@Data注解，不需要手动编写 get ,set 这些方法
    private Long id;

    private String username;

    private String name;

    private String phone;

    private String sex;

    private String idNumber;

}
