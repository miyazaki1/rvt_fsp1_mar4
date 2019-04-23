<html>

<head>
<title>Login Portal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<form method="post" action="/ERS/login">
	<input name="username" type="text" placeholder="username"><br>
	<input name="password" type="password" placeholder="password"><br>
	<input type="submit" value="Sign In">
</form>


<div class="container"><br/>
    <div class="alert alert-success">         
        <strong>Success!</strong> It is working as we expected.
    </div>
</div>

</body>
</html>
