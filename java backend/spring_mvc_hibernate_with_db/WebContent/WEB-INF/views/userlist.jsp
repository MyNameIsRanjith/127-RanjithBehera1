<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List Page</title>
</head>
<body>
<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		
		<c:forEach items="${uList}" var="usr">
			<tr>
				<td>${usr.id}</td>
				<td>${usr.userName}</td>
				<td>${usr.userAge}</td>
				<td><a href="/spring_mvc_hibernate/update/${usr.id}">Update</a></td>
				<td><a href="/spring_mvc_hibernate/delete/${usr.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>