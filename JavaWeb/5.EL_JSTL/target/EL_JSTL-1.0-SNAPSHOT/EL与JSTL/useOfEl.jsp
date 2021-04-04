<%@ page import="com.example.EL_JSTL.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>


<%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/2/16
  Time: 10:28 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>test1</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("小马哥");
    person.setTel("10086");

    ArrayList<String> cities = new ArrayList<>();
    cities.add("hk");
    cities.add("sh");
    cities.add("sz");
    person.setCity(cities);


    HashMap<String, Object> map = new HashMap<>();
    map.put("k1","v1");
    map.put("k2","v2");
    map.put("k3","v3");
    person.setMap(map);
    pageContext.setAttribute("person",person);
%>
<br>
输出Person：${person}
<br>
输出Person.name：${person.name}
<br>
输出Person.city：${person.city[1]}
<br>
</body>
</html>
