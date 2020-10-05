package com.lagou.dao.imp;

import com.lagou.bean.SchoolClass;
import com.lagou.bean.Student;
import com.lagou.dao.SchoolClassDao;
import com.lagou.dao.StudentDao;
import com.lagou.factory.SchoolClassDaoFactory;
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
public class SchoolClassDaoImp implements SchoolClassDao {

    /**
     * 获得所有班级
     */
    @Override
    public List<SchoolClass> getAllSchoolClasses() throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "select * from t_class";
        // 3 查询操作，返回结果
        return queryRunner.query(sql, new BeanListHandler<SchoolClass>(SchoolClass.class));
    }

    /**
     * 根据班级名称查询班级
     */
    @Override
    public SchoolClass getSchoolClassByCname(String cname) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "select * from t_class where cname = ?";
        // 3 查询操作，返回结果
        return queryRunner.query(sql, new BeanHandler<SchoolClass>(SchoolClass.class), cname);
    }

    /**
     * 创建班级
     */
    @Override
    public int addSchoolClass(SchoolClass schoolClass) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "insert into t_class values(?, ?, ?, ?, ?)";
        // 3 插入操作，返回受影响行
        Object[] param = {schoolClass.getCname(), schoolClass.getGrade(), schoolClass.getTeacher(),
                            schoolClass.getSlogan(), 0}; // new class with 0 students
        return queryRunner.update(sql, param);
    }

    /**
     * 根据班级名称来删除班级
     */
    @Override
    public int removeSchoolClassByCname(String cname) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        // 2 准备sql语句
        String sql0 = "select * from t_class where cname = ?";
        // 3 查询操作，返回结果
        SchoolClass schoolClass = queryRunner.query(sql0, new BeanHandler<SchoolClass>(SchoolClass.class), cname);

        if (!schoolClass.getPeople_count().equals("0")) {
            System.out.println(schoolClass.getCname() + " 班中有学生，不能删除！");
            return -1;
        }

        // 2 准备sql语句
        String sql = "delete from t_class where cname = ?";
        // 3 删除操作，返回受影响行
        return queryRunner.update(sql, cname);
    }

    /**
     * 根据班级名称来更新班级
     */
    @Override
    public int updateSchoolClassByCname(SchoolClass schoolClass) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "update t_class " +
                      "set grade = ?, " +
                            "teacher = ?, " +
                            "slogan = ? " +
                            "where cname = ?";
        // 3 更新操作，返回受影响行
        Object[] param = { schoolClass.getGrade(), schoolClass.getTeacher(), schoolClass.getSlogan(),
                            schoolClass.getCname()};
        return queryRunner.update(sql, param);
    }

    public static void main(String[] args) throws SQLException {
//        SchoolClass schoolClass = new SchoolClass("1.1", "1", "123", "12345");
//        SchoolClassDaoFactory.getSchoolClassDao().addSchoolClass(schoolClass);
//        System.out.println(SchoolClassDaoFactory.getSchoolClassDao().getSchoolClassByCname("1.1"));


    }
}
