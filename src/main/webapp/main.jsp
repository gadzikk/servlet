<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gadzik
  Date: 18.12.17
  Time: 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MAIN</title>
</head>
<body>

<form action = "${pageContext.request.contextPath}/control" method = "GET">
    <br />
    <input type = "hidden" name = "method" value="getall" />
    <input type = "hidden" name = "rest" value="person" />
    <input type = "hidden" name = "page" value="people.jsp" />
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
