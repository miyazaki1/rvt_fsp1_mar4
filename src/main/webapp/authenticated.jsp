<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome <%=session.getAttribute("username")%></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<h1>
		Welcome to our session tracked application,
		<%=session.getAttribute("username")%><
	</h1>
	<h3>
		Your role:
		<%=session.getAttribute("job_id")%></h3>
	<%
		if (session.getAttribute("job_id").toString().equals("1")) {
	%>
	<p>Hello Associate</p>
	<%
		} else {
	%>
	<p>Hello Manager</p>
	<%
		}
	%>

	<br>

	<table>
		<thead>
			<tr>
				<th>Todo ID</th>
				<th>Title</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody id="todoTable"></tbody>
	</table>

	<script src="./index.js"></script>
</body>
</html>
