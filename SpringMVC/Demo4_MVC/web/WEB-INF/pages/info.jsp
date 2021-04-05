<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/16
  Time: 4:37 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Info</title>
</head>
<style>
    table{
        font-size: 20px;
        text-align: center;
        margin: auto;
    }
    h2{
        text-align: center;
    }
</style>
<body>
<div>
    <h2>Employee Info</h2>
    <table cellspacing="0"; border="1";>
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:if test="${empty requestScope.employees}">
            <tr>
                没有任何员工信息！
            </tr>
        </c:if>
        <c:if test="${!empty requestScope.employees}" >
            <c:forEach items="${requestScope.employees}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName }</td>
                    <td>${emp.email }</td>
                    <td>${emp.gender == 0 ? 'Female' : 'Male' }</td>
                    <td>${emp.department.departmentName }</td>
                    <td><a href="emp/${emp.id}">Edit</a></td>
                    <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <tr>
            <td colspan="7">
                Go to <a href="/MVC/sub">submit.jsp</a>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
