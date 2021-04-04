<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/10
  Time: 9:28 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>successful!</h1>
<h1>!!!!!!!!!!</h1>

  <form action="http://localhost:8080/Demo3/MA" method="post">
    <input type="hidden" name="id" value="1">
    <table>
      <tr>
        <td>username:</td>
        <td><input type="text" name="username" value="tom"></td>
      </tr>
      <tr>
        <td>Age:</td>
        <td><input type="text" name="age" value="10"></td>
      </tr>
      <tr>
        <td>
          <input type="submit" value="修改">
        </td>
      </tr>
    </table>
  </form>
  <hr>

  <a href="http://localhost:8080/Demo3/RRC?username=Yee">RRC</a>
  </body>
</html>
