<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/20
  Time: 11:27 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login Page</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    <p><input type="submit" value="Login" style="width: 60px;height: 30px;font-size: 15px"></p>
</form>
</body>
</html>
