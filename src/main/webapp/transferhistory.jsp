<%@ page import="front.TransferData" %><%--
  Created by IntelliJ IDEA.
  User: gadzik
  Date: 08.01.18
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
    <script src="global.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>TRANSFERHISTORY</title>
</head>
<body>
<%--<%--%>
    <%--TransferData data = (TransferData) request.getSession().getAttribute("transferdata");--%>
<%--%>--%>
<p>history transfer</p>
<input type="hidden" name="ordering" id="ordering" value="asc"/>
<input type="hidden" name="lastClicked" id="lastClicked"/>
<input type="hidden" name="page" id="page" value="1"/>
<input type="hidden" name="orderby" id="orderby" value="id"/>
<input type="hidden" name="total" id="total" value="0"/>
<div id="transferDiv">
    <table class="center"></table>
</div>
<div id="pagination"></div>

</body>
<script>
    getTransfersByAccountPag();
    createDynamicPagging($("#page").val());

    $("#pagination").on('click',function (event) {
        var selectedPage = $(event.target).closest("div").html();
        $("#page").val(selectedPage);
        getTransfersByAccountPag();
        paggingOnHtml($("#page").val(), 2, $("#total").val());
    });

    function getTransfersByAccountPag() {
        $.get("${pageContext.request.contextPath}/ajax", {
            id: 2,
            orderby: $("#orderby").val(),
            ordering: $("#ordering").val(),
            page: $("#page").val(),
            rest: "transfer",
            method: "getbyaccountwithpagination"
        }, function (response) {
            $("#transferDiv").find("table").html("");
            $("#transferDiv").find("table").append("<tr>" +
                "<th>ID</th>" +
                "<th>SENDER_ID</th>" +
                "<th>RECEIVER_ID</th>" +
                "<th>TRANSFERED_MONEY</th>" +
                "<th>CREATION_DATE</th>" +
                "</tr>");
            $.each(response, function (i, element) {
                console.log(response[i].id + ' ' + response[i].senderId + ' ' + response[i].receiverId + ' ' + response[i].transferedMoney);
                $("#transferDiv").find("table").append(
                    "<tr><td>" + response[i].id + "</td>" +
                    "<td>" + response[i].senderId + "</td>" +
                    "<td>" + response[i].receiverId + "</td>" +
                    "<td>" + response[i].transferedMoney + "</td>" +
                    "<td>" + response[i].creationDate + "</td></tr>");
            });
        });
    }

    function createDynamicPagging(currentPage, level) {
        $.get("${pageContext.request.contextPath}/ajax", {
            id: 2,
            rest: "transfer",
            method: "gettotalbyaccount"
        },function (response) {
            var last = Math.round(response / 10);
            $("#total").val(last);
            paggingOnHtml(currentPage,level,last);
        });
    }

    $('#transferDiv').on('click', 'th', function () {
        $("#page").val(1);
        $("#orderby").val($(this).html());
        orderingHelper($(this).html());
        getTransfersByAccountPag();
    });

</script>
</html>
