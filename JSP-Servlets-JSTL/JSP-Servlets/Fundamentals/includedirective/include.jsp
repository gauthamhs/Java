<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Incorporating files in JSP</title>
</head>
<body>

<%@include file="intro.txt" %>

<%
String val = request.getParameter("user");
%>
<br/>
<% if(val==null){ %>
	
<jsp:include page="nullvalue.txt" />

<% } else {%>
<jsp:include page="valuefound.txt" />
<%} %>
<%@include file="variables.jsp"%>
<%=
name
%>


</body>
</html>
