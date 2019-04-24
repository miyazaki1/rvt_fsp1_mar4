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

<body style="background-image: url('foxhound.png'); background-repeat: no-repeat; background-size: cover; background-color: 070707	;">

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
	
	<form method="post" action="/ERS/DisplayReimbursements">
		<button onclick="requestData()" value="Request Data">Request Data</button>
	</form>

	<table>
		<thead>
			<tr>
				<th>Reimbursement ID</th>
				<th>Employee ID</th>
				<th>Description</th>
				<th>Amount</th>
				<th>Request Date</th>
				<th>Decision Date</th>
				<th>Deciding Manager</th>
				<th>Status</th>
				
				<th>
			</tr>
		</thead>
		<tbody id="itemTable"></tbody>
	</table>

	<script src="./index.js"></script>
</body>
</html>
