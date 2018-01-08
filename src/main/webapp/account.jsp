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
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<%
    Account account = (Account) request.getSession().getAttribute("auth");
%>
<div id="account_info">
    <table class="center">
        <tr><td>Email:</td><td><%=account.getEmail()%></td></tr>
        <tr><td>Your Money:</td><td><%=account.getMoney()%></td></tr>
        <tr><td>Account Created:</td><td><%=account.getCreationDate()%></td></tr>
    </table>
</div>

<div id="transfer">
    <form action = "${pageContext.request.contextPath}/ajax" method = "POST">
        Receiver ID: <input type="text" name="receiver_id" />
        Money: <input type = "number" name = "money"/>
        <input type = "hidden" name = "sender_id" value="<%=account.getId()%>" />
        <input type = "hidden" name = "rest" value="transfer" />
        <input type = "hidden" name = "method" value="outgoing" />
        <input type = "hidden" name = "view" value="account.jsp" />
        <input type = "submit" value = "Submit" />
    </form>
</div>
<a href="home.jsp">home</a>
</body>
</html>
