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
	
		<script src="./index.js"></script>
	
</head>

<body
	style="background-image: url('images/foxhound.png'); background-repeat: no-repeat; background-size: cover; background-color: 070707;">

	<h1>
		<%
			if (session.getAttribute("job_id").toString().equals("1")) {
		%>
		Hello Associate ,
		<%
			} else {
		%>
		Hello Manager ,
		<%
			}
		%>

		<%=session.getAttribute("username")%>
	</h1>

	<br>

		<label>Employee ID: </label><input name="Employee ID" type="text" placeholder="username" id="username"><br> 
		<label>Amount: </label><input name="Amount" type="text" placeholder="amount" id="amount"><br> 
		<label>Description:	</label><input name="Description" type="text" placeholder="description" id="description"><br>
		<button value="Create Remimbursement" onclick="create()">Create Reimbursement</button>


	<button onclick="getAllItems()">Request Data</button>

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

</body>
</html>
