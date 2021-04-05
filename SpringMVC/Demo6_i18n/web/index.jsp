<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/19
  Time: 8:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Index</title>
</head>
<style>
  li{
    font-size: 20px;
  }
</style>
<body>
<h1>Go to：</h1>
<ul>
  <li><a href="${pageContext.request.contextPath}/success">Success</a></li>
  <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
  <li><a href="${pageContext.request.contextPath}/exception">Exception</a></li>
</ul>
</body>
</html>
