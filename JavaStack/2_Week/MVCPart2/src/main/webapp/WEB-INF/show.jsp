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
	<h1>Here's one person! (id of ${ person.id })</h1>
	<h4>You have submitted ${ times } times.</h4>
	<hr />
	<h3>${ person.name }</h3>
</body>
</html>