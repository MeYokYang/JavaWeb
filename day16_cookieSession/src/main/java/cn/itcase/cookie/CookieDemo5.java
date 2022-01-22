package cn.itcase.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo5")
public class CookieDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //tomcat8之前cookie不能直接存储中文数据，需要转码，一般采用URL编码
        //tomcat8后cookie支持中文，但不支持特殊字符，建议使用URL编码存储
        Cookie c1 = new Cookie("msg", "你好");

        //同一个tomcat部署，设置path，可以让路径下的其他项目访问到（默认虚拟目录）
        c1.setPath("/");

        //不同tomcat部署，如果设置一级域名相同，那么多个服务器之间的cookie就可以共享
        //如setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中的cookie就可以共享

        response.addCookie(c1);


    }
}
