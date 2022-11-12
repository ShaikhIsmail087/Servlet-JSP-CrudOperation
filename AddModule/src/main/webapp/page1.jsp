<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is page one</h1>
	<h2>The server time is:<%=new java.util.Date() %></h2>
	<a href="page2.jsp">Go to page two</a>
	<form action="about">
		<h1>Client Server Info<h2><a href="/AddModule/about">Click here</a></h2></h1>
	</form>
</body>
</html>