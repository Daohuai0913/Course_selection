package com.gok.daohuai.service;

import com.gok.daohuai.mapper.StuMapper;
import com.gok.daohuai.mapper.TeacherMapper;
import com.gok.daohuai.pojo.Course;
import com.gok.daohuai.pojo.Student;
import com.gok.daohuai.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class StuService {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    Scanner scanner = new Scanner(System.in);


    public StuService() throws IOException {
    }

    public void manage() {
        System.out.println("student manage system");
        System.out.println("select the Funciton");
        System.out.println("1.login");
        System.out.println("2.register");
        System.out.println("3.quit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                if (login() != 0) {
                    System.out.println("login success");
                    System.out.println("select the Funciton");
                    System.out.println("1.个人信息查询");
                    System.out.println("2.个人基础信息修改");
                    System.out.println("3.全部课程列表查看");
                    System.out.println("4.选课");
                    System.out.println("5.已选课程查询");
                    System.out.println("6.退出");
                    int choice2 = sc.nextInt();
                    operation(choice2);

                } else {
                    System.out.println("login failed");
                }

                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("quit");
                System.exit(0);
                break;
            default:
                System.out.println("please input 1,2,3");
                break;

        }
    }

    private int login() {
        System.out.println("input your id");
        long id = scanner.nextLong();
        System.out.println("input your password");
        String password = scanner.next();
        sqlSession.getMapper(StuMapper.class).login(id, password);
        return sqlSession.getMapper(StuMapper.class).login(id, password).size();

    }

    private void register() {
        Student student = new Student();
        System.out.println("请输入信息");
        System.out.println("passwd");
        System.out.println("age");
        System.out.println("gender");
        System.out.println("address");
        System.out.println("phone");
        String password = scanner.nextLine();
        int age = scanner.nextInt();
        String gender = scanner.nextLine();
        String address = scanner.nextLine();
        String phone = scanner.nextLine();
        student.setPassword(password);
        student.setAge(age);
        student.setGender(gender);
        student.setAddress(address);
        student.setPhone(phone);
        sqlSession.getMapper(StuMapper.class).insertStudent(password, age, gender, address, phone);


    }

    private void operation(int i) {
        switch (i) {
            case 1:
                System.out.println("个人信息查询");
                System.out.println("请输入学号");
                long id = scanner.nextLong();
                System.out.println(sqlSession.getMapper(StuMapper.class).selectStudent(id));
                break;
            case 2:
                System.out.println("个人基础信息修改");
                System.out.println("请输入学号");
                long id2 = scanner.nextLong();
                System.out.println("passwd");
                String password = scanner.nextLine();
                System.out.println("age");
                int age = scanner.nextInt();
                System.out.println("gender");
                String gender = scanner.nextLine();
                System.out.println("address");
                String address = scanner.nextLine();
                System.out.println("phone");
                String phone = scanner.nextLine();
                sqlSession.getMapper(StuMapper.class).updateStudent(password, age, gender, address, phone, id2);
                break;
            case 3:
                System.out.println("全部课程列表查看");
                List<Course> courses = sqlSession.getMapper(StuMapper.class).selectAllCourse();
                for (int j = 0; j < courses.size(); j++) {
                    System.out.println(courses.get(j));
                }
                break;
            case 4:
                System.out.println("选课");
                System.out.println("请输入学号");
                long id3 = scanner.nextLong();
                System.out.println("请输入课程号");
                long courseId = scanner.nextLong();
                sqlSession.getMapper(StuMapper.class).choseCourse(id3, courseId);

                break;
            case 5:
                System.out.println("已选课程查询");
                System.out.println("请输入学号");
                long id4 = scanner.nextLong();
                List<Course> courses2 = sqlSession.getMapper(StuMapper.class).selectCourse(id4);
                for (Course course : courses2) {
                    System.out.println(course);
                }
                break;
            case 6:
                System.out.println("退出");
                break;
            default:
                System.out.println("please input 1,2,3,4,5,6");
                break;
        }
    }

}
