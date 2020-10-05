<%@ page import="com.lagou.bean.Student" %>
<%@ page import="com.lagou.service.StudentService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: baiaohou
  Date: 9/1/20
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>删除学生</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h3>需要删除的学生信息：</h3>

    <%
        // charset utf-8
        request.setCharacterEncoding("utf-8");
    %>

    <ul>
        <li><p><b>您输入的学生学号为：${param.sid}</b>
<%--            <%= request.getParameter("sid")%>--%>
        </p></li>
    </ul>


    <%


        String sid = request.getParameter("sid");
        request.setAttribute("sid", sid);
        System.out.println("浏览器请求添加学生：" + sid);

        // initialize StudentService instance and add student
        StudentService ss = new StudentService();
        boolean bool = ss.removeStudentBySID(sid);
        if (bool) {
            System.out.println("删除成功！该学生已移除数据库！");
            out.println("<span style='color: red'>删除成功！该学生已移除数据库！<span/>");
        } else {
            System.out.println("删除失败！未找到学号为 " + sid + " 的学生！");
            out.println("<span style='color: red'>删除失败！未找到学号为 " + sid + " 的学生！<span/>");
        }
    %>



    <br>
<%--    <a href="/javaweb_project/insert">确认插入</a> <br>--%>
    <a href="/javaweb_project/main.jsp">返回主菜单</a>

</body>
</html>
