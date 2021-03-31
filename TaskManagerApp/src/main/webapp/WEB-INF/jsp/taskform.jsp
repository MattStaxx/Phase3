<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Task Form</title>
	</head>
	
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">${userName}'s Task Management Page</h2>
		<form style="text-align:left" action="manage" method="post">
			
			<input type="hidden" name="userName" value="${userName}" required><br>
			
			<label for="name">Task Name:</label>
			<input type="text" id="name" name="name" required><br>
			
			<label for="desc">Task Description:</label>
			<input type="text" id="desc" name="desc" required><br>
			
			<label for="start">Start Date:</label>
			<input type="date" id="start" name="start" required><br>
			
			<label for="end">End Date:</label>
			<input type="date" id="end" name="end" required><br>
			
			<label for="sev">Severity:</label>
			<select id="sev" name="sev">
				<option value="high">High</option>
				<option value="med">Medium</option>
				<option value="low">Low</option>
			</select><br>
			
			<label for="act">Action:</label>
			<select id="act" name="act">
				<option value="create">Create</option>
				<option value="update">Update</option>
				<option value="delete">Delete</option>
			</select><br><br>
			
			<input type="submit" value="Add New Task"><br><br>
		</form>
		
		<table style="text-align:right;width:70%; cellpadding:2px" >
		<tr><th>Task Name</th><th>Start Date</th><th>End Date</th><th>Description</th><th>Severity</th></tr>  
		   <c:forEach items="${list}" var="tsk">   
		   <tr>  
		   <td>${tsk.name}</td>  
		   <td>${tsk.start}</td>  
		   <td>${tsk.end}</td>  
		   <td>${tsk.desc}</td> 
		   <td>${tsk.severity}</td> 
		   </tr>  
		   </c:forEach>
		   </table>  
		   <br/> 
		   <form style="text-align:center" action="home" method="get">
		   		<input type="hidden" id="userName" name="userName" value="${userName}">
				
				<input type="submit" value="Home">
		   </form>
		   <p style="text-align:center"><a href="/">Exit Task Manager</a></p>
	</body>
</html>