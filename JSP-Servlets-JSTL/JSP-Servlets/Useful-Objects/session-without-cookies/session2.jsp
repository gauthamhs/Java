<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Using the session Object</title>
</head>
<body>
<%@ page import="user.Grades" %>
<% Grades grades = (Grades)session.getAttribute("grades"); %>
The total grade value is: <%=grades==null?"error":grades.getGrades()%>
<a href="<%=response.encodeUrl(request.getContextPath() + "/session3.jsp")%>"> Click here to go to session2</a>
</body>
</html>
