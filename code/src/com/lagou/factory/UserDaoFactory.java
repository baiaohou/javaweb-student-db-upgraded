package com.lagou.factory;

import com.lagou.dao.UserDao;
import com.lagou.dao.imp.UserDaoImp;

/**
 * @author baiaohou
 * @create 2020-08-31 3:44 PM
 */
public class UserDaoFactory {

    /**
     * 通过静态工厂方法模式来实现UserDao实现类对象的创建并返回
     * @return UserDao接口实现对象
     */
    public static UserDao getUserDao() {
        return new UserDaoImp();
    }
}
