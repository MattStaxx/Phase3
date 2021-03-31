<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Current Tasks</title>
	</head>
	
	<body style="background-color:#EFF5FB;">
		<h2 style="text-align:center">${userName}'s Tasks</h2>
		<p style="text-align:center"></p><br>
		
		<table style="text-align:left;width:70%; cellpadding:2px" >
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
		   <p>${e}
		   <form style="text-align:center" action="home" method="get">
		   		<input type="hidden" id="userName" name="userName" value="${userName}">
				
				<input type="submit" value="Home">
		   </form>
		   <p style="text-align:center"><a href="/">Exit Task Manager</a></p>
	</body>
</html>