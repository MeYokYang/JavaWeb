<%@ page import="cn.itcase.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("Hugh");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("u", user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        request.setAttribute("list", list);


        Map map = new HashMap();
        map.put("name", "Jack");
        map.put("gender", "male");

        request.setAttribute("map", map);
    %>

<h3>el获取对象里的值</h3>
    ${requestScope.u}<br>
<%--    通过的是对象的属性来获取--%>
<%--        setter或getter方法，去掉set或get，再将剩余部分，首字母变小写。--%>
    ${requestScope.u.name}<br>
    ${requestScope.u.age}<br>
    ${requestScope.u.birthday}<br>
    ${requestScope.u.birthday.year}<br>
    ${requestScope.u.birStr}<br>

<h3>el获取list的值</h3>
    ${requestScope.list}<br>
    ${requestScope.list[1]}<br>
    ${requestScope.list[10]}<br>

<h3>el获取map的值</h3>
    ${requestScope.map}<br>
    ${requestScope.map.gender}<br>
    ${requestScope.map["gender"]}<br>
    ${requestScope.map.a}<br>

</body>
</html>
