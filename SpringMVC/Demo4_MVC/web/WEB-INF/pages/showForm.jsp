<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/17
  Time: 4:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowForm</title>
</head>
<body>
<table>
    <tr>
        <td>Name:</td>
        <td>${user.name}</td>
    </tr>
    <tr>
        <td>Gender:</td>
        <td>${user.gender}</td>
    </tr>
    <tr>
        <td>Birthday:</td>
        <td></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Salary:</td>
        <td>${user.salary}</td>
    </tr>
    <tr>
        <td>Hobby:</td>
        <td>
            ${user.hobbies}
        </td>
    </tr>
    <tr>
        <td> <a href="/MVC/user">返回🔙</a></td>
    </tr>
</table>
</body>
</html>
