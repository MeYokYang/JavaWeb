<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" errorPage="500.jsp" pageEncoding="UTF-8" %>

<%--
    page:配置JSP页面
        contentType:等同于response.setContentType()
            设置响应体的mime类型以及字符集
            设置当前JSP编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
        import:导包
        errorPage:当前页面发生异常后，会自动跳转到指定的错误页面
        isErrorPage:标识当前页面是否是错误页面
            true:是，可以使用内置对象exception
            false:否，默认值

    include:页面包含的。导入页面的资源文件
        <%@ include file="top.jsp"%>

    taglib:导入资源
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            prefix:前缀，自定义

--%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <%
        List list = new ArrayList();
        int i = 3/0;
    %>
</body>
</html>
