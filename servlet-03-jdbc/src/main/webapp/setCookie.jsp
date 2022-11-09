<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/9
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<%
    Cookie c = new Cookie("name", "Gareen");
    c.setMaxAge(60*60*24);
    c.setPath("/");
    response.addCookie(c);
%>
<a href="getCookie.jsp">跳转到获取cookie的页面</a>
