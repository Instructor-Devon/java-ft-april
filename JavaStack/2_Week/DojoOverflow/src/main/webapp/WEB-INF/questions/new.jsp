<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dojo Overflow</title>
</head>
<body>
	<div class="container">
		<h1>Add a new Question</h1>
		<form:form action="/" method="POST" modelAttribute="newQ">
			<div class="form-group">
				<form:errors path="question"/>
				<form:label path="question">Question</form:label>
				<form:textarea class="form-control" path="question"/>			
			</div>
			<div class="form-group">
				<form:errors path="tagField"/>
				<form:label path="tagField">Tags</form:label>
				<form:input class="form-control" path="tagField"/>			
			</div>
			<button>Add Question</button>
		</form:form>
	</div>
</body>
</html>