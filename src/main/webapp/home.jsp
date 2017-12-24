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
        Username : <input type="text" name="username" id="username"/></br>
        Password : <input type="password" name="password" id="password"/></br>
        <button name="login" id="login">Login</button>
    </div>
    <div id="messageDiv"></div>
</center>
<script>
    $("#login").on('click', function(){
        var username = $("#username").val();
        var password = $("#password").val();
        if(username == ""){
            $('#messageDiv').css("display","none");
            alert("Username is required");
            return;
        }
        if(password == ""){
            $('#messageDiv').css("display","none");
            alert("Password is required");
            return;
        }
        $.ajax({
            url : "${pageContext.request.contextPath}/ajax",
            method : 'GET',
            data : {
                username : username,
                password : password
            },
            success : function(results){
                    showMessage(results);
            }
        });
    });

    //function to display message to the user
    function showMessage(results){
        var message = results;
            $('#messageDiv').text(message);
    }
</script>
</body>
</html>
