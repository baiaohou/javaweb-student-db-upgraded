package com.lagou.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author baiaohou
 * @create 2020-08-31 10:46 PM
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/index.jsp")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get user login info from session
        Object user = request.getSession().getAttribute("user");

        // if user == null, then not login yet, direct to login.jsp
        if (user == null) {
            System.out.println("未登录，跳转到login.jsp页面...");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            // 重定向到main.jsp
            System.out.println("已登录，重定向到main.jsp");
            response.sendRedirect("main.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
