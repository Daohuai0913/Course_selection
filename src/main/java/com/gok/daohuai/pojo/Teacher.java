package com.gok.daohuai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Long teacherId;
    private String teacherName;
    private String password;
    private String realName;
    private String gender;
    private int status;


}
