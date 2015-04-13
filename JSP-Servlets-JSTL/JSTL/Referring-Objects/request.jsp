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
<c:out value="${user1.email}" /><br/>
<c:out value="${user2.email}" /><br/>
<c:out value="${user3.email}" /><br/>

<c:out value='${mapping["fruit"]}' /><br/>

<c:out value="${link}" /><br/>

${link}

</body>
</html>
