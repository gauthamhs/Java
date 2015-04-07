<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Scripting HTML in JSP</title>
</head>
<body>
<% for(int i=0;i<=5;i++){
%>
<p>The value of the iteration i is:  <em><%=i %></em> </p>
<% } %>

<%String val = request.getParameter("user");
if(val==null){
%>
<strong>The user value is null.</strong>
<% } else {%>
<p>The user value is: <%=val %></p>
<% } %>
</body>
</html>
