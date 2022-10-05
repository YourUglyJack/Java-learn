package com.tianyi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public LoginServlet(){
        System.out.println("LoginServlet 构造方法被调用");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init method");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        String html = null;
        if ("admin".equals(name) && "123".equals(password))
            html = "<div style='color:green'> success </div>";
        else
            html = "<div style='color:red'>fail</div>";
        PrintWriter pw = resp.getWriter();
        pw.println(html);
        //System.out.println("name:" + name);
        //System.out.println("password:" + password);
    }
}
