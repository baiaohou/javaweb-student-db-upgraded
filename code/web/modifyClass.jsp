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
    <title>修改班级</title>
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
        <h3>修改添加的班级为：</h3>
        <li><p><b>班名：</b>
            ${param.cname}
<%--            <%= request.getParameter("sid")%>--%>
        </p></li>
        <h3>被修改班级后的新信息为：</h3>
        <li><p><b>年级：</b>
            ${param.grade}
<%--            <%= request.getParameter("sname")%>--%>
        </p></li>
        <li><p><b>老师：</b>
            ${param.teacher}
<%--            <%= request.getParameter("sex")%>--%>
        </p></li>
        <li><p><b>口号：</b>
            ${param.slogan}
<%--            <%= request.getParameter("birthday")%>--%>
        </p></li>
    </ul>


    <%
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setGrade(request.getParameter("grade"));
        schoolClass.setTeacher(request.getParameter("teacher"));
        schoolClass.setSlogan(request.getParameter("slogan"));

        String cname = request.getParameter("cname");
        schoolClass.setCname(cname);
        request.setAttribute("schoolClass", schoolClass);
        System.out.println("浏览器请求修改班级：" + schoolClass);

        // initialize StudentService instance and add student
        SchoolClassService ss = new SchoolClassService();
        boolean bool = ss.updateClassBySID(schoolClass);
        if (bool) {
            SchoolClass temp = ss.getSchoolClassBySID(cname); // <---

            System.out.println("修改班级成功！");
            out.println("<span style='color: red'>修改成功！以下为更新后的班级信息：<span/>");
            out.println("<br>");
            out.println("<table>");
            SchoolClass tableHead = new SchoolClass("班名", "年级", "老师", "口号");
            tableHead.setPeople_count("人数");

            schoolClass.setPeople_count(temp.getPeople_count());  // <---

            out.println(tableHead.toStringRowBold());
            out.println(schoolClass.toStringRow());
            out.println("</table>");
        } else {
            System.out.println("修改班级失败！");
            out.println("<span style='color: red'>修改班级失败！未找到班名为 "
                    + cname + " 的班级。<span/>");
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
