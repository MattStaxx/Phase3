<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Success</title>
	</head>
	<body style="background-color:#EFF5FB;">
		<p>Success...Details Updated</p>
			<div>	
				<table style="text-align:center;margin-left:auto;margin-right:auto">
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
			<p style="text-align:center"><a href="queryUserInput.jsp">Query Another ID</a></p>
	</body>
</html>