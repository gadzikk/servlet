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
    <script src="global.js" type="text/javascript"></script>

    <style>
        #pagination div {
            display: inline-block;
            background-color: aliceblue;
            border: 1px solid aliceblue;
            padding: 5px;
        }
        #pagination div:hover{
            border: 1px solid lightseagreen;
        }
    </style>
</head>
<body>
<center>
    <div id="searchBox">
        Search : <input type="text" name="search" id="search"/></br>
        <input type="hidden" name="ordering" id="ordering" value="asc"/>
        <input type="hidden" name="lastClicked" id="lastClicked"/>
        <input type="hidden" name="page" id="page" value="1"/>
        <input type="hidden" name="orderby" id="orderby" value="id"/>
        <input type="hidden" name="total" id="total" value="0"/>
        <button name="searchButton" id="searchButton">Search</button>
    </div>
    <div id="personDiv">
        <table></table>
    </div>
    <div id="pagination"></div>
</center>
<script>
    $("#page").val(1);
    console.log('page' + $("#page").val());
    getPersonsBySurnamePag();
    createDynamicPagging($("#page").val());


        $("#pagination").on('click',function (event) {
            var selectedPage = $(event.target).closest("div").html();
            $("#page").val(selectedPage);
            console.log('page' + $("#page").val());
            getPersonsBySurnamePag();
            paggingOnHtml($("#page").val(), 2, $("#total").val());
        });

        $("#searchButton").on('click', function () {
            $("#page").val(1);
            console.log('page' + $("#page").val());
            getPersonsBySurnamePag();
            createDynamicPagging($("#page").val());
        });

        $('#personDiv').on('click', 'th', function () {
            $("#page").val(1);
            $("#orderby").val($(this).html());
            orderingHelper($(this).html());
            getPersonsBySurnamePag();
        });

        function getPersonsBySurnamePag() {
            $.get("${pageContext.request.contextPath}/ajax", {
                search: $("#search").val(),
                orderby: $("#orderby").val(),
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

        function createDynamicPagging(currentPage, level) {
            $.get("${pageContext.request.contextPath}/ajax", {
                search: $("#search").val(),
                rest: "person",
                method: "gettotalbysurname"
            },function (response) {
                var last = Math.round(response / 10);
                $("#total").val(last);
                paggingOnHtml(currentPage,level,last);
            });
        }



</script>
</body>
</html>
