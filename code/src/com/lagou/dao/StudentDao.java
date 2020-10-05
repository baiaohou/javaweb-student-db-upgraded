package com.lagou.dao;

import com.lagou.bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author baiaohou
 * @create 2020-08-31 8:34 PM
 */
public interface StudentDao {

    /**
     * 获得所有学生
     * @return A list of all students
     */
    public abstract List<Student> getAllStudents() throws SQLException;

    /**
     * 根据学号查询学生
     * @param sid to be searched
     * @return Student to be searched
     */
    public abstract Student getStudentBySID(String sid) throws SQLException;

    /**
     * 添加学生
     * @param student to be added
     * @return Affected Row Number
     */
    public abstract int addStudent(Student student) throws SQLException;

    /**
     * 根据学生学号（sid）来删除学生
     * @param sid to me removed
     * @return Affected Row Number
     */
    public abstract int removeStudentBySID(String sid) throws SQLException;

    /**
     * 根据学生学号（sid）来更新学生
     * @param student to be replaced
     * @return Affected Row Number
     * @throws SQLException
     */
    public abstract int updateStudentBySID(Student student) throws SQLException;
}
