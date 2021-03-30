<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Task Page</title>
	</head>
	
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Login Page</h2>
		<p style="text-align:center">New Task added for ${user}</p><br>
		<p style="text-align:center">${task} task deleted for</p><br>
		<p style="text-align:center"><a href="taskform.jsp">Add Another Task</a></p><br>
		<p style="text-align:center"><a href="logout.jsp">Logout</a></p>
	</body>
</html>