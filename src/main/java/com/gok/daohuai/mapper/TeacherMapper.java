package com.gok.daohuai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gok.daohuai.pojo.Course;
import com.gok.daohuai.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {
    void insertTeacher(@Param("teacherName") String teacherName, @Param("password") String password , @Param("realName") String realName , @Param("gender") String gender,@Param("state") int status);

    List<Teacher> login(@Param("teacherName") String teacherName,@Param("password") String password);

    void updatePassword(@Param("password") String password,@Param("teacherName") String teacherName);

    void insertClass(@Param("courseName") String courseName,@Param("maxNum") int maxNum,@Param("applyNum") int applyNum,@Param("teacherId") long teacherId,@Param("desc") String desc);

    List<Course> getcourseList(@Param("teacherId") long teacherId);

    Course getcourse(@Param("courseId") long teacherId);

    void updateCourse(@Param("courseId") long courseId,@Param("courseName") String courseName,@Param("desc") String desc,@Param("maxNum") int maxNum,@Param("applyNum") int applyNum,@Param("teacherId") long teacherId);


}
