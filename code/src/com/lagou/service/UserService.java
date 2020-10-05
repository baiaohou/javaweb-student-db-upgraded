package com.lagou.service;

import com.lagou.bean.User;
import com.lagou.dao.UserDao;
import com.lagou.factory.UserDaoFactory;

import java.sql.SQLException;

/**
 * @author baiaohou
 * @create 2020-08-31 3:43 PM
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = UserDaoFactory.getUserDao();
    }

    /**
     * 自定义成员方法实现根据参数指定的User对象来调用dao层 实现登录功能
     * @param user: 用于登录的User信息
     * @return
     */
    public User userLoginService(User user) throws SQLException {
        return userDao.userLogin(user);
    }
}
