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

<link rel="stylehseet" type="text/css" href="cerberus.css">
<script src="./landing.js"></script>
</head>

<body
	style="background-image: url('images/foxhound.png'); background-repeat: no-repeat; background-size: cover; background-color: black;">

	<!-- Header -->
		<button style="background-color: #131313; color: gray;">Logout</button>
	<h1>
		<%
			if (session.getAttribute("job_id").toString().equals("1")) {
		%>

		Hello Associate ,

		<%
			} else if (session.getAttribute("job_id").toString().equals("2")) {
		%>
		Hello Manager ,

		<%
			} else {
		%>

		Invalid User -- #!

		<%
			}
		%>
		<!-- Prints out username -->
		<%=session.getAttribute("username")%> 
		
	</h1>
	<!-- Navigation -->
	<button style="background-color: #131313; color: gray;" onclick="toggleDisplay('AddReimbursementNav')">Request Reimbursement</button>
	<button style="background-color: #131313; color: gray;" onclick="toggleDisplay('ReimbursementNav')">Display Reimbursements</button>	
	<br>	
	<!-- Create Reimbursement -->
	<div id="AddReimbursementNav" style="margine: 5%">
	<label>Employee ID: </label>
	<input style="background-color: #131313; color: gray;" name="Employee ID"  type="text"
		placeholder="username" id="username">
	<br>
	<label>Amount: </label>
	<input style="background-color: #131313; color: gray;" name="Amount" type="text"
		placeholder="amount" id="amount">
	<br>
	<label>Description: </label>
	<input style="background-color: #131313; color: gray;" name="Description" type="text"
		placeholder="description" id="description">
	<br>
	<button style="background-color: #131313; color: gray;" value="Create Remimbursement" onclick="create()">Transmit</button>
	</div>
	<!-- End of Create Reimbursement -->
	<br>
	<div id="ReimbursementNav">
	<button style="background-color: #131313; color: gray;" onclick="getAllItems()">Fetch All Requests</button>
	<!--  All Reimbursements Table -->
	<table>
		<thead>
			<tr>
				<th>RID</th>
				<th>EID</th>
				<th>Description</th>
				<th>Amount</th>
				<th>Request Date</th>
				<th>Decision Date</th>
				<th>DM</th>
				<th>Status</th>
				<th>
			</tr>
		</thead>
		<tbody id="itemTable"></tbody>
	</table>
	</div>
	<!--  End of All Reimbursements Table -->

</body>
</html>
