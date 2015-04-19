<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>
<body>
<h1><i>Comet Career Portal</i><br/>Registration</h1>
<form class="selectCategory" name="selectCategoryForm" method="post" action="selectCategoryServlet">
<table>
	<tr>
		<td>Select Category</td>
		<td>
    		<select name="Category">
    			<option value="Student">Student</option>
    			<option value="Professor">Professor</option>
    			<option value="Company">Company</option>
    			<option value="Department">Department</option>
			</select>		
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Submit"></td>
	</tr>
</table>
</form>
</body>
</html>