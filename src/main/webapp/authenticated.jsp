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
<script src="./landing.js">setEmployeeId(<%=session.getAttribute("employee_id")%>)</script>
</head>

<body>
	<!--  style="background-image: url('images/foxhound.png'); background-repeat: no-repeat; background-size: cover; background-color: black;"> -->
	

	<!-- Header -->
	<form method="POST" action="/ERS/error.jsp"> 
	<button style="background-color: #131313; color: gray;">Logout</button>
	</form>
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
				
				<%
			if (session.getAttribute("username").toString().equals ("alex")) {
		%>
		<%=session.getAttribute("username")%>, Happy Birthday!!!
		<%
			} else {
		%>
			<%=session.getAttribute("username")%>
		<%
			}
		%>
	

	</h1>
	<!-- Navigation -->
	<button style="background-color: #131313; color: gray;"
		onclick="toggleDisplay('AddReimbursementNav')">Request
		Reimbursement</button>
	<%
	// Associate
		if (session.getAttribute("job_id").toString().equals("1")) {
	%>
	<button style="background-color: #131313; color: gray;"
		onclick="toggleDisplay('MyReimbursements')">My Reimbursements</button>
	<button style="background-color: #131313; color: gray;"
		onclick="toggleDisplay('MyProfile')">Profile</button>
					<button style="background-color: #131313; color: gray;"
		onclick="disableDisplays()">Close All</button>
	<%
	// Manager
		} else if (session.getAttribute("job_id").toString().equals("2")) {
	%>
	<button style="background-color: #131313; color: gray;"
		onclick="toggleDisplay('ReimbursementNav')">Display
		Reimbursements</button>
	<button style="background-color: #131313; color: gray;"
		onclick="toggleDisplay('MyProfile')">Profile</button>
	<button style="background-color: #131313; color: gray;"
		onclick="toggleDisplay('EmployeeNav')">Employee List</button>
			<button style="background-color: #131313; color: gray;"
		onclick="disableDisplays()">Close All</button>
	<%
		}
	%>
	<br>

	<!-- Create Reimbursement -->
	<div id="AddReimbursementNav" style="margine: 5%">
		<br>
		<h3>Create Request</h3>
		<label>Amount: </label> <input
			style="background-color: #131313; color: gray;" name="Amount"
			type="number" placeholder="amount" id="amount"> <br> <label>Description:
		</label> <input style="background-color: #131313; color: gray;"
			name="Description" type="text" placeholder="description"
			id="description"> <br>
		<button style="background-color: #131313; color: gray;"
			value="Create Remimbursement" onclick="create()">Transmit</button>
	</div>
	<!-- End of Create Reimbursement -->
	<br>
	<%
	////////////////// ASSOCIATE
		if (session.getAttribute("job_id").toString().equals("1")) {
	%>
	<div id="MyReimbursements">
		<br>
		<h3>My Reimbursements</h3>
		<button style="background-color: #131313; color: gray;"
			onclick="getItemsById()">All Requests</button>
		<button style="background-color: #131313; color: gray;"
			onclick="getItemsByStatus(1)">Pending Requests</button>
		<button style="background-color: #131313; color: gray;"
			onclick="getItemsByStatus(2)">Approved Requests</button>
		<button style="background-color: #131313; color: gray;"
			onclick="getItemsByStatus(3)">Declined Requests</button>
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
			<tbody id="myReimbursementTable"></tbody>
		</table>
	</div>
	<%
		////////////////// Manager
		} else if (session.getAttribute("job_id").toString().equals("2")) {
	%>
	<div id="ReimbursementNav">
 <h3>Displaying Transactions</h3>
		<br> <input type="number" id="EID" style="background-color: #131313; color: gray;">
		<button style="background-color: #131313; color: gray;"
			onclick="getItemsById2()">Fetch by ID</button>

		<br>
		<button style="background-color: #131313; color: gray;"
			onclick="getAllItems()">Fetch All Requests</button>

		<br>
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

	<div id="EmployeeNav">

		<br>
		<h3>List of All Employees</h3>
		<table>
			<thead>
				<tr>
					<th>EID</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-Mail</th>
					<th>
				</tr>
			</thead>
			<tbody id="EmployeeTable"></tbody>
		</table>
	</div>

	<%}%>
	<div id="MyProfile">
		<br>
		<h3>My Profile</h3>
	
		<hr>
		Employee ID::
		<%=session.getAttribute("employee_id")%>
		<br> User ID::
		<%=session.getAttribute("username")%>
		<br> First Name::
		<%=session.getAttribute("firstname")%>
		<br> Last Name::
		<%=session.getAttribute("lastname")%>
		<br> E-Mail::
		<%=session.getAttribute("email")%> <input type="text" id="changeEmail" style="background-color: #131313; color: gray; display: none">
		<br>
		<button style="background-color: #131313; color: gray;" onclick="ProfileUpdateFormShow()" id="UpdateButton">Update</button>
		<button id="ConfirmUpdate" style="background-color: #131313; color: gray; display: none" onclick="UpdateUser()">Confirm</button>
		<button id="CancelUpdate" style="background-color: #131313; color: gray; display: none" onclick="CancelUpdateProfile()">Cancel</button>
		

	</div>
	<script>
setEmployeeId(<%=session.getAttribute("employee_id")%>)
setPositionID(<%=session.getAttribute("job_id")%>)
setData( <%=session.getAttribute("employee_id")%>,"<%=session.getAttribute("firstname")%>","<%=session.getAttribute("lastname")%>","<%=session.getAttribute("email")%>",<%=session.getAttribute("job_id")%>,"<%=session.getAttribute("username")%>","<%=session.getAttribute("password")%>");
</script>

</body>
</html>
