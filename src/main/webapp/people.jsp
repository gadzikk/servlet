<%@ page import="model.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="front.PersonData" %><%--
  Created by IntelliJ IDEA.
  User: gadzik
  Date: 22.12.17
  Time: 05:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>People</title>
</head>
<body>
<%
    PersonData data = (PersonData) request.getSession().getAttribute("persondata");
    ArrayList<Person> persons = (ArrayList<Person>) data.getPersons();
    for (Person person: persons) {
%>
<tr>
    <td><%=person.getId()%></td>
</tr>
<%}%>
</body>
</html>
