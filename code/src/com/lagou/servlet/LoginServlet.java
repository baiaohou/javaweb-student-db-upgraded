package com.lagou.servlet;

import com.lagou.bean.User;
import com.lagou.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author baiaohou
 * @create 2020-08-31 3:29 PM
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求中的用户名和密码信息并打印出来
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("获取到的用户名：" + userName);
        System.out.println("获取到的密码为：" + password);

        // 2 创建UserService类型对象去实现数据校验
        // 实例化UserService类对象
        UserService userService = new UserService();
        // 数据校验，若返回结果为null则未找到，登录失败
        User user = null;
        try {
            user = userService.userLoginService(new User(userName, password));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (null == user) { // if return User is null, means not found, login failed
            System.out.println("登录失败，用户名或密码错误！");
            request.setAttribute("error", "登录失败，用户名或密码错误！");
            // 实现服务器跳转 共享request和response对象
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            System.out.println("登陆成功，欢迎使用！");
            // 将登陆成功的用户信息放入session对象中实现多个请求的共享
            // 为了管理页面显示：欢迎您，xxx!
            request.getSession().setAttribute("user", user);

            /**
             *  新特性：添加cookie免登陆一周
             */
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(7 * 24 * 60 * 60); // one week
            response.addCookie(userCookie);

            // 实现客户端跳转 -> main.jsp
            response.sendRedirect("main.jsp");


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
