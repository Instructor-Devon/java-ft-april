<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login and Registration</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<div class="container">
		<h2>Here are some events in your state!</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ usersStates }" var="event">
				<tr>
					<td>${ event.name }</td>
					<td>${ event.date }</td>
					<td>${ event.city }</td>
					<td>${ event.planner.firstName }</td>
					<td>
					<c:choose>
						<c:when test="${ event.planner == user }">
							<a href="/edit/${ event.id }">Edit</a> |
							<a href="/delete/${ event.id }">Delete</a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${ event.attendees.contains(user)}">
									<a href="/cancel">Cancel</a>
								</c:when>
								<c:otherwise>
									<a href="/join">Join</a>
								</c:otherwise>
							</c:choose>
							
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h2>Here are some events in other states!</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action/Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ otherStates }" var="event">
				<tr>
					<td>${ event.name }</td>
					<td>${ event.date }</td>
					<td>${ event.city } ${ event.state }</td>
					<td>${ event.planner.firstName }</td>
					<td>
					<c:choose>
						<c:when test="${ event.planner == user }">
							<a href="/edit/${ event.id }">Edit</a> |
							<a href="/delete/${ event.id }">Delete</a>
						</c:when>
						<c:otherwise>
							<a href="/join/${ event.id }">Join</a>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>