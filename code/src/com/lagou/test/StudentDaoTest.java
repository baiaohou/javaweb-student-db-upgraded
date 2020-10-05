//package com.lagou.test;
//
//import com.lagou.bean.Student;
//import com.lagou.dao.StudentDao;
//import com.lagou.factory.StudentDaoFactory;
//import org.junit.Test;
//
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * @author baiaohou
// * @create 2020-08-31 9:24 PM
// */
//public class StudentDaoTest {
//
//    // 获取StudentDao类实现对象，用于下述测试
//    private StudentDao studentDao = StudentDaoFactory.getStudentDao();
//
//    /**
//     * 测试StudentDaoImp类中getAllStudents()方法
//     */
//    @Test
//    public void testGetAllStudents() throws SQLException {
//        List<Student> allStudents = studentDao.getAllStudents();
//        for (Student student : allStudents) {
//            System.out.println(student);
//        }
//    }
//
//    /**
//     * 测试StudentDaoImp类中getStudentBySID()方法
//     */
//    @Test
//    public void testGetStudentBySID() throws SQLException {
//        Student student1 = studentDao.getStudentBySID("2");
//        System.out.println("学号为 2 的学员信息：" + student1);
//
//        Student student2 = studentDao.getStudentBySID("555");
//        System.out.println("学号为 555 的学员信息：" + student2);
//    }
//
//    /**
//     * 测试StudentDaoImp类中removeStudentBySID()方法
//     */
//    @Test
//    public void testRemoveStudentBySID() throws SQLException {
//        System.out.println("删除前的数据库信息：");
//        this.testGetAllStudents(); // print all students
//        System.out.println("现在删除学号为5的学员...");
//        int row = studentDao.removeStudentBySID("5");
//        if (row > 0) {
//            System.out.println("以下为数据库最新信息:");
//            this.testGetAllStudents();
//        } else {
//            System.out.println("删除失败！");
//        }
//    }
//
//    /**
//     * 测试StudentDaoImp类中addStudent()方法
//     */
//    @Test
//    public void testAddStudent() throws SQLException {
//        System.out.println("添加前的数据库信息：");
//        this.testGetAllStudents(); // print all students
//        Student student = new Student("小汉堡", "未知", "2008-08-08",
//                                    "burger@qq.com", "哈拉少的午餐");
//        int row = studentDao.addStudent(student);
//        if (row > 0) {
//            System.out.println("现在添加学员[小汉堡]... 以下为数据库最新信息：");
//            this.testGetAllStudents(); // print all students
//        } else {
//            System.out.println("添加失败！");
//        }
//    }
//
//    /**
//     * 测试StudentDaoImp类中updateStudentBySID()方法
//     */
//    @Test
//    public void testUpdateStudentBySID() throws SQLException {
//        System.out.println("更新前的数据库信息：");
//        this.testGetAllStudents(); // print all students
//
//        Student student = new Student("老八蜜汁小汉堡", "未知", "2020-02-02",
//                                "laobaburger@qq.com", "哈拉少的晚餐");
//        student.setSid("17"); // 根据学号==5 来判断更新内容
//        int row = studentDao.updateStudentBySID(student);
//        if (row > 0) {
//            System.out.println("更新成功！以下为数据库最新信息：");
//            this.testGetAllStudents(); // print all students
//        } else {
//            System.out.println("更新失败！");
//        }
//    }
//}
