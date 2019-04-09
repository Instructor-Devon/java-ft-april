<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User App Dot Com</title>
</head>
<body>
	<div class="container">
		<h1>Here are my users!</h1>
		<a href="/new">Add a User</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Date Added</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ users }" var="user">
				<tr>
					<td>${ user.firstName }</td>
					<td>${ user.lastName }</td>
					<td>${ user.getCreatedAtFormatted() }</td>
					<td><a href="/edit/${ user.id }">Edit</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>