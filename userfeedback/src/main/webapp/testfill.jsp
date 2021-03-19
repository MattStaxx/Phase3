<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form style="text-align:center;margin-left:auto;margin-right:auto"  action="editUserInput" method="post">
			 
			 <!--<label for="id"></label>
			 <input type="hidden" name="id" value=<%=id%>><br><br>  -->
			 
			 <label for="name">Edit name:</label>
			 <input type="text" id="name" placeholder="comment Required" name="comments" required><br><br>
			 
			 <label for="name">Edit email:</label>
			 <input type="number" id="rating" placeholder="rating Required" name="rating" required><br><br>
			 
			 <label for="name">Edit password:</label>
			 <input type="text" id="user" placeholder="user Required" name="user" required><br><br>
			 
			 <input type="submit" value="Submit">
		 	
		 </form><br>
</body>
</html>