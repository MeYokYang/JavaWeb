<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    ${3 > 4}
    <br>
    jsp默认会解析el表达式，如果想忽略，则在page中添加属性isELIgnored="true"，或者在el表达式前加\，忽略单个el表达式

    el表达式使用：
        运算：
            算数运算符： + - * /(div) %(mod)
            比较运算符： > < >= <= == !=
            逻辑运算符： &&(and) ||(or) !(not)
            空运算符： empty
                功能：用于判断字符串，集合，数组对象是否为null并且长度是否为0
                ${empty list}
        获取值：
            el表达式只能从域对象中获取值
            语法：
                ${域名称.键名}：从指定域中获取指定键的值
                    域名称：
                        pageScope --> pageContext
                        requestScope --> request
                        sessionScope --> session
                        applicationScope --> application(ServletContext)
                ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。

<h3>算数运算符</h3>
${3 + 4}<br>
${3 / 4}<br>
${3 div 4}<br>
${3 % 4}<br>
${3 mod 4}<br>

<h3>比较运算符</h3>
${3 == 4}<br>

<h3>逻辑运算符</h3>
${3 > 4 && 3 < 4}<br>
${3 > 4 and 3 < 4}<br>

<h3>empty运算符</h3>
<%
    String str = "";
    request.setAttribute("str", str);
%>
    ${empty requestScope.str}<br>
    ${not empty requestScope.str}<br>

</body>
</html>
