<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/20
  Time: 3:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><spring:message code="txt.page"/> </title>
    <style>
        div{
            width: 1000px;
            height: 220px;
            margin:0 auto;
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h2><spring:message code="txt.page"/> </h2>
    <a href="${pageContext.request.contextPath}/i18n/zn_CN">中文</a>丨
    <a href="${pageContext.request.contextPath}/i18n/en_US">English</a>
    <form:form action="${pageContext.request.contextPath}/i18n" method="post" modelAttribute="user">
        <span style="color: red">${errorMsg}</span>
        <p>  <spring:message code="txt.username"/>:
            <input type="text" name="username" >
          <form:errors path="username" cssStyle="color:red"></form:errors>
        </p>
        <p>
            <spring:message code="txt.password"/> ：
            <input type="password" name="password" >
             <form:errors path="password" cssStyle="color:red"></form:errors>
        </p>
        <input type="submit" value="<spring:message code="txt.login"/> " style="width: 60px;height: 30px;font-size: 15px">
    </form:form>
</div>
</body>
</html>
