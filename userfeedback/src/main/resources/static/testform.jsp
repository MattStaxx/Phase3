<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
	<title>Spring MVC - JSON Request Sample</title>
	<!--<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>  -->
	</head>
	<body>
		<h2>Enter Employee Details</h2>
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr>
				<td>Comment</td>
				<td><input type="text" id="comments" name="comment"></td>
			</tr>
			<tr>
				<td>Rating</td>
				<td><input type="number" id="rating" name="rating"></td>
			</tr>
			<tr>
				<td>User</td>
				<td><input type="text" id="user" name="user"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="submit" value="Submit" /></td>
			</tr>
		</table>
		
		<form style="text-align:center"  action="newFeedback" method="post">
			
				 <label for="name">ID# to query:</label>
				 <input type="number" id="id" placeholder="ID Number Required" name="id" required><br><br>
				 
				 <label for="name">Comment:</label>
				 <input type="text" id="comments" name="comment">
				 
				 <input type="submit" value="Submit">
				 
			</form><br>
		
		
		<hr/>
		<div id="displayDiv" style="display:none"><h3>JSON Data returned from Server after processing</h3>
			<div id="processedData"></div>
		</div>
	<script>
		jQuery(document).ready(function($) {
	 
			$("#submit").click(function(){
				var feedbackData = {};
				feedbackData["id"] = $("#id").val();
				feedbackData["comments"] = $("#comments").val();
				feedbackData["rating"] = $("#rating").val();
				feedbackData["user"] = $("#user").val();
				
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "newFeedback",
					data : JSON.stringify(feedbackData),
					dataType : 'json',				
					success : function(data) {
						$('#processedData').html(JSON.stringify(data));
						$('#displayDiv').show();
					}
				});
			});
	 
		});
	</script>	
	 
	</body>
</html>