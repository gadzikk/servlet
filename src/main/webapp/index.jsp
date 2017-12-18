<html>
<body>
<h2>Hello Worldsds!</h2>
<p><%=request.getAttribute("message")%></p>
${message}

<form action = "${pageContext.request.contextPath}/control" method = "GET">
    id: <input type = "text" name = "id">
    <br />
    <input type = "hidden" name = "method" value="getbyid" />
    <input type = "hidden" name = "rest" value="account" />
    <input type = "hidden" name = "page" value="main.jsp" />
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
<%--http://localhost:8080/servlets/control--%>