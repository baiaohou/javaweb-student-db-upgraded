//package com.lagou.test;
//
//import com.lagou.bean.Student;
//import com.lagou.bean.User;
//import com.lagou.dao.UserDao;
//import com.lagou.dao.imp.UserDaoImp;
//import com.lagou.service.StudentService;
//import com.lagou.service.UserService;
//import org.junit.Test;
//
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * @author baiaohou
// * @create 2020-08-31 3:46 PM
// */
//public class StudentServiceTest {
//
//    StudentService ss = new StudentService();
//
//    @Test
//    public void testCheckIfSIDExists() throws SQLException {
//        if (ss.checkIfSIDExists("1")) {
//            System.out.println("学号存在！");
//        } else {
//            System.out.println("学号不存在！");
//        }
//    }
//
//    @Test
//    public void testGetAllStudents() throws SQLException {
//        List<Student> allStudents = ss.getAllStudents();
//        for (Student student : allStudents) {
//            System.out.println(student);
//        }
//    }
//
//    @Test
//    public void testGetStudentBySID() throws SQLException {
//        Student student1 = ss.getStudentBySID("2");
//        System.out.println("学号为 2 的学员信息：" + student1);
//
//        Student student2 = ss.getStudentBySID("555");
//        System.out.println("学号为 555 的学员信息：" + student2);
//    }
//
//    @Test
//    public void testRemoveStudentBySID() throws SQLException {
//        System.out.println("删除前的数据库信息：");
//        this.testGetAllStudents(); // print all students
//        System.out.println("现在删除学号为5的学员...");
//        boolean bool = ss.removeStudentBySID("5");
//        if (bool) {
//            System.out.println("以下为数据库最新信息:");
//            this.testGetAllStudents();
//        } else {
//            System.out.println("删除失败！");
//        }
//    }
//
//    @Test
//    public void testAddStudent() throws SQLException {
//        System.out.println("添加前的数据库信息：");
//        this.testGetAllStudents(); // print all students
//        Student student = new Student("小汉堡", "未知", "2008-08-08",
//                "burger@qq.com", "哈拉少的午餐");
//        boolean bool = ss.addStudent(student);
//        if (bool) {
//            System.out.println("现在添加学员[小汉堡]... 以下为数据库最新信息：");
//            this.testGetAllStudents(); // print all students
//        } else {
//            System.out.println("添加失败！");
//        }
//    }
//
//    @Test
//    public void testUpdateStudentBySID() throws SQLException {
//        System.out.println("更新前的数据库信息：");
//        this.testGetAllStudents(); // print all students
//
//        Student student = new Student("老八蜜汁小汉堡", "未知", "2020-02-02",
//                "laobaburger@qq.com", "哈拉少");
//        student.setSid("7"); // 根据学号==5 来判断更新内容
//        boolean bool = ss.updateStudentBySID(student);
//        if (bool) {
//            System.out.println("更新成功！以下为数据库最新信息：");
//            this.testGetAllStudents(); // print all students
//        } else {
//            System.out.println("更新失败！");
//        }
//    }
//}
