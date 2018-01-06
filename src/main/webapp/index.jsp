<html>
<body>
<h2>Hello Worldsds!</h2>
<p><%=request.getAttribute("message")%></p>
${message}

<form action = "${pageContext.request.contextPath}/control" method = "GET">

    <input type = "text" name = "email"/>
        <input type="password" name="password" />
    <input type = "hidden" name = "rest" value="authentication" />
    <input type = "hidden" name = "method" value="login" />
    <input type = "hidden" name = "view" value="account.jsp" />
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
<%--http://localhost:8080/servlets/control--%>