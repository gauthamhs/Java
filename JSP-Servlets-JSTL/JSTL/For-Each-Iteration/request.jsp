<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="animal" items="${listings}">

${animal.id}: ${animal.name } <br/>

</c:forEach>

<table style='border: 2px solid blue'>

<c:forEach var="animal" items="${listings}">

<tr><td>${animal.id}</td> <td>${animal.name}</td>

</c:forEach>

</table>
</body>
</html>
