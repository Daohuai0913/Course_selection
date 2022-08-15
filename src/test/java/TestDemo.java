import com.gok.daohuai.service.StuService;
import com.gok.daohuai.service.TeacherService;

import java.beans.beancontext.BeanContext;
import java.io.IOException;
import java.util.Scanner;

public class TestDemo {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("欢迎来到学生选课系统");
        System.out.println("请选择您的身份：");
        System.out.println("1.学生");
        System.out.println("2.教师");
        System.out.println("3.退出");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                new StuService().manage();
                break;
            case 2:
                new TeacherService().manage();
                break;
            case 3:
                System.out.println("quit");
                System.exit(0);
                break;

        }

    }
}
