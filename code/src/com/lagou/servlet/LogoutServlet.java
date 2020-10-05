package com.lagou.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author baiaohou
 * @create 2020-09-20 11:30 PM
 */
@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 清楚登录的数据
        System.out.println("现在删除登录信息，跳转至login.jsp");
        // 从session中删除
        request.getSession().removeAttribute("user");
        // 从cookie中删除
        Cookie userCookie = new Cookie("user", null);
        userCookie.setMaxAge(0); // expire immediately
        response.addCookie(userCookie);

        // redirect to login.jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
