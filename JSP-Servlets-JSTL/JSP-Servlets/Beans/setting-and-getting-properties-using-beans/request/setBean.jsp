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
<jsp:useBean id="user3" class="beans.Simple" scope="request"></jsp:useBean>

<jsp:setProperty property="id" name="user3" value="21"/>

<jsp:setProperty property="password" name="user3" value="Sherlocked"/>

<%
//response.sendRedirect("getRequestBean.jsp"); Won't work, The "request" can only take one request.
//Redirecting is two request. First is running the setRequestBean and Second is redirecting the page to a new Page.

request.getRequestDispatcher("getRequestBean.jsp").forward(request, response); //Works since it is a one request. All it does
// is to take the contents from getRequestBean and put it in the setRequestBean.jsp file.
%>

</body>
</html>
