package com.gok.daohuai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gok.daohuai.pojo.Course;
import com.gok.daohuai.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 已经结束了的课程
     */
    int checkIsEnd(String courseNo);

    void updateStatus(long courseNo);

    List<Course> getCourseInEnd();

    List<Course> getCourseInStart();

    void insertScore(@Param("id") String courseNo, @Param("name") String studentNo, @Param("score") int score);


    /*
    * 显示时，如果这个班级是处于选课中、选课结束、授课中这几个状态，则对学生数据按学号升序排列；
        显示时，如果是处于已结课状态，则对学生列表按成绩降序排列。*/
    List<Student> getStudentList(@Param("teacherId") long teacherId);

    void updateScore(@Param("id") String courseNo, @Param("name") String studentNo, @Param("score") int score);


}
