<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Form</title>
</head>
<body>
	<form action="manage" method="post">
	<label for="sdate">Start Date:</label>
	<input type="date" id="sdate" name="sdate">
	
	<label for="sev">Severity</label>
	<select id="sev" name="sev">
		<option value="high">High</option>
		<option value="med">Medium</option>
		<option value="low">Low</option>
	</select>
	</form>
</body>
</html>