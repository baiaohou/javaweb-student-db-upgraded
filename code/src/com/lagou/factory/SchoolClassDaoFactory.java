package com.lagou.factory;

import com.lagou.dao.SchoolClassDao;
import com.lagou.dao.StudentDao;
import com.lagou.dao.imp.SchoolClassDaoImp;
import com.lagou.dao.imp.StudentDaoImp;

/**
 * @author baiaohou
 * @create 2020-08-31 3:44 PM
 */
public class SchoolClassDaoFactory {

    /**
     * 通过静态工厂方法模式来实现SchoolClassDao实现类对象的创建并返回
     * @return SchoolClass接口实现对象
     */
    public static SchoolClassDao getSchoolClassDao() {
        return new SchoolClassDaoImp();
    }
}
