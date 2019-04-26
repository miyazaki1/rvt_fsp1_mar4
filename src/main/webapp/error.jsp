<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bye</title>
</head>
<body>
<%session.invalidate();%>
<% HttpSession nsession = request.getSession(false); %>
Logging out...
<script>
setTimeout(113000);
window.location.href = './index.jsp';

</script>
</body>
</html>