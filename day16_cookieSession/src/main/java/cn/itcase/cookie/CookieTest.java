package cn.itcase.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 有：不是第一次访问
 *      相应数据：欢迎回来，您上次访问时间为……
 *      写回cookie： lastTime=……
 * 没有：第一次访问
 *      相应数据：您好，欢迎您首次访问
 *      写回cookie： lastTime=……
 */

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

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
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为"+value+"</h1>");

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

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");

        }

    }
}
