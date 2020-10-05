package com.lagou.dao;

import com.lagou.bean.SchoolClass;
import com.lagou.bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author baiaohou
 * @create 2020-08-31 8:34 PM
 */
public interface SchoolClassDao {

    /**
     * 获得所有班级
     */
    public abstract List<SchoolClass> getAllSchoolClasses() throws SQLException;

    /**
     * 根据班级名称查询班级
     */
    public abstract SchoolClass getSchoolClassByCname(String cname) throws SQLException;

    /**
     * 创建班级
     */
    public abstract int addSchoolClass(SchoolClass schoolClass) throws SQLException;

    /**
     * 根据班级名称来删除班级
     */
    public abstract int removeSchoolClassByCname(String cname) throws SQLException;

    /**
     * 根据班级名称来更新班级
     */
    public abstract int updateSchoolClassByCname(SchoolClass schoolClass) throws SQLException;
}
