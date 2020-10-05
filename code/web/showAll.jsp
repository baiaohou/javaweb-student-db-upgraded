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
    <title>展示所有学生信息</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h3>以下为所有学生信息：</h3>

    <%
        // charset utf-8
        request.setCharacterEncoding("utf-8");
        // initialize StudentService instance and add student
        StudentService ss = new StudentService();
        List<Student> allStudents = ss.getAllStudents();

        if (allStudents != null) {
            out.println("<table>");
            Student tableHead = new Student("姓名", "性别", "出生日期", "电子邮箱", "备注", "班级");
            tableHead.setSid("学号");
            out.println(tableHead.toStringRowBold());
            for (Student student : allStudents) {
                out.println(student.toStringRow());
            }
            out.println("</table>");

        } else {
            System.out.println("数据库无信息！");
            out.println("<span style='color: red'>数据库无信息！<span/>");
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
