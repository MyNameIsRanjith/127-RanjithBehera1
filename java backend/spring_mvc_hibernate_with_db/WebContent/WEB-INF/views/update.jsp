<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List Page</title>
</head>
<body>
	<h1>Update User List</h1>

	<form action="/spring_mvc_hibernate/update" method="post">
	
	<table border="1">
			<tr>
				<td>User ID : </td>
				<td><input type="hidden" name="id" value="${id}"></td>
			</tr>
			<tr>
				<td>User Name : </td>
				<td><input type="text" name="userName" value="${userName}"/></td>
			</tr>

			<tr>
				<td>User Age : </td>
				<td><input type="text" name="userAge" value="${userAge}"/></td>
			</tr>
			<tr>				
				<input type="submit" value="update"/>
			</tr>
	</table>
</form>
</body>
</html>