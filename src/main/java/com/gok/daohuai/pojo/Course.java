package com.gok.daohuai.pojo;

import java.time.LocalDate;

public class Course {
    private String courseNo;
    private String courseName;
    private String maxNum;
    private String applyBum;
    private long teacherId;
    private String desc;

    private LocalDate createTime;

    private String status;

    public Course() {
    }

    public Course(String courseNo, String courseName, String maxNum, String applyBum, long teacherId, String desc) {
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.maxNum = maxNum;
        this.applyBum = applyBum;
        this.teacherId = teacherId;
        this.desc = desc;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(String maxNum) {
        this.maxNum = maxNum;
    }

    public String getApplyBum() {
        return applyBum;
    }

    public void setApplyBum(String applyBum) {
        this.applyBum = applyBum;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", maxNum='" + maxNum + '\'' +
                ", applyBum='" + applyBum + '\'' +
                ", teacherId=" + teacherId +
                ", desc='" + desc + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
