package com.tianyi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReqServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");    // 放在最前面
        PrintWriter pw = resp.getWriter();
        pw.println("req.getRequestURL():浏览器发出请求的URL:" + req.getRequestURL());
        pw.println("----------------------------------------------------------------------------------");
        pw.println("req.getRequessrURI():浏览器发出请求的资源名部分，去掉了协议和主机名:" + req.getRequestURI());
        pw.println("----------------------------------------------------------------------------------");
        pw.println("req.getQueryString():请求行中的参数部分,只能显示以get方式发出的参数,post看不到:" + req.getQueryString());
        pw.println("----------------------------------------------------------------------------------");
        pw.println("req.getRemoteAddr():浏览器所处于的客户机的ip地址:" + req.getRemoteAddr());
        pw.println("----------------------------------------------------------------------------------");
        pw.println("req.getRemoteHost():浏览器所处于的客户机的主机名:" + req.getRemoteHost());
        pw.println("----------------------------------------------------------------------------------");
        pw.println("req.getServerPort():浏览器所处于的客户机的端口号:" + req.getServerPort());
        pw.println("----------------------------------------------------------------------------------");
        pw.println("req.getMethod():客户机(端？)的请求方式:" + req.getMethod());

    }
}
