<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html/json"; charset="UTF-8">
    <title> People List </title>
</head>

<body  BGCOLOR="#D1F2EB" background="/1.jpg">
<centre><h1 style="font-size:35px;" COLOR="#696969">People List:</h1></centre>
<table>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone</th>
    </tr>
    <c:forEach items="${people}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.email}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.phone}</td>
            <%--<td><a href="/personDetails?personId=${person.id}">Select</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>