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
		<h1>Here are some ideas!</h1>
		<a href="/ideas/new">Add an Idea</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>User</th>
					<th>Idea</th>
					<th>Date Added</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ ideas }" var="idea">
				<tr>
					<td>${ idea.creator.firstName } ${ idea.creator.lastName }</td>		
					<td>${ idea.content  }</td>
					<td>${ idea.createdAt }]</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>