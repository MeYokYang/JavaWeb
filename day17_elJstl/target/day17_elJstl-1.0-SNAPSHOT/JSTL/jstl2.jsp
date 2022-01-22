<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>choose标签</title>
</head>
<body>
    <%
        request.setAttribute("number", 11);
    %>

    <c:choose>
        <c:when test="${number == 1}">Monday</c:when>
        <c:when test="${number == 2}">Tuesday</c:when>
        <c:when test="${number == 3}">Wednesday</c:when>
        <c:when test="${number == 4}">Thursday</c:when>
        <c:when test="${number == 5}">Friday</c:when>
        <c:when test="${number == 6}">Saturday</c:when>
        <c:when test="${number == 7}">Sunday</c:when>
        <c:otherwise>数字输入有误</c:otherwise>
    </c:choose>
</body>
</html>
