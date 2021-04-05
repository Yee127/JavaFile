<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: yee
  Date: 2021/2/15
  Time: 4:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%--jsp 头部的 page 指令--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  jsp 中的常用脚本
        声明脚本(极少使用)
           <%! 声明 java 代码 %>
--%>
<%--=============================== 声明脚本(极少使用) ====================================--%>
<%--1.声明类属性--%>
<%!
    private Integer integer;
    private String string;
    private static Map<String,Object> map;
%>
<%--2.声明Static静态代码块--%>
<%!
    static {
        map = new HashMap<String,Object>();
        map.put("k1","v1");
    }
%>
<%--3.声明类方法--%>
<%!
    public int test(){
        return 1;
    }
%>
<%--4.声明内部类--%>
<%!
    public static class A{
        private Integer integer = 12;
    }
%>
<hr>
<%--=============================== 表达式脚本(常用) ====================================--%>
<%--
    格式：<%=表达式%>
--%>
<%=12 %> <br>
<%=12.12 %> <br>
<%="我是字符串" %> <br>
<%=map%> <br>
<%=request.getParameter("username")%>
<%--=============================== 代码脚本 ====================================--%>
<%--
代码脚本的格式是:
    <%
    java 语句
    %>

    代码脚本的特点是:
        1、代码脚本翻译之后都在_jspService 方法中
        2、代码脚本由于翻译到_jspService()方法中，所以在_jspService()方法中的现有对象都可以直接使用。
        3、还可以由多个代码脚本块组合完成一个完整的 java 语句。
        4、代码脚本还可以和表达式脚本一起组合使用，在 jsp 页面上输出数据

--%>

<%--=============================== 九个内置对象 ====================================--%>
<%--
    request         请求对象
    response        响应对象
    pageContext     jsp的上下文对象
    session         会话对象
    application     ServletContext对象
    config          ServletConfig对象
    out             jsp输出流对象
    page            指向当前jsp对象
    exception       异常对象
--%>

<%--=============================== jsp 四大域对象 ====================================--%>
<%--
    四个域对象分别是:
    pageContext     (PageContextImpl 类)      当前 jsp 页面范围内有效
    request         (HttpServletRequest 类)   一次请求内有效
    session         (HttpSession 类)          一个会话范围内有效(打开浏览器访问服务器，直到关闭浏览器)
    application     (ServletContext 类)       整个 web 工程范围内都有效(只要 web 工程不停止，数据都在)

    域对象是可以像 Map 一样存取数据的对象。
    四个域对象功能一样。不同的是它们对数据的存取范围。 虽然四个域对象都可以存取数据。
    在使用上它们是有优先顺序的。
    四个域在使用的时候，优先顺序分别是，他们从小到大的范围的顺序。
    pageContext ====>>> request ====>>> session ====>>> application
--%>
<%--=============================== jsp 静态包含 ====================================--%>
<%--
<%@ include file=""%> 就是静态包含
file 属性指定你要包含的 jsp 页面的路径 地址中第一个斜杠/表示为http://ip:port/工程路径/ 映射到代码的web目录
静态包含的特点:
1、静态包含不会翻译被包含的 jsp 页面。
2、静态包含其实是把被包含的 jsp 页面的代码拷贝到包含的位置执行输出。
--%>
<%@ include file="/include/footer.jsp"%>
<%--=============================== jsp 动态包含 ====================================--%>
<%--
    <jsp:include page=""></jsp:include> 这是动态包含
    page 属性是指定你要包含的 jsp 页面的路径 动态包含也可以像静态包含一样。把被包含的内容执行输出到包含位置
    动态包含的特点:
    1、动态包含会把包含的 jsp 页面也翻译成为 java 代码
    2、动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。
        JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
    3、动态包含，还可以传递参数
--%>
<jsp:include page="include/footer.jsp">
    <jsp:param name="username" value="tom"/>
    <jsp:param name="password" value="root"/>
</jsp:include>

<%--=============================== jsp 标签-转发 ====================================--%>
<%--
<jsp:forward page=""></jsp:forward> 是请求转发标签，它的功能就是请求转发
page 属性设置请求转发的路径
--%>
<%--<jsp:forward page="index.html"></jsp:forward>--%>

<%--===============================================================================--%>
<%-- 练习一:在 jsp 页面中输出九九乘法口诀表 --%> <h1 align   >九九乘法口诀表</h1>
<table align   >
    <%-- 外层循环遍历行 --%>
    <% for (int i = 1; i <= 9; i++) { %>
    <tr>
        <%-- 内层循环遍历单元格 --%>
        <% for (int j = 1; j <= i ; j++) { %>
            <td>
                <%=j + "x" + i + "=" + (i*j)%>
            </td>
        <% } %>
    </tr>
     <% } %>

</table>
</body>
</html>
