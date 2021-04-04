<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/2/20
  Time: 10:32 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>-- login --</title>
</head>
<body>
<form action="http://localhost:8080/6_CookieAndSession/loginServlet" method="get">
    User:<input type="text" name="username" value="${cookie.username.value}"><br>
    Password:<input type="password" name="password" value="${cookie.password.value}"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
