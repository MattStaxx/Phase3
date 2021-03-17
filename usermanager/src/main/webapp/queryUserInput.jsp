<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Query User Input</title>
	</head>

	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Enter an ID to search for...</h2><br>
		
			<form style="text-align:center"  action="queryUserInput" method="post">
			
				 <label for="name">ID# to query:</label>
				 <input type="number" id="id" placeholder="ID Number Required" name="id" required><br><br>
				 
				 <input type="submit" value="Submit">
				 
			</form><br>
	<p style="text-align:center"><a href="users.jsp">Back to Home Page</a></p>
</html>