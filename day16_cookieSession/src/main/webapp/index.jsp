<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--
<%   %>:定义的Java代码，在service方法中。service方法中可以定义什么，改脚本中就可以定义什么。
<%!  %>:定义的Java代码，在jsp转换后的java类的成员位置。
<%=  %>:定义的Java代码，会输出到界面上。
--%>
    <%
        System.out.println("hello jsp");
        int i = 5;

        out.print("out");

    %>

    <%!
        int i = 3;
    %>

    <%= i %>
    <h1>hi~ jsp</h1>

    <% response.getWriter().write("response"); %>


</body>
</html>