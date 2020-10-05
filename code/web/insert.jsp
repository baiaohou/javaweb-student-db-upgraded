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
    <title>增加学生</title>
</head>
<body>
    <h3>需要添加的学生信息：</h3>

    <%
        // charset utf-8
        request.setCharacterEncoding("utf-8");
    %>

    <ul>
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
        request.setAttribute("student", student);
        System.out.println("浏览器请求添加学生：" + student);



        // initialize StudentService instance and add student
        StudentService ss = new StudentService();
        boolean bool = ss.addStudent(student);
        if (bool) {
            System.out.println("添加学生成功！");
            out.println("<span style='color: red'>添加学生成功！<span/>");
        } else {
            System.out.println("添加学生失败！");
            out.println("<span style='color: red'>添加学生失败！<span/>");
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
