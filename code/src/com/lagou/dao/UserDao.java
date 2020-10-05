package com.lagou.dao;

import com.lagou.bean.User;

import java.sql.SQLException;

/**
 * @author baiaohou
 * @create 2020-08-31 3:33 PM
 */
public interface UserDao {
    /**
     * 自定义抽象方法描述登录功能的实现
     */
    public abstract User userLogin(User user) throws SQLException;
}
