package com.lagou.test;

import com.lagou.bean.User;
import com.lagou.dao.UserDao;
import com.lagou.dao.imp.UserDaoImp;
import com.lagou.service.UserService;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author baiaohou
 * @create 2020-08-31 3:46 PM
 */
public class UserServiceTest {
    @Test
    public void test() throws SQLException {
        UserDao userDao = new UserDaoImp();
        UserService userService = new UserService();
        User admin = userService.userLoginService(new User("admin", "123456"));
        System.out.println("找到的数据：" + admin);
    }
}
