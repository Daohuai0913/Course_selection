package com.gok.daohuai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String courseNo;
    private String courseName;
    private String maxNum;
    private String applyBum;
    private long teacherId;
    private String desc;

    private LocalDate createTime;
    private LocalDate EndTime;

//    0选课中、1选课结束、2授课中、3已结课
    private int status;

    public Course( String courseName, String maxNum, String applyBum, long teacherId, String desc, LocalDate createTime, LocalDate endTime, int status) {
        this.courseName = courseName;
        this.maxNum = maxNum;
        this.applyBum = applyBum;
        this.teacherId = teacherId;
        this.desc = desc;
        this.createTime = createTime;
        EndTime = endTime;
        this.status = status;
    }



}
