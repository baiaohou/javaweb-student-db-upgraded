package com.lagou.factory;

import com.lagou.dao.StudentDao;
import com.lagou.dao.UserDao;
import com.lagou.dao.imp.StudentDaoImp;
import com.lagou.dao.imp.UserDaoImp;

/**
 * @author baiaohou
 * @create 2020-08-31 3:44 PM
 */
public class StudentDaoFactory {

    /**
     * 通过静态工厂方法模式来实现StudentDao实现类对象的创建并返回
     * @return StudentDao接口实现对象
     */
    public static StudentDao getStudentDao() {
        return new StudentDaoImp();
    }
}
