<html>

<head>
<title>Login Portal</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body style="background-image: url('foxhound.png'); background-repeat: no-repeat; background-size: contain, cover; background-color: 070707	;">

	<div style="margin: 20%">
		<form method="post" action="/ERS/login">
			
			<label>Username:  </label><input name="username" type="text" placeholder="username"><br>
			<label>Password:  </label><input name="password" type="password" placeholder="password"><br>
			<input type="submit" value="Sign In">
		</form>
	</div>

</body>
</html>
