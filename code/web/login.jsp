<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生信息管理系统</title>
</head>
<body>
<form action="login" method="post">
    <h4>欢迎使用学生信息管理系统！</h4>
    用户名：<input type="text" name="userName"/> <br>
    密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"/> <br>
    <span style="color: #ff0000"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error")%></span> <br>
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>