<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Here are some people</h1>
	<hr />
	<ul>
	<c:forEach items="${ people }" var="person">
		<li>${ person.name }</li>
	</c:forEach>
	</ul>
	<h3>${ error }</h3>
	<form action="/" method="POST">
		<label for="username">Username</label>
		<input type="text" name="username" id="username" />
		<input type="text" name="id" id="username" type="number"/>
		<button>Submit6</button>
	</form>
</body>
</html>