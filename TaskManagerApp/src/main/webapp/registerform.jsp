<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registration Page</title>
	</head>
	
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Registration Page</h2>
			<form style="text-align:center" action="/register" method='post'>
			
				<label for="username">Name:</label><br>
			  	<input type="text" id="username" placeholder="Name Required" name="username" required><br><br>
			  	
				<label for="email">Email:</label><br>
			  	<input type="text" id="email" placeholder="Email Required" name="email" required><br><br>
			  	
				<label for="password">Password:</label><br>
			  	<input type="password" id="password" placeholder="Password Required" name="password" required><br><br>
			  	
	  			<input type="submit" value="Register" >	
			</form>
	</body>
</html>