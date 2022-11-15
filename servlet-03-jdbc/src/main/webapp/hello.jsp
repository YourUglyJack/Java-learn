<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/10/25
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ page import="java.util.Date" %>

hello, JSP
<br>
<%=new Date().toLocaleString()%>
<br>
page:<%=page%>
<br>
this:<%=this%>


<jsp:include page="footer.jsp">
    <jsp:param name="year" value="2022"/>
</jsp:include>
