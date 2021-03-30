<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Task Form</title>
	</head>
	
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Login Page</h2>
		<form style="text-align:center" action="manage" method="post">
		
			<label for="name">Task Name:</label>
			<input type="text" id="name" name="name" required>
			
			<label for="start">Start Date:</label>
			<input type="date" id="start" name="start" required>
			
			<label for="end">End Date:</label>
			<input type="date" id="end" name="end" required>
			
			<label for="desc">Task Description:</label>
			<input type="text" id="desc" name="desc" required>
			
			<label for="sev">Severity</label>
			<select id="sev" name="sev">
				<option value="high">High</option>
				<option value="med">Medium</option>
				<option value="low">Low</option>
			</select>
			
			<label for="username">User:</label>
			<input type="text" name="username" value="${user}" required>
			
			<input type="submit" value="Add New Task">
		
		</form>
	</body>
</html>