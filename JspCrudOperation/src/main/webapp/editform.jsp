<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
	<%@page import="com.user.dao.UserDao,com.user.bean.User"%>

	<%
	String id = request.getParameter("id");
	User u = UserDao.getRecordById(Integer.parseInt(id));
	%>

	<h1>Edit Form</h1>
	<form action="edituser.jsp" method="post">
		<input type="hidden" name="id" value="<%=u.getId()%>" />
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=u.getName()%>" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					value="<%=u.getPassword()%>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=u.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male" />Male <input
					type="radio" name="gender" value="female" />Female</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country">
						<option>India</option>
						<option>Pakistan</option>
						<option>Afghanistan</option>
						<option>UK</option>
						<option>Other</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit User" /></td>
			</tr>
		</table>
	</form>
</body>
</html>