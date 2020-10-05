<%@ page import="com.lagou.bean.Student" %>
<%@ page import="com.lagou.service.StudentService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lagou.bean.SchoolClass" %>
<%@ page import="com.lagou.service.SchoolClassService" %><%--
  Created by IntelliJ IDEA.
  User: baiaohou
  Date: 9/1/20
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加班级</title>
</head>
<body>
    <h3>需要添加的班级信息：</h3>

    <%
        // charset utf-8
        request.setCharacterEncoding("utf-8");
    %>

    <ul>
        <li><p><b>班名：</b>
            ${param.cname}
<%--            <%= request.getParameter("sname")%>--%>
        </p></li>
        <li><p><b>年级：</b>
            ${param.grade}
<%--            <%= request.getParameter("sex")%>--%>
        </p></li>
        <li><p><b>老师：</b>
            ${param.teacher}
<%--            <%= request.getParameter("birthday")%>--%>
        </p></li>
        <li><p><b>口号：</b>
            ${param.slogan}
<%--            <%= request.getParameter("email")%>--%>
        </p></li>
    </ul>


    <%



        SchoolClass newClass = new SchoolClass();
        newClass.setCname(request.getParameter("cname"));
        newClass.setGrade(request.getParameter("grade"));
        newClass.setTeacher(request.getParameter("teacher"));
        newClass.setSlogan(request.getParameter("slogan"));
        request.setAttribute("newClass", newClass);
        System.out.println("浏览器请求添加班级：" + newClass);



        // initialize StudentService instance and add student
        SchoolClassService ss = new SchoolClassService();
        boolean bool = ss.addClass(newClass);
        if (bool) {
            System.out.println("添加班级成功！");
            out.println("<span style='color: red'>添加班级成功！<span/>");
        } else {
            System.out.println("添加班级失败！");
            out.println("<span style='color: red'>添加班级失败！<span/>");
        }
//        List<Student> allStudents = ss.getAllStudents();
//        for (Student s : allStudents) {
//            System.out.println(s);
//            out.println("<p>" + s + "<p/>");
//        }
    %>


    <br>
<%--    <a href="/javaweb_project/insert">确认插入</a> <br>--%>
    <a href="/javaweb_project/main.jsp">返回主菜单</a>

</body>
</html>
