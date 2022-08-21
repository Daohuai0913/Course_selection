package com.gok.daohuai.service;

import com.gok.daohuai.mapper.StuMapper;
import com.gok.daohuai.pojo.Course;
import com.gok.daohuai.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class StuService {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    Scanner scanner = new Scanner(System.in);


    public StuService() throws IOException {
    }

    Student student = new Student();

    public void manage() {
        while (true) {
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
                        while (true) {
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
                        }

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
    }

    private int login() {
        System.out.println("input your id");
        long id = scanner.nextLong();
        System.out.println("input your password");
        String password = scanner.next();
        student.setStudentId(id);
        student.setPassword(password);
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
//        student.setPassword(password);
//        student.setAge(age);
//        student.setGender(gender);
//        student.setAddress(address);
//        student.setPhone(phone);
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
//                System.out.println("请输入学号");
//                long id2 = scanner.nextLong();
                System.out.println("passwd");
                String password = scanner.next();
                System.out.println("age");
                int age = Integer.parseInt(scanner.next());
                System.out.println("gender");
                String gender = scanner.next();
                System.out.println("address");
                String address = scanner.next();
                System.out.println("phone");
                String phone = scanner.next();
                sqlSession.getMapper(StuMapper.class).updateStudent(password, age, gender, address, phone, student.getStudentId());
                break;
            case 3:
                System.out.println("全部课程列表查看");
                List<Course> courses = sqlSession.getMapper(StuMapper.class).selectAllCourse();
                for (int j = 0; j < courses.size(); j++) {
                    System.out.println(courses.get(j));
                }
                System.out.println("可以根据老师姓名或者课程名查询");
                System.out.println("请输入老师姓名或者课程名");
                System.out.println("1 根据老师姓名查询");
                System.out.println("2 根据课程名查询");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("输入老师姓名");
                    String teacherName = scanner.next();
                    List<Course> courses1 = sqlSession.getMapper(StuMapper.class).getCourseByTeacher(teacherName);
                    for (Course course : courses1) {
                        System.out.println(course);
                    }
                } else if (choice == 2) {
                    System.out.println("输入课程名");
                    String courseName = scanner.next();
                    List<Course> courses2 = sqlSession.getMapper(StuMapper.class).getCourseByLike(courseName);
                    for (Course course : courses2) {
                        System.out.println(course);
                    }


                }
                break;
            case 4:
                System.out.println("选课");
                long id3 = student.getStudentId();
//                先展示没有被选择的课程 或者没有重复的课程 没有截止 课程存在的情况下的课程
                List<Course> courseList = sqlSession.getMapper(StuMapper.class).getCourseByLimit(id3);
                System.out.println(courseList);
                if (courseList.size() == 0) {
                    System.out.println("没有可选课程");
                } else {
                    System.out.println("请输入课程Id");
                    long courseId = scanner.nextLong();
                    sqlSession.getMapper(StuMapper.class).insertCourse(courseId, id3);
                    sqlSession.getMapper(StuMapper.class).updateApplyNum(courseId);
                }



                break;
            case 5:
                System.out.println("已选课程查询");
                System.out.println("请输入学号");
                long id4 = student.getStudentId();

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
