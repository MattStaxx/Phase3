<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Query User Input</title>
</head>
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Enter an ID# to search for</h2><br>
			<form style="text-align:center"  action="queryUserInput" method="post"> <!--  action="prods" method="post" -->
				 
				 <label for="name">Enter ID# to query:</label>
				 <input type="text" id="id" placeholder="ID Number Required" name="id" required><br><br>
				 
				<!--  <label for="color">Color:</label>
				 <input type="text" id="color" placeholder="Color Required" name="color" required><br><br>
				 
				 <label for="price">Price:</label>
				 <input type="number" step="any" id="price" placeholder="Price required" name="price" required><br><br> -->
				 
				 <input type="submit" value="Submit">
			</form><br>
			<h2>Users</h2>
						<h2 style="text-align:center">Welcome, ${user} ! </h2><br>
			<table style="float:left">
				<!-- <tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr> ${id} ${name} ${email} ${password}-->
				
				
				</table>
		<p style="text-align:center"><a href="index.jsp">Back to Home Page</a></p>
</html>