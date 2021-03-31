<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
	</head>
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Login Page</h2>
			<form style="text-align:center" action="loginform" method='post'>
			
				<label for="userName">Name:</label><br>
			  	<input type="text" id="userName" placeholder="Name Required" name="userName" required><br><br>
			  	
				<label for="password">Password:</label><br>
			  	<input type="password" id="password" placeholder="Password Required" name="password" required><br><br>
			  	
	  			<input type="submit" value="Login" >	
			</form>
	</body>
</html>