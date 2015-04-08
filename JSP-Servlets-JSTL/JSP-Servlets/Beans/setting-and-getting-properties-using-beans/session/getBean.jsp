<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Getting the value from the set Beans</title>
</head>
<body>
<jsp:useBean id="user1" class="beans.Simple" scope="session"></jsp:useBean>

<p>The ID value is: <jsp:getProperty property="id" name="user1"/></p>

<p>The Password is: <jsp:getProperty property="password" name="user1"/></p>
<br/>
<% out.println("The Email ID is: " + user1.getId());%>
<br/>
<% out.println("The Password is: " + user1.getPassword());%>
</body>
</html>
