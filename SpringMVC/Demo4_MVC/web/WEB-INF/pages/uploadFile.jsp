<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/3/19
  Time: 9:05 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<p>单文件上传：</p>
<form action="${pageContext.request.contextPath}/upload" method="post"
      enctype="multipart/form-data">
    Select File:<input type="file" name="myfile"><br>
    Descripton:<input type="text" name="d"><br>
    <input type="submit" value="Submit">
</form>
<hr>
<p>多文件上传：</p>
<form action="${pageContext.request.contextPath}/upload1" method="post"
      enctype="multipart/form-data">
<%--    multiple ： 多文件上传 --%>
    Select File:<input type="file" name="file" multiple accept="image/*"><br>
    Descripton:<input type="text" name="desc"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
