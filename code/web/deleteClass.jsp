<%@ page import="com.lagou.bean.Student" %>
<%@ page import="com.lagou.service.StudentService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lagou.service.SchoolClassService" %>
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
    <title>删除班级</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h3>需要删除的班级信息：</h3>

    <%
        // charset utf-8
        request.setCharacterEncoding("utf-8");
    %>

    <ul>
        <li><p><b>您输入的班级的班名为：${param.cname}</b>
<%--            <%= request.getParameter("sid")%>--%>
        </p></li>
    </ul>


    <%


        String cname = request.getParameter("cname");
        request.setAttribute("cname", cname);
        System.out.println("浏览器请求删除班级：" + cname);

        // initialize StudentService instance and add student
        SchoolClassService ss = new SchoolClassService();
        boolean bool = ss.removeClassBySID(cname);
        if (bool) {
            System.out.println("删除成功！该班级已移除数据库！");
            out.println("<span style='color: red'>删除成功！该班级已移除数据库！<span/>");
        } else {
            System.out.println("删除失败！未找到班名为 " + cname + " 的学生，或该班级内仍有学生！");
            out.println("<span style='color: red'>删除失败！未找到班名为 " + cname + " 的学生，或该班级内仍有学生！<span/>");
        }
    %>



    <br>
<%--    <a href="/javaweb_project/insert">确认插入</a> <br>--%>
    <a href="/javaweb_project/main.jsp">返回主菜单</a>

</body>
</html>
