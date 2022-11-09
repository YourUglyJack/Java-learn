<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/9
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<%
    Cookie[] cookies = request.getCookies();
    if (null != cookies) {
        for (int d = 0; d <= cookies.length - 1; d++) {
            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
        }
    }
%>
