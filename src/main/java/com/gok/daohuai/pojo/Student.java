package com.gok.daohuai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long studentId;
    private String password;
    private String realName;
    private int age;
    private String gender;
    private String address;
    private String phone;


}
