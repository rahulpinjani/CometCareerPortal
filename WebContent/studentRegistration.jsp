<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>
<body>
<h1>Student Registration</h1>
<form class="studentReg" method="post" action="studentRegistrationServlet">
<table border="0" cellpadding="5" cellspacing="0" width="600">
	<tr>
		<td><b>First and Last Name:</b><b style="color:red;"> *</b></td>
		<td>
			<input id="FirstName" name="FirstName" type="text" maxlength="60" style="width:146px; border:1px solid #999999" />
			<input id="LastName" name="LastName" type="text" maxlength="60" style="width:146px; border:1px solid #999999" />
		</td>
	</tr>
	<tr>
		<td><b>Major:</b><b style="color:red;"> *</b></td>
		<td>
    		<select name="Major">
    			<option value="Select">Select</option>
    			<option value="Computer Science">Computer Science</option>
    			<option value="Telecommunication Engineering">Telecommunication Engineering</option>
    			<option value="Software Engineering">Software Engineering</option>
    			<option value="Mechanical Engineering">Mechanical Engineering</option>
			</select>								
		</td>
	</tr>	
	<tr>
		<td><b>Student Type:</b><b style="color:red;"> *</b></td>
		<td>
    		<select name="StudentType">
    			<option value="Select">Select</option>
    			<option value="Undergraduate Student">Undergraduate Student</option>
    			<option value="Graduate Student">Graduate Student</option>
    			<option value="PhD Student">PhD Student</option>
    			<option value="Alumni Student">Alumni Student</option>
			</select>								
		</td>
	</tr>	
	<tr>
		<td><b>Email address:</b><b style="color:red;"> *</b></td>
		<td><input id="FromEmailAddress" name="email" type="text" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Cell Phone:</b><b style="color:red;"> *</b></td>
		<td><input id="CellPhone" name="CellPhone" type="text" maxlength="43" style="width:100px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Address 1:</b><b style="color:red;"> *</b></td>
		<td><input id="StreetAddress1" name="StreetAddress1" type="text" maxlength="120" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Address 2:</b></td>
		<td><input id="StreetAddress2" name="StreetAddress2" type="text" maxlength="120" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>City:</b><b style="color:red;"> *</b></td>
		<td><input id="City" name="City" type="text" maxlength="120" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>State/Province:</b><b style="color:red;"> *</b></td>
		<td><input id="State" name="State" type="text" maxlength="120" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Zip/Postal Code:</b><b style="color:red;"> *</b></td>
		<td><input id="Zip" name="Zip" type="text" maxlength="30" style="width:100px; border:1px solid #999999" /></td>
	</tr>
</table>
<br />
<table>
	<tr>
		<td><b>Username: </b><b style="color:red;"> *</b></td>
		<td><input id="username" name="username" type="text" maxlength="30" style="width:100px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Password: </b><b style="color:red;"> *</b></td>
		<td><input name="password" type="password" maxlength="30" style="width:100px; border:1px solid #999999" /></td>			
	</tr>
	<tr>
		<td><b>Confirm Password: </b><b style="color:red;"> *</b></td>
		<td><input id="password" name="confirmPassowrd" type="password" maxlength="30" style="width:100px; border:1px solid #999999" /></td>			
	</tr>
</table>
<table>		
	<tr>
		<td align="center">
			<br />
			<input type="submit" value="Next" />
		</td>
		<td align="center">
			<br />
			<input type="reset" value="Reset" />
		</td>
	</tr>
</table>
</form>
</body>
</html>