<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/2/16
  Time: 4:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/5_EL_JSTL/uploadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username" /> <br>
    头像：<input type="file" name="photo" > <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
