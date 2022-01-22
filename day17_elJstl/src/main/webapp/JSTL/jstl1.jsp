<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--
    c:if标签
        test必须属性：接受boolean表达式，决定是否显示标签体内容。一般会结合el表达式一起使用

--%>

    <c:if test="true">hei hei</c:if><br>

    <%
        List list = new ArrayList();
        list.add("aaa");
        request.setAttribute("list", list);
        request.setAttribute("number", 3);
    %>
    <c:if test="${not empty list}">hei hei</c:if><br>
    <c:if test="${number mod 2 != 0}">${number}为奇数</c:if><br>
    <c:if test="${number mod 2 == 0}">${number}为偶数</c:if><br>


</body>
</html>
