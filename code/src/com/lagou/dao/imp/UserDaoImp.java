package com.lagou.dao.imp;

import com.lagou.bean.User;
import com.lagou.dao.UserDao;
import com.lagou.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author baiaohou
 * @create 2020-08-31 3:36 PM
 */
public class UserDaoImp implements UserDao {

    @Override
    public User userLogin(User user) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "select * from t_user where userName = ? and password = ?";
        // 3 查询操作，返回结果
        Object[] param = {user.getUserName(), user.getPassword()};
        return queryRunner.query(sql, new BeanHandler<User>(User.class), param);
    }

}
