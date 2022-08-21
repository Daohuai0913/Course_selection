package com.gok.daohuai.mapper;

import com.gok.daohuai.pojo.Course;
import com.gok.daohuai.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMapper {
    void insertStudent(@Param("password") String password, @Param("age") int age, @Param("gender") String gender, @Param("address") String address, @Param("phone") String phone);

    List<Student> login(@Param("stuId") long stuId, @Param("password") String password);

    Student selectStudent(@Param("stuId") long stuId);

    void updateStudent(@Param("password") String password, @Param("age") int age, @Param("gender") String gender, @Param("address") String address, @Param("phone") String phone, @Param("id") long id);

    List<Course> selectAllCourse();

    List<Course> selectCourse(@Param("stuId") long stuId);

    void choseCourse(@Param("stuId") long stuId, @Param("courseNo") long courseNo);

    /**
     * 点击选课按钮后，先展示处于选课中状态的全部课程，但如果该课程已经被选过，则不展示出来；
     * 选课时，需要输入课程编号进行选课，如果课程不存在，予以提示。
     */
    List<Course> getCourseByLimit(@Param("stuId") long StuId);

    List<Course> getCourseByLike(@Param("courseName") String courseName);

    List<Course> getCourseByTeacher(@Param("teacherName") String teacherName);

    void updateApplyNum(@Param("courseNo") long courseNo);

    void insertCourse (@Param("courseNo") long courseNo ,@Param("stuId") long stuId);


}
