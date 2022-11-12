<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.poc.pojo.Details"%>
<%@ page import="java.util.List"%>
<%@ page import="com.poc.daoimpl.DetailsDaoimpl"%>
<%@ page import="com.poc.dao.DetailsDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<h1 align="center">CRUD form</h1>
	<form action="/CRUDOperation/detailsController" method="post">
		<table align="center" border=1>

			<tr>
				<td>enter id</td>
				<td><input type="text" id="id" name="id"
					placeholder="enter the id"></td>
			</tr>
			<tr>
				<td>enter the name</td>
				<td><input type="text" id="student_name" name="student_name"
					placeholder="enter the name"></td>
			</tr>
			<tr>
				<td>enter the roll no</td>
				<td><input type="text" id="roll_number" name="roll_number"
					placeholder="enter the roll_no"></td>
			</tr>
			<tr>
				<td>enter the surname</td>
				<td><input type="text" id="surname" name="surname"
					placeholder="enter the surname"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="submit" value="save" id="submit"
					onclick="disabledFalse()"></td>
			</tr>
		</table>
	</form>

	<br>
	<br>
	<hr>

	<form>

		<table align="center" border=1>

			<tr>
				<th>ID</th>
				<th>STUDENT NAME</th>
				<TH>ROLL NUMBER</TH>
				<TH>SURNAME</TH>
				<TH>ACTION</TH>


			</tr>

			<%
			DetailsDao dao = new DetailsDaoimpl();
			List<Details> list = dao.retrieveDetails();
			for (Details l : list) {
			%>
			<tr>
				<td><%=l.getId()%></td>
				<td><%=l.getStudent_name()%></td>
				<td><%=l.getRoll_number()%></td>
				<td><%=l.getSurname()%></td>
				<td><a href="#"
					onclick="update(<%=l.getId()%>,'<%=l.getStudent_name()%>','<%=l.getRoll_number()%>','<%=l.getSurname()%>')">update</a></td>
				<td><a href="DetailsController?id=<%=l.getId()%>">delete</a></td>
			</tr>
			<%
			}
			%>
			<script type="text/javascript">
		function update(id,student_name,roll_number,surname)
		
		{
			console.log(id)
			document.getElementById("id").value=id;
			document.getElementById("student_name").value=student_name;
			document.getElementById("roll_number").value=roll_number;
			document.getElementById("surname").value=surname;
			document.getElementById("submit").value="update";
		}
		
		
		function disabledFalse()
		{			
		document.getElementById("id").disabled=false;
		}
		</script>
		</table>
	</form>
</body>
</html>