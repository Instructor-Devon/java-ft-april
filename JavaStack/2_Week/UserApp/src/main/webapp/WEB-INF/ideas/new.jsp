<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User App Dot Com</title>
</head>
<body>
	<div class="container">
		<h1>Add a new Idea!</h1>
		<form:form action="/ideas" method="POST" modelAttribute="idea">
			<form:hidden path="creator" value="${ userId }"/>
			<div class="form-group">
				<form:errors path="content"/>
				<form:label path="content">Content</form:label>
				<form:input class="form-control" path="content"/>			
			</div>
			<button>Add Idea</button>
		</form:form>
	</div>
</body>
</html>