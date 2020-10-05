package com.lagou.dao.imp;

import com.lagou.bean.Student;
import com.lagou.bean.User;
import com.lagou.dao.StudentDao;
import com.lagou.factory.StudentDaoFactory;
import com.lagou.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author baiaohou
 * @create 2020-08-31 8:46 PM
 */
public class StudentDaoImp implements StudentDao {

    /**
     * 获得所有学生
     * @return A list of all students
     */
    @Override
    public List<Student> getAllStudents() throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "select * from t_student";
        // 3 查询操作，返回结果
        return queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
    }

    /**
     * 根据学号查询学生
     * @param sid to be searched
     * @return Student to be searched
     */
    @Override
    public Student getStudentBySID(String sid) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "select * from t_student where sid = ?";
        // 3 查询操作，返回结果
        return queryRunner.query(sql, new BeanHandler<Student>(Student.class), sid);
    }

    /**
     * 添加学生
     * @param student to be added
     * @return Affected Row Number
     */
    @Override
    public int addStudent(Student student) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql1 = "insert into t_student values(?, ?, ?, ?, ?, ?, ?);";

        // 3 插入操作，返回受影响行
        Object[] param1 = {student.getSid(), student.getSname(), student.getSex(),
                        student.getBirthday(), student.getEmail(), student.getNote(), student.getClass_name()};
        int ret = queryRunner.update(sql1, param1);
        
        String sql2 = "update t_class set people_count = (select count(*) from t_student where class_name = ?) where cname = ?;";
        Object[] param2 = {student.getClass_name(), student.getClass_name()};
        queryRunner.update(sql2, param2);
        return ret;
    }

    public static void main(String[] args) throws SQLException {
//        Student s = new Student("Sam", "男", "1999-09-09", "sam@123.com", "my name is sam", "三年一班");
//        StudentDaoFactory.getStudentDao().addStudent(s);

//        StudentDaoFactory.getStudentDao().removeStudentBySID("14");

//        Student s = new Student("Sammm", "女", "1999-09-09", "sam@123.com", "my name is sam", "二年一班");
//        s.setSid("15");
//        StudentDaoFactory.getStudentDao().updateStudentBySID(s);

//        Student s = new Student("Sam", "男", "1999-09-09", "sam@123.com", "my name is sam", "三年一班");
//        s.setSid("15");
//        StudentDaoFactory.getStudentDao().updateStudentBySID(s);

    }

    /**
     * 根据学生学号（sid）来删除学生
     * @param sid to me removed
     * @return Affected Row Number
     */
    @Override
    public int removeStudentBySID(String sid) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "delete from t_student where sid = ?";


        String sql2 = "update t_class set people_count = (select count(*) - 1 from t_student where class_name = (select class_name from t_student where sid = ?)) where cname = (select class_name from t_student where sid = ?);";
        Object[] param2 = {sid, sid};
        queryRunner.update(sql2, param2);

        // 3 删除操作，返回受影响行
        int ret = queryRunner.update(sql, sid);
        return ret;
    }

    /**
     * 根据学生学号（sid）来更新学生
     * @param student to be replaced
     * @return Affected Row Number
     * @throws SQLException
     */
    @Override
    public int updateStudentBySID(Student student) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        // 2 准备sql语句
        String sql0 = "select * from t_student where sid = ?";
        // 3 查询操作，返回结果
        Student s = queryRunner.query(sql0, new BeanHandler<Student>(Student.class), student.getSid());
        String cname1 = s.getClass_name();
        String cname2 = student.getClass_name();
        if (!cname1.equals(cname2)) {
            // change class
            System.out.println("This student is changing class from " + s.getClass_name() + " to " + student.getClass_name());

            String sql2 = "update t_class set people_count = (select count(*) - 1 from t_student where class_name = (select class_name from t_student where sid = ?)) where cname = (select class_name from t_student where sid = ?);";
            Object[] param2 = {s.getSid(), s.getSid()};
            queryRunner.update(sql2, param2);

            String sql3 = "update t_class set people_count = (select count(*) + 1 from t_student where class_name = ?) where cname = ?;";
            Object[] param3 = {student.getClass_name(), student.getClass_name()};
            queryRunner.update(sql3, param3);
        }


        // 2 准备sql语句
        String sql = "update t_student " +
                      "set sname = ?, " +
                            "sex = ?, " +
                            "birthday = ?, " +
                            "email = ?, " +
                            "note = ? ," +
                            "class_name = ? " +
                            "where sid = ?";
        // 3 更新操作，返回受影响行
        Object[] param = { student.getSname(), student.getSex(),
                student.getBirthday(), student.getEmail(), student.getNote(), student.getClass_name(),
                student.getSid()};
        return queryRunner.update(sql, param);
    }
}
