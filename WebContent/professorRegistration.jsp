<!DOCTYPE html>
<html>

<head>
<title>Professor Registration</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>

<body>
<h1>Professor Registration</h1>
<form class="professorReg" method="post" action="professorRegistrationServlet">
<table>
	<tr>
		<td><b>First and Last Name:</b><b style="color:red;"> *</b></td>
		<td>
			<input id="FirstName" name="FirstName" type="text" maxlength="60" style="width:146px; border:1px solid #999999" />
			<input id="LastName" name="LastName" type="text" maxlength="60" style="width:146px; border:1px solid #999999" />
		</td>
	</tr>
	<tr>
		<td><b>Qualification:</b></td>
			<td><input id="qualification" name="qualification" type="text" maxlength="120" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Research Interest:</b></td>
		<td><input id="researchInterest" name="researchInterest" type="text" maxlength="120" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Email address:</b><b style="color:red;"> *</b></td>
		<td><input id="EmailAddress" name="EmailAddress" type="text" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Contact number:</b></td>
		<td><input id="CellPhone" name="CellPhone" type="text" maxlength="43" style="width:100px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Office Address:</b></td>
		<td><textarea id="officeAddress" name="officeAddress" rows="4" cols="50" style="width: 298px;"></textarea>
	</tr>
	<tr>
		<td><b>Department:</b></td>
		<td>
	    		<select name="department">
	    			<option value="Select">Select</option>
	    			<option value="Computer Science">Computer Science</option>
	    			<option value="Information Management Systems">Information Management Systems</option>
	    			<option value="Mechanical Engineering">Mechanical Engineering</option>
	    			<option value="Arts and Technology">Arts and Technology</option>
				</select>											
		</td>
	</tr>
	</table>
	<br />
	<table>
		<tr>
			<td><b>User name:</b><b style="color:red;"> *</b></td>
			<td><input id="username" name="username" type="text" maxlength="30" style="width:100px; border:1px solid #999999" /></td>
		</tr>
		<tr>
			<td><b>Password:</b><b style="color:red;"> *</b></td>
			<td><input name="password" type="password" maxlength="30" style="width:100px; border:1px solid #999999" /></td>			
		</tr>
		<tr>
			<td><b>Confirm Password:</b><b style="color:red;"> *</b></td>
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