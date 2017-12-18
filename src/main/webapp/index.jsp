<html>
<body>
<h2>Hello Worldsds!</h2>
<p><%=request.getAttribute("message")%></p>
${message}

<form action = "main.jsp" method = "GET">
    First Name: <input type = "text" name = "email">
    <br />
    METHOD: <input type = "text" name = "method" />
    <br />
    Rest : <input type = "text" name = "rest" />
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
<%--http://localhost:8080/servlets/control--%>