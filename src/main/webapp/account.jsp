<%@ page import="model.Account" %><%--
  Created by IntelliJ IDEA.
  User: gadzik
  Date: 04.01.18
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<%
    Account account = (Account) request.getSession().getAttribute("authdata");
%>
<p><%=account.getEmail()%> </p>
<p><%=account.getMoney()%> </p>
<p><%=account.getCreationDate()%> </p>


</body>
</html>
