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
        <input type="hidden" name="ordering" id="ordering" value="asc"/>
        <input type="hidden" name="lastClicked" id="lastClicked"/>
        <button name="searchButton" id="searchButton">Search</button>
        <select name="page" id="page"></select>
    </div>
    <div id="personDiv">
        <table></table>
    </div>
</center>
<script>
        $("#page").change(function () {
            getPersonsBySurnamePag();
        });

        $("#searchButton").on('click', function () {
            $("#page").val(1);
            getPersonsBySurnamePag();
            createDynamicSelect();
        });

        $('#personDiv').on('click', 'th', function () {
            $("#page").val(1);
            orderingHelper($(this));
            getPersonsBySurnamePag($(this));
        });

        function getPersonsBySurnamePag(outerThis) {
            $.get("${pageContext.request.contextPath}/ajax", {
                search: $("#search").val(),
                orderby: $(outerThis).html(),
                ordering: $("#ordering").val(),
                page: $("#page").val(),
                rest: "person",
                method: "getbysurnamewithpagination"
            }, function (response) {
                $("#personDiv").find("table").html("");
                $("#personDiv").find("table").append("<tr>" +
                    "<th>ID</th>" +
                    "<th>Name</th>" +
                    "<th>LName</th>" +
                    "<th>Dob</th>" +
                    "</tr>");
                $.each(response.persons, function (i, element) {
                    console.log(response.persons[i].id + ' ' + response.persons[i].name + ' ' + response.persons[i].lastname + ' ' + response.persons[i].date);
                    $("#personDiv").find("table").append(
                        "<tr><td>" + response.persons[i].id + "</td>" +
                        "<td>" + response.persons[i].name + "</td>" +
                        "<td>" + response.persons[i].lastname + "</td>" +
                        "<td>" + response.persons[i].date + "</tr>");
                });
            });
        }

        function createDynamicSelect() {
            $.get("${pageContext.request.contextPath}/ajax", {
                search: $("#search").val(),
                rest: "person",
                method: "gettotalbysurname"
            },function (response) {
                console.log(response);
                $("#page").html("");
                var iterations;
                if (response % 10 == 0) {
                    iterations = (response / 10);
                } else {
                    iterations = (response / 10) + 1;
                }
                for (var i = 1; i <= iterations; i++) {
                    $("#page").append("<option value=" + i + ">" + i + "</option>");
                }
            });
        }

        function orderingHelper(outerThis) {
            if ($("#lastClicked").html() == $(outerThis).html()) {
                if ($("#ordering").val() == "asc") {
                    $("#ordering").val("desc");
                }
                else if ($("#ordering").val() == "desc") {
                    $("#ordering").val("asc");
                }
            }
            else {
                $("#ordering").val("asc");
            }
            $("#lastClicked").html($(outerThis).html());
        }
</script>
</body>
</html>
