<%--
  Created by IntelliJ IDEA.
  User: gadzik
  Date: 08.01.18
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<script>
    function back() {
        window.history.back();
    }
</script>
<body>
<div id="err">
    <h1>Error</h1>
    <h3>You can't transfer more money you have on your account </h3>
    <p>Please do a correct and try again</p>
</div>
<button onclick="back()">Go Back</button>
</body>
</html>
