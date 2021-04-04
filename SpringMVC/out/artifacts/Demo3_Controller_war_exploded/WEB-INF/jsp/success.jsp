<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/10
  Time: 9:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    h1{
        text-align: center;
    }
    td{
        font-size: 15px;
        font-family: "微软雅黑";
    }
</style>
<body>
<h1> >>>>>>>>>>>> SUCCESS <<<<<<<<<<<<<</h1>
<hr>
<table>
    <tr>
        <td>Username = </td>
        <td>${user}</td>
    </tr>
    <tr>
        <td> User-Agent =</td>
        <td>${Agent}</td>
    </tr>
    <tr>
        <td>JSESSIONID =</td>
        <td>${id}</td>
    </tr>
</table>
<hr>
<h2>${user}</h2>
<hr>

</body>
</html>
