package com.gok.daohuai.service;

import com.gok.daohuai.mapper.CourseMapper;
import com.gok.daohuai.mapper.TeacherMapper;
import com.gok.daohuai.pojo.Course;
import com.gok.daohuai.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TeacherService {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    Scanner scanner = new Scanner(System.in);

    Teacher teacher = new Teacher();

    private TeacherMapper teacherMapper;

    private CourseMapper courseMapper;

    public TeacherService() throws IOException {
    }

    boolean flag = true;


    public void manage() throws Exception {
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
//                login();
                    if (login() != 0) {
                        while (flag) {
                            System.out.println("login success");
                            System.out.println("select the Funciton");
                            System.out.println("1 修改密码");
                            System.out.println("2 发布课程");
                            System.out.println("3 已发布课程");
                            System.out.println("4 课程详情");
                            System.out.println("5 课程信息修改");
                            System.out.println("6 退出登陆");
                            System.out.println("7 开课");
                            System.out.println("8 打分");
                            System.out.println("9 查看学生");
                            System.out.println("10 分数修改");
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

    private void register() {
        Teacher teacher = new Teacher();
        System.out.println("请输入信息");
        System.out.println("Name 用户名");
        System.out.println("passwd");
        System.out.println("realName 真实名字");
        System.out.println("gender");
        String teacherName = scanner.nextLine();
        String password = scanner.nextLine();
        String realName = scanner.nextLine();
        String gender = scanner.nextLine();
//        teacher.setTeacherName(teacherName);
//        teacher.setPassword(password);
//        teacher.setRealName(realName);
//        teacher.setGender(gender);
        sqlSession.getMapper(TeacherMapper.class).insertTeacher(teacherName, password, realName, gender, 1);

    }

    private int login() throws Exception {
        System.out.println("请输入信息");
        System.out.println("Name 用户名");
        System.out.println("passwd");
        String teacherName = scanner.nextLine();
        String password = scanner.nextLine();
        List<Teacher> teachers = sqlSession.getMapper(TeacherMapper.class).login(teacherName, password);
//        System.out.println(teachers);
        if (teachers != null) {
            teacher.setTeacherName(teachers.get(0).getTeacherName());
            teacher.setPassword(teachers.get(0).getPassword());
            teacher.setRealName(teachers.get(0).getRealName());
            teacher.setGender(teachers.get(0).getGender());
            teacher.setTeacherId(teachers.get(0).getTeacherId());
        } else {
            return 0;
        }
//        sqlSession.getMapper(TeacherMapper.class).login(teacherName, password);
        return sqlSession.getMapper(TeacherMapper.class).login(teacherName, password).size();
    }

    private void operation(int i) {
        while (true) {
            switch (i) {
                case 1:
                    System.out.println("修改密码");
                    System.out.println("新密码");
                    System.out.println("用户名");
                    sqlSession.getMapper(TeacherMapper.class).updatePassword(scanner.nextLine(), scanner.nextLine());
                    break;
                case 2:
                    System.out.println("发布课程");
                    System.out.println("课程名");
                    String courseName = scanner.next();
                    System.out.println("课程描述");
                    String desc = scanner.nextLine();
                    System.out.println("课程人数");
                    String maxNum = String.valueOf(scanner.nextInt());
                    System.out.println("课程申请人数");
                    String applyNum = String.valueOf(scanner.nextInt());
                    long teacherId = teacher.getTeacherId();
                    LocalDate date = LocalDate.now();
                    LocalDate date1 = date.plusDays(7);
                    courseMapper.insert(new Course(courseName, maxNum, applyNum, teacherId, desc, date, date1, 0));


                    break;
                case 3:
                    System.out.println("已发布课程");
                    long teacherId2 = teacher.getTeacherId();
                    System.out.println("请输入课程状态 0选课中、1选课结束、2授课中、3已结课");
                    List<Course> teacherList = sqlSession.getMapper(TeacherMapper.class).getcourseList(teacherId2);
                    for (int j = 0; j < teacherList.size(); j++) {
                        System.out.println(teacherList.get(j));
                    }
                    break;
                case 4:
                    System.out.println("课程详情");
                    System.out.println("课程id");
                    long courseId = scanner.nextLong();
                    Course course = sqlSession.getMapper(TeacherMapper.class).getcourse(courseId);
                    System.out.println(course);

                    break;
                case 5:
                    System.out.println("课程信息修改");
                    System.out.println("课程id");
                    long courseId2 = scanner.nextLong();
                    System.out.println("课程名");
                    String courseName2 = scanner.nextLine();
                    System.out.println("课程描述");
                    String desc2 = scanner.nextLine();
                    System.out.println("课程人数");
                    int maxNum2 = scanner.nextInt();
                    System.out.println("课程申请人数");
                    int applyNum2 = scanner.nextInt();
//                    System.out.println("课程老师id");
//                    long teacherId3 = scanner.nextLong();
                    long teacherId3 = teacher.getTeacherId();

                    sqlSession.getMapper(TeacherMapper.class).updateCourse(courseId2, courseName2, desc2, maxNum2, applyNum2, teacherId3);

                    break;
                case 6:
                    System.out.println("退出");
                    flag = false;
                    break;
                case 7:
                    System.out.println("开课");
                    System.out.println("已结束的课程");
                    courseMapper.getCourseInEnd();
                    System.out.println("请输入课程id");
                    long courseId3 = scanner.nextLong();
                    courseMapper.updateStatus(courseId3);
                    break;
                case 8:
                    System.out.println("打分");
                    System.out.println("授课中的课程");
                    courseMapper.getCourseInStart();
                    System.out.println("请输入课程id");
                    String courseId4 = String.valueOf(scanner.nextLong());
                    System.out.println("请输入学生id");
                    long studentId = scanner.nextLong();
                    System.out.println("请输入分数");
                    int score = scanner.nextInt();
                    courseMapper.insertScore(courseId4, String.valueOf(studentId), score);
                    break;

                case 9:
                    System.out.println("查看学生");
                    break;
                case 10:
                    System.out.println("分数修改");
                    System.out.println("输入课程id");
                    String courseId5 = String.valueOf(scanner.nextLong());
                    System.out.println("输入学生id");
                    long studentId2 = scanner.nextLong();
                    System.out.println("输入分数");
                    int score2 = scanner.nextInt();
                    courseMapper.updateScore(courseId5, String.valueOf(studentId2), score2);
                    break;
                default:
                    System.out.println("please input 1,2,3,4,5,6");
                    break;
            }
            break;
        }

    }
}
