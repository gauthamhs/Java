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
<c:forEach var="i" begin="0" end="11" step="2" varStatus="status">

The loop iteration is: <c:out value="${i }"></c:out>
<br/>
<c:if test="${status.first }">
This is the first status.
</c:if>

<c:if test="${status.last }">
This is the Last status.
</c:if>
</c:forEach>
</body>
</html>
