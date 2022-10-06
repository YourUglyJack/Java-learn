package com.tianyi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注: 访问/register.html  不加.html会报空指针异常
        System.out.println("获取单值参数name:" + req.getParameter("name"));

        String[] hobits = req.getParameterValues("hobits");
        System.out.println("获取具有多值的参数:" + Arrays.asList(hobits));

        System.out.println("通过getParameterMap遍历所有参数:");
        Map<String, String[]> params = req.getParameterMap();
        Set<String> paramNames = params.keySet();
        for (String param : paramNames) {
            String[] values = params.get(param);
            System.out.println(param + ":" + Arrays.asList(values));
        }
    }
}
