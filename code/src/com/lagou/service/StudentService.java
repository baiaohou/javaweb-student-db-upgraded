package com.lagou.service;

import com.lagou.bean.Student;
import com.lagou.bean.User;
import com.lagou.dao.StudentDao;
import com.lagou.dao.UserDao;
import com.lagou.factory.StudentDaoFactory;
import com.lagou.factory.UserDaoFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author baiaohou
 * @create 2020-08-31 3:43 PM
 */
public class StudentService {

    /**
     * 学生数据库访问层对象
     */
    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = StudentDaoFactory.getStudentDao();
    }

    public Student getStudentBySID(String sid) {
        if (checkIfSIDExists(sid)) {
            try {
                return studentDao.getStudentBySID(sid);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 检查给定sid学号是否存在于数据库中
     */
    public boolean checkIfSIDExists(String sid) {
        try {
            Student student = studentDao.getStudentBySID(sid);
            if (student == null) return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // else
        return true;
    }

    /**
     * 获取所有学生服务
     */
    public List<Student> getAllStudents() {
        try {
            return studentDao.getAllStudents();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 添加学生服务
     */
    public boolean addStudent(Student student) {
        try {
            return studentDao.addStudent(student) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 删除学生服务
     */
    public boolean removeStudentBySID(String sid) {
        try {
            if (!this.checkIfSIDExists(sid)) return false; // not exist
            return studentDao.removeStudentBySID(sid) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 更新学生服务
     */
    public boolean updateStudentBySID(Student student) {
        try {
            if (!this.checkIfSIDExists(student.getSid())) return false; // not exist
            return studentDao.updateStudentBySID(student) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
