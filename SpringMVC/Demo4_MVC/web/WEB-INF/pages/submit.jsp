<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<form:form action="emp" method="post" modelAttribute="employee">
    <jsp:useBean id="employee" class="com.mvc.pojo.Employee" scope="request"/>
    <table>
        <tr>
            <td>LastName:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <%
            Map<String, Object> genders = new HashMap<String, Object>();
            genders.put("1","Male");
            genders.put("0","Female");

            request.setAttribute("genders",genders);
        %>
        <tr>
            <td>Gender:</td>
            <td><form:radiobutton path="gender" items="${genders}"/> ${genders}</td>
        </tr>
        <tr>
            <td>Department:</td>
            <td>
                <form:select path="department" items="${departments}" itemLabel="departmentName" itemValue="id"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
<hr>
${pageContext.request.contextPath }
</body>
</html>