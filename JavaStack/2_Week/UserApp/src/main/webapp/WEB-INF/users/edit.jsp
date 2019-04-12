<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User App Dot Com</title>
</head>
<body>
	<div class="container">
		<h1>Edit User!</h1>
		<form:form action="/${ user.id }" method="POST" modelAttribute="user">
			<input type="hidden" name="_method" value="put"/>
			<div class="form-group">
				<form:errors path="firstName"/>
				<form:label path="firstName">First Name</form:label>
				<form:input class="form-control" path="firstName"/>			
			</div>
			<div class="form-group">
				<form:errors path="lastName"/>
				<form:label path="lastName">Last Name</form:label>
				<form:input class="form-control" path="lastName"/>			
			</div>
			<div class="form-group">
				<form:errors path="address.street"/>
				<form:label path="address.street">Street</form:label>
				<form:input class="form-control" path="address.street"/>			
			</div>
			<div class="form-group">
				<form:errors path="address.city"/>
				<form:label path="address.city">City</form:label>
				<form:input class="form-control" path="address.city"/>			
			</div>
			<div class="form-group">
				<form:errors path="address.state"/>
				<form:label path="address.state">State</form:label>
				<form:input class="form-control" path="address.state"/>			
			</div>
			<div class="form-group">
				<form:errors path="address.zipCode"/>
				<form:label path="address.zipCode">Zip Code</form:label>
				<form:input class="form-control" path="address.zipCode"/>			
			</div>
			<form:hidden path="address.id" value="${ user.address.id }"/>
			<form:hidden path="address.resident" value="${ user.id }"/>
			<button>Add User</button>
		</form:form>
	</div>
</body>
</html>