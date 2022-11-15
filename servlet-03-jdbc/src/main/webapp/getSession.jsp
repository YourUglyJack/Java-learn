<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/15
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"
        import="javax.servlet.http.Cookie" %>

<%
    String name = (String) session.getAttribute("name");
%>
session中的name:<%=name%>
