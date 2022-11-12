<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background: red">
	<h1>This is page Two!</h1>
	<h2>The server time is:<%=new java.util.Date() %></h2>
	<h2>The Random number is:<%=new Random().nextInt() %></h2>
	<a href="page3.jsp">Go to page Three</a>
</body>
</html>