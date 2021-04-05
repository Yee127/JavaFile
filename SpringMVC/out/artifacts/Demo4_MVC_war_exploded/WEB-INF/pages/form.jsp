<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/17
  Time: 3:24 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>From Test</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/showUser" method="post" modelAttribute="user">
<%--    <jsp:useBean id="employee" class="com.mvc.pojo.Employee" scope="request"/>--%>
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td><form:radiobutton path="gender" value="male"/>male
                <form:radiobutton path="gender" value="female"/>female
            </td>
        </tr>
<%--        <tr>--%>
<%--            <td>Birthday:</td>--%>
<%--            <td><form:input path="birth"/></td>--%>
<%--            <td><form:errors path="birth"/></td>--%>
<%--        </tr>--%>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
            <td><form:errors/></td>
        </tr>
        <tr>
            <td>Salary:</td>
            <td><form:input path="salary"/></td>
        </tr>
        <tr>
            <td>Hobby:</td>
            <td>
                <form:checkbox path="hobbies" value="Java"/>Java
                <form:checkbox path="hobbies" value="PHP"/>PHP
                <form:checkbox path="hobbies" value="Python"/>Python
                <form:checkbox path="hobbies" value="C++"/>C++
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
