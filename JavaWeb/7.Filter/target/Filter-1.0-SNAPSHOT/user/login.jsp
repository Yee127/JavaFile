<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/2/23
  Time: 12:02 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="http://localhost:8888/7_Filter/loginServlet" method="post">
    <table>
        <tr>
            <td>
                Username:
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>
                Password:
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Sbumint">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
