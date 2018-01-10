<%@ page import="model.Account" %><%--
  Created by IntelliJ IDEA.
  User: gadzik
  Date: 04.01.18
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script
            src="https://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
    <script src="global.js" type="text/javascript"></script>
</head>
<body>
<%
    Account account = (Account) request.getSession().getAttribute("auth");
%>
<div id="account_info">
    <table class="center">
        <tr><td>Email:</td><td><%=account.getEmail()%></td></tr>
        <tr><td>Your Money:</td><td><%=account.getMoney()%></td></tr>
        <tr><td>Account Created:</td><td><%=account.getCreationDate()%></td></tr>
    </table>
</div>

<div id="transfer">
    <form id="transferform" action = "${pageContext.request.contextPath}/ajax" method = "POST">
        Receiver ID: <input type="text" id="receiver_id" name="receiver_id" />
        Money: <input type = "number" id="money" name = "money"/>
        <input type = "hidden" id="id" name = "id" value="<%=account.getId()%>" />
        <input type = "hidden" id="rest" name = "rest" value="transfer" />
        <input type = "hidden" id="method" name = "method" value="outgoing" />
        <input type = "hidden" id="view" name = "view" value="transferhistory.jsp" />
        <%--<input type = "submit" value = "Submit" />--%>
        <input type='button' value='Submit form' onClick='submitDetailsForm()' />
    </form>
</div>
<div><a href="home.jsp">home</a></div>
<div id="transferDone">
</div>

</body>
<script>
$("#transferDone").hide();

    function submitDetailsForm()  {
            $.post("${pageContext.request.contextPath}/ajax", {
                receiver_id: $("#receiver_id").val(),
                money: $("#money").val(),
                id: $("#id").val(),
                rest:$("#rest").val(),
                method:$("#method").val(),
                view:$("#view").val()
            },function (response) {
//                window.location.href = "http://localhost:8080/servlets/transferhistory.jsp";
                $("#transferDone").html("");
                $("#transferDone").append("<table class='center' id='transfertable'>" +
                    "<tr><td>SENDER: "+ response.sender.email +"</td></tr>" +
                    "<tr><td>RECEIVER: "+ response.receiver.email +"</td></tr>"+
                    "<tr><td>MONEY: "+ response.money +"</td></tr>" +
                    "</table>");
                $("#transferDone").slideDown("slow");
                $("#transferDone").append("<a href=transferhistory.jsp>transferhistory</a>");
            });
        }
</script>
</html>
