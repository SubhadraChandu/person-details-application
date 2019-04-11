<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title> Complete Reservation </title>
  </head>

  <body  BGCOLOR="#D1F2EB" background="/1.jpg">
  <centre><h1 style="font-size:35px;" COLOR="#696969"> Person Details </h1></centre>
    <table>
      <tr><td>Id: ${person.id}<br/></td></tr>
      <tr><td>Email: ${person.email}<br/></td></tr>
      <tr><td>First Name: ${person.firstName}<br/></td></tr>
      <tr><td>Last Name: ${person.lastName}<br/></td></tr>
      <tr><td>Phone: ${person.phone}<br/></td></tr>
    </table>
  </body>
</html>