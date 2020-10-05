package com.lagou.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.lagou.bean.SchoolClass;
import com.lagou.bean.Student;
import com.lagou.dao.SchoolClassDao;
import com.lagou.dao.StudentDao;
import com.lagou.factory.SchoolClassDaoFactory;
import com.lagou.factory.StudentDaoFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author baiaohou
 * @create 2020-08-31 3:43 PM
 */
public class SchoolClassService {

    /**
     * 学生数据库访问层对象
     */
    private SchoolClassDao schoolClassDao;

    public SchoolClassService() {
        this.schoolClassDao = SchoolClassDaoFactory.getSchoolClassDao();
    }

    public SchoolClass getSchoolClassBySID(String cname) {
        if (checkIfCnameExists(cname)) {
            try {
                return schoolClassDao.getSchoolClassByCname(cname);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        SchoolClass s = new SchoolClass("1.1", "1111", "2222", "3333");
//        new SchoolClassService().updateClassBySID(s);

//        new SchoolClassService().removeClassBySID("111");

//        List<SchoolClass> allClasses = new SchoolClassService().getAllClasses();
//        for (SchoolClass c : allClasses) {
//            System.out.println(c);
//        }

    }
    /**
     * 检查给定sid学号是否存在于数据库中
     */
    public boolean checkIfCnameExists(String cname) {
        try {
            SchoolClass schoolClass = schoolClassDao.getSchoolClassByCname(cname);
            if (schoolClass == null) return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // else
        return true;
    }

    /**
     * 获取所有学生服务
     */
    public List<SchoolClass> getAllClasses() {
        try {
            return schoolClassDao.getAllSchoolClasses();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 添加学生服务
     */
    public boolean addClass(SchoolClass schoolClass) {
        try {
            return schoolClassDao.addSchoolClass(schoolClass) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 删除学生服务
     */
    public boolean removeClassBySID(String cname) {
        try {
            if (!this.checkIfCnameExists(cname)) return false; // not exist
            return schoolClassDao.removeSchoolClassByCname(cname) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 更新学生服务
     */
    public boolean updateClassBySID(SchoolClass schoolClass) {
        try {
            if (!this.checkIfCnameExists(schoolClass.getCname())) return false; // not exist
            return schoolClassDao.updateSchoolClassByCname(schoolClass) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
