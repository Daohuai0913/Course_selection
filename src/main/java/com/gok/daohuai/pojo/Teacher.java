package com.gok.daohuai.pojo;

public class Teacher {
    private Long teacherId;
    private String teacherName;
    private String password;
    private String realName;
    private String gender;
    private int status;

    public Teacher() {
    }

    public Teacher(Long teacherId, String teacherName, String password, String realName, String gender, int status) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.password = password;
        this.realName = realName;
        this.gender = gender;
        this.status = status;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender='" + gender + '\'' +
                ", status=" + status +
                '}';
    }
}
