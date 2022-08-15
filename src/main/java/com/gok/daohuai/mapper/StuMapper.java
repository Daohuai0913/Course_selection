package com.gok.daohuai.mapper;

import com.gok.daohuai.pojo.Course;
import com.gok.daohuai.pojo.Student;
import com.gok.daohuai.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMapper {
    void insertStudent(@Param("password") String password , @Param("age") int age , @Param("gender") String gender, @Param("address") String address,@Param("phone")String phone);

    List<Student> login(@Param("stuId") long stuId, @Param("password") String password);

    Student selectStudent(@Param("stuId") long stuId);

    void updateStudent(@Param("password") String password , @Param("age") int age , @Param("gender") String gender, @Param("address") String address,@Param("phone")String phone,@Param("id" )long id);

    List<Course> selectAllCourse();

    List<Course> selectCourse(@Param("stuId") long stuId);

    void choseCourse(@Param("stuId") long stuId, @Param("courseNo") long courseNo);
}
