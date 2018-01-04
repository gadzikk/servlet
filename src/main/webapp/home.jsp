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
        <button name="searchButton" id="searchButton">Search</button>
    </div>
    <div id="personDiv">
        <table></table>
    </div>
    <div id="pagination"></div>
</center>
<script>
        $("#pagination").on('click',function (event) {
            var selectedPage = $(event.target).closest("div").html();
            $("#page").val(selectedPage);
            console.log('page' + $("#page").val());
            getPersonsBySurnamePag();
            createDynamicPagging($("#page").val(),2);
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
                paggingOnHtml(currentPage,level,last);
            });
        }

        function orderingHelper(htmlOrdering) {
            if ($("#lastClicked").html() == htmlOrdering) {
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
            $("#lastClicked").html(htmlOrdering);
        }

        function paggingOnHtml(currentPage, level,last) {
            $("#pagination").html("");
            var prev = Number(currentPage) - Number(1);
            var doubleprev = Number(currentPage) - Number(2);
            var next = Number(currentPage) + Number(1);
            var doubleNext = Number(currentPage) + Number(2);

            if(last>3){
                if(currentPage==1) {
                    $("#pagination").append("<div>1</div>" +
                        "<div>" + next + "</div>" +
                        "<div>" + doubleNext + "</div>" +
                        "... " + "<div>" + last + "</div>");
                    return;
                }
                var aboveOnTheBeginning = Math.abs(Number(currentPage)-Number(1))>level;
                var aboveOnTheEnd = Math.abs(Number(currentPage)-Number(last))>level;
                var prevIsOne = prev == 1;
                var nextIsLast = next == last;

                if(currentPage==last){
                    $("#pagination").append("<div>1</div>"+
                        "... "+
                        "<div>"+doubleprev+"</div>"+
                        "<div>"+prev+"</div>"+
                        "<div>"+last+"</div>");
                }
                else {
                    if(aboveOnTheBeginning && aboveOnTheEnd){
                        $("#pagination").append("<div>1</div>"+
                            "... "+
                            "<div>"+prev+"</div>"+
                            "<div>"+currentPage+"</div>"+
                            "<div>"+next+"</div>"+
                            "... "+
                            "<div>"+last+"</div>");
                    }
                    else if(aboveOnTheBeginning && !aboveOnTheEnd) {
                        if (nextIsLast) {
                            $("#pagination").append("<div>1</div>" +
                                "... " +
                                "<div>" + prev + "</div>" +
                                "<div>" + currentPage + "</div>" +
                                "<div>" + last + "</div>");
                        }
                        else {
                            $("#pagination").append("<div>1</div>" +
                                "... " +
                                "<div>" + prev + "</div>" +
                                "<div>" + currentPage + "</div>" +
                                "<div>" + next + "</div>" +
                                "<div>" + last + "</div>");
                        }
                    }
                    else if(!aboveOnTheBeginning && aboveOnTheEnd){
                        if(prevIsOne){
                            $("#pagination").append("<div>1</div>"+
                                "<div>"+currentPage+"</div>"+
                                "<div>"+next+"</div>"+
                                "... "+
                                "<div>"+last+"</div>");
                        }
                        else {
                            $("#pagination").append("<div>1</div>"+
                                "<div>"+prev+"</div>"+
                                "<div>"+currentPage+"</div>"+
                                "<div>"+next+"</div>"+
                                "... "+
                                "<div>"+last+"</div>");
                        }
                    }
                    else {
                        for (var i = 1; i <= last; i++) {
                            $("#pagination").append("<div>"+i+"</div>");
                        }
                    }
                }
            }
            else {
                for (var i = 1; i <= last; i++) {
                    $("#pagination").append("<div>"+i+"</div>");
                }
            }
        }

</script>
</body>
</html>
