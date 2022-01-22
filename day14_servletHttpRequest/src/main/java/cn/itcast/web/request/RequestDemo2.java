package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示Request对象，获取请求头数据
 */
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"------"+value);
        }

        //2.获取某个
        //2.1获取user-agent
        String header = request.getHeader("user-agent");
        if (header.contains("Chrome")) {
            System.out.println("Chrome");
        } else if (header.contains("Firefox")) {
            System.out.println("Firefox");
        }

        //2.2获取referer
        String referer = request.getHeader("referer");
        System.out.println(referer);

        if (referer != null) {
            if (referer.contains("/day14")) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放中");
            }else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("拒绝播放");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
