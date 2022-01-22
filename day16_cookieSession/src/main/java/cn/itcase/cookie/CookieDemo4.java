package cn.itcase.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie c1 = new Cookie("msg", "setMaxAge");
        //设置Cookie的存活时间
        //正数，将cookie持久化到硬盘中，多少秒后自动删除cookie文件
        //负数，默认，关闭浏览器自动删除cookie
        //0，删除硬盘中持久化的cookie
        c1.setMaxAge(30);
        response.addCookie(c1);


    }
}
