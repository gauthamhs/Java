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
<c:choose>

<c:when test="${param.id==1 }">
The value is <strong>1</strong>
</c:when>

<c:when test="${param.id==2 }">
The value is <strong>2</strong>
</c:when>

<c:otherwise>
The value is neither <em>1</em> nor <em>2</em>
</c:otherwise>

</c:choose>
</body>
</html>
