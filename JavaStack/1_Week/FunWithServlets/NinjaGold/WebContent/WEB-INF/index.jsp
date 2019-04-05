<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css" />
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ninja Gold</h1>
	<h2><input type="text" value="${ gold }" id="" disabled /></h2>
	<div class="building">
		<h2>Farm</h2>
		<p>Get 2 - 5 Gold from the Farm</p>
		<form action="/NinjaGold/Home" method="POST">
			<input type="hidden" name="building" value="farm"/>
			<button>Get Gold</button>
		</form>
	
	</div>
	<div class="building">
		<h2>House</h2>
		<p>Get 3 - 7 Gold from the House</p>
		<form action="/NinjaGold/Home" method="POST">
			<input type="hidden" name="building" value="house"/>
			<button>Get Gold</button>
		</form>
	
	</div>
	<div class="building">
		<h2>Cave</h2>
		<p>Get 7 - 9 Gold from the Cave</p>
		<form action="/NinjaGold/Home" method="POST">
			<input type="hidden" name="building" value="cave"/>
			<button>Get Gold</button>
		</form>
	
	</div>
	
	<div class="building">
		<h2>Casino</h2>
		<p>Get/Lose 10 - 50 Gold from the Casino</p>
		<form action="/NinjaGold/Home" method="POST">
			<input type="hidden" name="building" value="casino"/>
			<button>Get Gold</button>
		</form>
	
	</div>
	<hr />
	<div class="messages">
	<c:forEach items="${ messages }" var="message">
		<p>${ message }</p>
	</c:forEach>
	</div>

</body>
</html>