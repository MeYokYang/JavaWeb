<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 25537
  Date: 2022/1/17
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>itcase</title>
</head>
<body>

<%
    //1.获取所有cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    //2.遍历cookies数组
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("lastTime".equals(name)) {

                flag = true;

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = URLEncoder.encode(sdf.format(date), "utf-8");
                cookie.setValue(str_date);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);

                String value = URLDecoder.decode(cookie.getValue(), "utf-8");
%>
<h1>欢迎回来，您上次访问时间为:<%=value%></h1>
<%
                break;
            }

        }
    }

    if (cookies == null || cookies.length == 0 || flag == false) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = URLEncoder.encode(sdf.format(date), "utf-8");
        Cookie cookie = new Cookie("lastTime", str_date);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
%>
        <h1>您好，欢迎您首次访问</h1>
<%
    }

%>


</body>
</html>
