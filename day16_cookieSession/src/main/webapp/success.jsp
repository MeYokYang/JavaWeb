<%--
  Created by IntelliJ IDEA.
  User: 25537
  Date: 2022/1/18
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("user")%>,欢迎您！</h1>
</body>
</html>
