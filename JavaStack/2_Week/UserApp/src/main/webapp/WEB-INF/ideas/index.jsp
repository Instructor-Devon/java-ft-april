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
		<h2>Here are some ideas!</h2>
		<a href="/ideas/new">Add an Idea</a>
		<form action="/ideas/filter">
			<input type="text" name="nameQuery" placeholder="Filter Name" />
			<button>Search</button>
		</form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>User</th>
					<th>Idea</th>
					<th>Date Added</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ ideas }" var="idea">
				<tr>
					<td>${ idea.creator.firstName } ${ idea.creator.lastName }</td>		
					<td>${ idea.content  }</td>
					<td>${ idea.getCreatedAtFormatted() }</td>
					<td><a href="#">Like this</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>