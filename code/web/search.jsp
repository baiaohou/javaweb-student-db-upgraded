<%@ page import="com.lagou.bean.Student" %>
<%@ page import="com.lagou.service.StudentService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: baiaohou
  Date: 9/1/20
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询学生</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h3>需要查询的学生信息：</h3>

    <%
        // charset utf-8
        request.setCharacterEncoding("utf-8");
    %>

    <ul>
        <li><p><b>您输入的学生学号为：</b>
            ${param.sid}
<%--            <%= request.getParameter("sid")%>--%>
        </p></li>
    </ul>


    <%


        String sid = request.getParameter("sid");
        request.setAttribute("sid", sid);
        System.out.println("浏览器请求添加学生：" + sid);

        // initialize StudentService instance and add student
        StudentService ss = new StudentService();
        Student student = ss.getStudentBySID(sid);
        if (student != null) {
            System.out.println("查询成功！以下为查询到的学生信息：");
            System.out.println(student);
            out.println("<span style='color: red'>查询成功！以下为查询到的学生信息：<span/>");
            out.println("<br>");
            out.println("<table>");
            Student tableHead = new Student("姓名", "性别", "出生日期", "电子邮箱", "备注", "班级");
            tableHead.setSid("学号");
            out.println(tableHead.toStringRowBold());
            out.println(student.toStringRow());
            out.println("</table>");

        } else {
            System.out.println("无查询结果！");
            out.println("<span style='color: red'>无查询结果！<span/>");
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
