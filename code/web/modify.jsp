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
    <title>修改学生</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>


    <%
        // charset utf-8
        request.setCharacterEncoding("utf-8");
    %>

    <ul>
        <h3>修改添加的学号为：</h3>
        <li><p><b>学号：</b>
            ${param.sid}
<%--            <%= request.getParameter("sid")%>--%>
        </p></li>
        <h3>被修改学生后的新信息为：</h3>
        <li><p><b>姓名：</b>
            ${param.sname}
<%--            <%= request.getParameter("sname")%>--%>
        </p></li>
        <li><p><b>性别：</b>
            ${param.sex}
<%--            <%= request.getParameter("sex")%>--%>
        </p></li>
        <li><p><b>生日：</b>
            ${param.birthday}
<%--            <%= request.getParameter("birthday")%>--%>
        </p></li>
        <li><p><b>邮箱：</b>
            ${param.email}
<%--            <%= request.getParameter("email")%>--%>
        </p></li>
        <li><p><b>备注：</b>
            ${param.note}
<%--            <%= request.getParameter("note")%>--%>
        </p></li>
        <li><p><b>班级：</b>
            ${param.class_name}
            <%--            <%= request.getParameter("note")%>--%>
        </p></li>
    </ul>


    <%
        Student student = new Student();
        student.setSname(request.getParameter("sname"));
        student.setSex(request.getParameter("sex"));
        student.setBirthday(request.getParameter("birthday"));
        student.setEmail(request.getParameter("email"));
        student.setNote(request.getParameter("note"));
        student.setClass_name(request.getParameter("class_name"));

        String sid = request.getParameter("sid");
        student.setSid(sid);
        request.setAttribute("student", student);
        System.out.println("浏览器请求修改学生：" + student);

        // initialize StudentService instance and add student
        StudentService ss = new StudentService();
        boolean bool = ss.updateStudentBySID(student);
        if (bool) {
            System.out.println("修改学生成功！");
            out.println("<span style='color: red'>修改成功！以下为更新后的学生信息：<span/>");
            out.println("<br>");
            out.println("<table>");
            Student tableHead = new Student("姓名", "性别", "出生日期", "电子邮箱", "备注", "班级");
            tableHead.setSid("学号");
            out.println(tableHead.toStringRowBold());
            out.println(student.toStringRow());
            out.println("</table>");
        } else {
            System.out.println("修改学生失败！");
            out.println("<span style='color: red'>修改学生失败！未找到学号为 "
                    + sid + " 的学生。<span/>");
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
