<%--
  Created by IntelliJ IDEA.
  User: 25537
  Date: 2022/1/18
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙……</h1>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>
