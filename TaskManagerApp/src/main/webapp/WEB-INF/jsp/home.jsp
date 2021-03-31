<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>
	
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">${userName}'s Home Page</h2><br>
		<form style="text-align:center" action="home" method="post">
			<label for="act">Action:</label>
				<select id="act" name="act">
					<option value="manage">Manage Tasks</option>
					<option value="view">View Current Tasks</option>
				</select><br><br>
				<input type="hidden" id="userName" name="userName" value="${userName}">
				
			<input type="submit" value="Submit">
		</form>
	    <p style="text-align:center"><a href="/">Exit Task Manager</a></p>
	</body>
</html>