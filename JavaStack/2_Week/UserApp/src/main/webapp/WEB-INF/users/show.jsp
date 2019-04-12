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
		<h1>Show User!</h1>
		<h4>Name: ${ user.firstName } ${ user.lastName }</h4>
		<c:if test="${ user.address != null }">
		<h4>Address:</h4>
		<p>${ user.address.street}</p>
		<p>${ user.address.city }, ${ user.address.state }</p>
		</c:if>
		<h3>You liked these posts!</h3>
		<ul>
			<c:forEach items="${ user.ideasLiked }" var="idea">
				<li>${ idea.content }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>