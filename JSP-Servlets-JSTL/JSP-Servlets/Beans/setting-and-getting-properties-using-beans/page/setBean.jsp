<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Setting the Value for the Beans</title>
</head>
<body>
<jsp:useBean id="user2" class="beans.Simple" scope="page"></jsp:useBean>

<jsp:setProperty property="id" name="user2" value="21"/>

<jsp:setProperty property="password" name="user2" value="Sherlocked"/>

<% out.println("The Email ID is: " + user2.getId());%>
</body>
</html>
