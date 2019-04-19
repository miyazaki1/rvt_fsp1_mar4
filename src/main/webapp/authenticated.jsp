<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>You have Authenticated</title>
</head>
<body>

<h1>Welcome to our session tracked application, <%= session.getAttribute("username") %> </h1>
<h3>Your role: <%= session.getAttribute("job_id") %></h3>
<br>

<table>
	<thead>
		<tr>
			<th>Todo ID</th>
			<th>Title </th>
			<th>Description</th>
		</tr>
	</thead>
	<tbody id="todoTable"></tbody>
</table>


<script src="./index.js"></script>
</body>
</html>
