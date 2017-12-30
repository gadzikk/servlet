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
    <div id="searchBox">
        Search : <input type="text" name="search" id="search"/></br>
        <button name="searchButton" id="searchButton">Search</button>
        <select name="page" id="page"></select>
    </div>
    <div id="personDiv">
        <table></table>
    </div>
</center>
<script>

    $("#page").change(function () {
        changePersonPage();
    });

    $("#searchButton").on('click', function () {
        getPersonsBySurnamePag();
    });

    function getPersonsBySurnamePag() {
        $.get("${pageContext.request.contextPath}/ajax", {
            search: $("#search").val(),
            page: 1,
            rest: "person",
            method: "getbysurnamewithpagination"
        }, function (response) {
            $("#personDiv").find("table").html("");
            $("#personDiv").find("table").append("<tr>" +
                "<th>ID</th>" +
                "<th>Name</th>" +
                "<th>LastName</th>" +
                "<th>Date</th>" +
                "</tr>");
            $.each(response.persons, function (i, element) {
                console.log(response.persons[i].id + ' ' + response.persons[i].name + ' ' + response.persons[i].lastname + ' ' + response.persons[i].date);
                $("#personDiv").find("table").append(
                    "<tr><td>" + response.persons[i].id + "</td>" +
                    "<td>" + response.persons[i].name + "</td>" +
                    "<td>" + response.persons[i].lastname + "</td>" +
                    "<td>" + response.persons[i].date + "</tr>");
            });
            $("#page").html("");
            var iterations;
            if (response.total % 10 == 0) {
                iterations = (response.total / 10);
            } else {
                iterations = (response.total / 10) + 1;
            }
            for (var i = 1; i <= iterations; i++) {
                $("#page").append("<option value=" + i + ">" + i + "</option>");
            }
        });
    }
    function changePersonPage() {
        $.get("${pageContext.request.contextPath}/ajax", {
            search: $("#search").val(),
            page: $("#page").val(),
            rest: "person",
            method: "getbysurnamewithpagination"
        }, function (response) {
            $("#personDiv").find("table").html("");
            $("#personDiv").find("table").append("<tr>" +
                "<th>ID</th>" +
                "<th>Name</th>" +
                "<th>LastName</th>" +
                "<th>Date</th>" +
                "</tr>");
            $.each(response.persons, function (i, element) {
                console.log(response.persons[i].id + ' ' + response.persons[i].name + ' ' + response.persons[i].lastname + ' ' + response.persons[i].date);
                $("#personDiv").find("table").append(
                    "<tr><td>" + response.persons[i].id + "</td>" +
                    "<td>" + response.persons[i].name + "</td>" +
                    "<td>" + response.persons[i].lastname + "</td>" +
                    "<td>" + response.persons[i].date + "</tr>");
            });
        })
    }
</script>
</body>
</html>
