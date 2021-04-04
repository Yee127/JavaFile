<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/2/23
  Time: 4:41 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <script type="text/javascript" src="jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            // ajax--getJson 请求
            $("#submit").click(function () {
                $.getJSON("http://localhost:8080/8_JSON_Ajax/ajaxServlet","action=getJson",function (data) {
                    $("#msg").html("getJSON--> Name:"+data.name+",Age:"+ data.age);
                });
            });
        });

    </script>
</head>
<body>
   <button id="submit" value="提交请求">提交请求</button>
    <div id="msg">

    </div>
</body>
</html>
