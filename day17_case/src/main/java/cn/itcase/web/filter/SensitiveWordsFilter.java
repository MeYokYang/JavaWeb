package cn.itcase.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<>(); //敏感词汇集合

    public void init(FilterConfig config) throws ServletException {
        try {
            //1.获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //2.读取文件
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath),"gbk"));
            //3.将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine()) != null){
                list.add(line);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_request = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(),
                request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(request, args);
                    if(value != null){
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }

                //判断是否是getParameterMap方法
                if (method.getName().equals("getParameterMap")) {
                    //增强返回值
                    //获取返回值
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke(request, args);
                    if(map != null){
                        Map<String, String[]> new_map = new HashMap<>();
                        for (String mapKey : map.keySet()) {
                            String key = mapKey;
                            String[] values = map.get(key);

                            for (String str : list) {
                                if (key.contains(str)) {
                                    key = key.replaceAll(str, "***");
                                }
                            }

                            for (String value : values) {
                                for (String str : list) {
                                    if (value.contains(str)) {
                                        value = value.replaceAll(str, "***");
                                    }
                                }
                            }
                            new_map.put(key, values);
                        }
                        return new_map;
                    }else {
                        return null;
                    }

                }

                //判断是否是getParameterValues方法
                if (method.getName().equals("getParameterValues")) {
                    //增强返回值
                    //获取返回值
                    String[] values = (String[]) method.invoke(request, args);
                    if(values != null){
                        for (String value : values) {
                            for (String str : list) {
                                if (value.contains(str)) {
                                    value = value.replaceAll(str, "***");
                                }
                            }
                        }
                    }
                    return values;
                }


                return method.invoke(request, args);
            }
        });

        //2.放行
        chain.doFilter(proxy_request, response);
    }
}
