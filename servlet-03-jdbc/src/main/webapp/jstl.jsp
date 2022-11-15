<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/15
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<c:set var="name" value="${'green'}" scope="request"/>--%>
<%--通过标签获取name: <c:out value="${name}"/> <br>--%>
<%--通过EL获取name: ${name}--%>

<%--<c:set var="name" value="${'gareen-pageContext'}" scope="page"/>--%>
<%--<c:set var="name" value="${'gareen-request'}" scope="request"/>--%>
<%--<c:set var="name" value="${'gareen-session'}" scope="session"/>--%>
<%--<c:set var="name" value="${'gareen-application'}" scope="application"/>--%>

<%--4个作用域都有name，取出来的是: ${name}--%>

<%
    List<String> heros = new ArrayList<>();
    heros.add("Lou");
    heros.add("Jack");
    heros.add("John");
    request.setAttribute("heros", heros);
%>
<table width="200px" align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${hero}</td>
        </tr>
    </c:forEach>
</table>