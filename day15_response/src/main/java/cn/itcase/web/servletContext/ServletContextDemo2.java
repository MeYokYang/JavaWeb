package cn.itcase.web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ServletContext功能：
            1.获取MIME类型
                getMimeType(String file)
            2.域对象：共享数据
            3.获取文件真实(服务器)路径
                getRealPath(String)*/

        ServletContext servletContext = this.getServletContext();

        String filename = "a.jpg";
        String mimeType = servletContext.getMimeType(filename);
        System.out.println(mimeType);

        servletContext.setAttribute("msg", "haha");
        Object msg = servletContext.getAttribute("msg");
        System.out.println(msg);

        String realPath3 = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath3);

        String realPath1 = servletContext.getRealPath("/b.txt");
        System.out.println(realPath1);

        String realPath2 = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath2);


    }
}
