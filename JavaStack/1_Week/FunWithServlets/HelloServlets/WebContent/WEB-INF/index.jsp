<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.codingdojo.fun.Gorilla"%>
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
	<% 
		int height = (int)request.getAttribute("height");
		int width = (int)request.getAttribute("width");
		Gorilla myG = (Gorilla)request.getAttribute("gorilla");
		
	%>
	<h1>Checkerboard</h1>
	<h2><%= myG.greeting() %></h2>
	<div class="container">
		<h2>Height: <%= height %> | Width: <%= width %></h2>
		<hr />
		<% for(int row = 0; row < height; row++){ %>
			<div>
				<% for(int col = 0; col < width; col++) { %>
					<div class="tile color<%= (row+col) % 2 + 1 %>"></div>
				<% } %>
			</div>
		<% } %>
		
	</div>
	<hr />
	<form action="/HelloServlets/Home">
		<input type="text" name="name" id="" />
		<button>asdf</button>
	</form>
</body>
</html>