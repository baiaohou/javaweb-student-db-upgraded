package com.lagou.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author baiaohou
 * @create 2020-09-15 3:48 PM
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 实现对用户访问主页面的过滤操作，也就是只有用户登录后才能访问该页面，否则一律拦截
        // 判断session中是否已有用户名信息。若有：则放行；若没有，则进行拦截
        // 强转
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object userName = session.getAttribute("user");
        // 获取Servlet的请求路径
        String servletPath = httpServletRequest.getServletPath();
        if (null == userName && !servletPath.contains("login")) {
            // 若没有登录，则回到登录界面
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
        } else {
            // 若用户登录，则放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
