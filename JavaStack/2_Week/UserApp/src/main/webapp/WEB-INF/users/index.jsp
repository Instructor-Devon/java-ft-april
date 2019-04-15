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
		<h1><a href="/">Users</a> | <a href="/ideas">Ideas</a></h1>
		<hr />
		<h2>Users in System</h2>
		<h4>Current User: ${ currentUser.firstName }</h4>
		<a href="/new">Add a User</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date Added</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ users }" var="user">
				<tr>
					<td><a href="/${ user.id }">${ user.firstName } ${ user.lastName }</a></td>
					<td>${ user.getCreatedAtFormatted() }</td>
					<td><a href="/edit/${ user.id }">Edit</a> | <a href="/login/${ user.id }">Login as User</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>