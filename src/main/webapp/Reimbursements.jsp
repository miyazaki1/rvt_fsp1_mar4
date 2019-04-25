<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Reimbursement Portal</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body style="background-image: url('images/foxhound.png'); background-repeat: no-repeat; background-size:  cover; background-color: 070707	;">


	<%
		for(int i = 0; i < 4; i++)
		{
			 System.out.println(i);
			%> <%= session.getAttribute("reimbursements["+i+"]") %> x	x	<br> <% 
			
		}
	
	
	%>







<script src="Reimbursements.js"></script>
</body>
</html>