package com.lagou.test;

import com.lagou.bean.User;
import com.lagou.dao.UserDao;
import com.lagou.factory.UserDaoFactory;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author baiaohou
 * @create 2020-08-31 8:30 PM
 */
public class UserDaoTest {

    @Test
    public void testUserLogin() throws SQLException {
        UserDao userDao = UserDaoFactory.getUserDao();
        User user = userDao.userLogin(new User("admin", "123456"));
        if (user == null) {
            System.out.println("未找到用户！");
        } else {
            System.out.println("找到的数据：" + user);
        }
    }

}
