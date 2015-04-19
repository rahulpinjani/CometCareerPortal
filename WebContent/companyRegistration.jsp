<!DOCTYPE html>
<html>

<head>
<title>Company Registration</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>

<body>
<h1>Company Registration</h1>
<form class="companyReg" method="post" action="companyRegistrationServlet">
<table>
<tr>
<td align="left"><b>Name:</b></td>
<td><input id="companyName" name="companyName" type="text" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
</tr>
<tr>
<td valign="top"><b>Description:</b></td>
<td><textarea id="companyDescription" name="companyDescription" rows="6" cols="50" style="width: 298px;"></textarea>
</tr>
<tr>
<td><b>Company Location:</b></td>
<td><input id="companylocation" name="companylocation" type="text" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
</tr>
<tr>
<td><b>Website:</b></td>
<td><input id="website" name="website" type="url" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
</tr>
</table>
<br />
<table>
	<tr>
		<td>
			<b>User name:</b><b style="color:red;"> *</b>
		</td>
		<td>
			<input id="username" name="username" type="text" maxlength="30" style="width:100px; border:1px solid #999999" />
		</td>
	</tr>
	<tr>
		<td>
			<b>Password:</b><b style="color:red;"> *</b>
		</td>
		<td>
			<input name="password" type="password" maxlength="30" style="width:100px; border:1px solid #999999" />
		</td>			
	</tr>
	<tr>
		<td>
			<b>Confirm Password:</b><b style="color:red;"> *</b>
		</td>
		<td>
			<input id="password" name="confirmPassowrd" type="password" maxlength="30" style="width:100px; border:1px solid #999999" />
		</td>			
	</tr>			
	<tr>
		<td colspan="2" align="center">
			<br />
			<input type="submit" value="Register" />
		</td>
	</tr>
</table>
</form>
</body>
</html>