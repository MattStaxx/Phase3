<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Query User Input</title>
	</head>
<%
String id = request.getParameter("id");
%>
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">Editing details for...</h2>  
	 	<div>	
			<table style="text-align:center;border:1px solid black;margin-left:auto;margin-right:auto">
				<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
					<c:forEach items="${user}" var="user" varStatus="count">
						<tr id="${count.index}">
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.email}</td>
							<td>${user.password}</td>
						</tr>
				</c:forEach>
			</table>
		</div>
       
		<form style="text-align:center;margin-left:auto;margin-right:auto"  action="editUserInput" method="post">
			 
			<label for="id"></label>
			 <input type="hidden" name="id" value=<%=id%>><br><br>
			 
			 <label for="name">Edit name:</label>
			 <input type="text" id="name" placeholder="Name Required" name="name" required><br><br>
			 
			 <label for="name">Edit email:</label>
			 <input type="text" id="email" placeholder="Email Required" name="email" required><br><br>
			 
			 <label for="name">Edit password:</label>
			 <input type="password" id="password" placeholder="Password Required" name="password" required><br><br>
			 
			 <input type="submit" value="Submit">
		 	
		 </form><br>	
	<p style="text-align:center"><a href="queryUserInput.jsp">Query Another ID</a></p>
</html>