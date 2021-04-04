<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/30
  Time: 10:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show All</title>
</head>
<body>
<%--    private Integer id;
    private String name;
    private String password;
    private String address;
    private String phone;
    --%>
<table>
<c:forEach items="${list}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>${user.address}</td>
        <td>${user.phone}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
