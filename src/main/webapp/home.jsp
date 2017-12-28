<%--
  Created by IntelliJ IDEA.
  User: gadzik
  Date: 24.12.17
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jQuery AJAX example with Java</title>
    <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
</head>
<body>
<center>
    <div id="divId">
        Search : <input type="text" name="search" id="search"/></br>
        <button name="searchButton" id="searchButton">Search</button>
    </div>
    <div id="messageDiv">
        <table></table>
    </div>
</center>
<script>
    $("#searchButton").on('click', function () {
        callAjax();
    });

    function callAjax() {
        $.get("${pageContext.request.contextPath}/ajax", {
            search: $("#search").val()
        }, function (response) {
            $("#messageDiv").find("table").html("");
            $("#messageDiv").find("table").append("<tr>" +
                "<th>ID</th>" +
                "<th>Name</th>" +
                "<th>LastName</th>" +
                "<th>Date</th>" +
                "</tr>");
            $.each(response, function (i, element) {
                console.log(response[i].id + ' ' + response[i].name + ' ' + response[i].lastname + ' ' + response[i].date);
                $("#messageDiv").find("table").append(
                    "<tr><td>" + response[i].id + "</td>" +
                    "<td>" + response[i].name + "</td>" +
                    "<td>" + response[i].lastname + "</td>" +
                    "<td>" + response[i].date + "</tr>");
            });
        });
    }
</script>
</body>
</html>
