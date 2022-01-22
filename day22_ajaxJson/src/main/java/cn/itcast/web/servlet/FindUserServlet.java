package cn.itcast.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");

        //使用此时$.get就可以不用指定参数值”json“
        response.setContentType("application/json;charset=utf-8");

        String username = request.getParameter("username");

        Map<String, Object> map = new HashMap<>();

        if ("Tom".equals(username)) {
            map.put("userExist", true);
            map.put("msg", "此用户名太受欢迎，请更换一个");
        }else {
            map.put("userExist", false);
            map.put("msg", "用户名可用");
        }

        //将map转为json，并且转递给客户端
        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        //转递给客户端
        mapper.writeValue(response.getWriter(), map);
    }
}
