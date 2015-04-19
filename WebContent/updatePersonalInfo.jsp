<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@page import="cometClasses.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
<title>Update Personal Profile</title>
</head>
<%
	HttpSession session = request.getSession();
	String role = (String) session.getAttribute("role");
	Student stud = new Student();
	Professor prof = new Professor();
	String var=null;
	if (role.equals("Student")) {
		stud = (Student)session.getAttribute("student");
		var="Student";
	} else {
		prof = (Professor)session.getAttribute("professor");
		var="Faculty";
	}
%>
<body>
<h1><%=var%> Center</h1>
<h2>Update Personal Profile</h2>
<form class="studentReg" method="post" action="updateProfileServlet">
<%if(role.equals("Student")) { %>
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td><b>First and Last Name:</b><b style="color:red;"> *</b></td>
			<td>
				<input id="FirstName" name="FirstName" type="text" maxlength="500" value="<%=stud.getFirstName()%>" style="width:146px; border:1px solid #999999" />
				<input id="LastName" name="LastName" type="text" maxlength="500" value="<%=stud.getLastName()%>" style="width:146px; border:1px solid #999999" />
			</td>
		</tr>
		<tr>
			<td><b>Major:</b><b style="color:red;"> *</b></td>
			<td>
				<input id="Major" name="Major" type="text" maxlength="500" value="<%=stud.getMajor()%>" style="width:146px; border:1px solid #999999" />
			</td>
		</tr>	
		<tr>
			<td><b>Student Type:</b><b style="color:red;"> *</b></td>
			<td>
				<input id="StudentType" name="StudentType" type="text" maxlength="500" value="<%=stud.getStudentType()%>" style="width:146px; border:1px solid #999999" />
			</td>
		</tr>	
		<tr>
			<td><b>Email address:</b><b style="color:red;"> *</b></td>
			<td><input id="FromEmailAddress" name="email" type="text" maxlength="500" value="<%=stud.getEmail()%>" style="width:300px; border:1px solid #999999" /></td>
		</tr>
		<tr>
			<td><b>Cell Phone:</b><b style="color:red;"> *</b></td>
			<td><input id="CellPhone" name="CellPhone" type="text" maxlength="43" value="<%=stud.getContactNumber()%>" style="width:100px; border:1px solid #999999" /></td>
		</tr>
		<tr>
			<td><b>Address:</b><b style="color:red;"> *</b></td>
			<td><textarea id="Address" name="Address" type="text" maxlength="800" style="width:300px; border:1px solid #999999"><%=stud.getMailingAddress()%></textarea></td>
		</tr>
	</table>
<%} else {%>
	<table>
		<tr>
			<td><b>First and Last Name:</b><b style="color:red;"> *</b></td>
			<td>
				<input id="prof_FirstName" name="prof_FirstName" type="text" maxlength="500" value="<%=prof.getFirstName()%>" style="width:146px; border:1px solid #999999" />
				<input id="prof_LastName" name="prof_LastName" type="text" maxlength="500" value="<%=prof.getLastName()%>" style="width:146px; border:1px solid #999999" />
			</td>
		</tr>
		<tr>
			<td><b>Qualification:</b></td>
				<td><input id="qualification" name="qualification" type="text" maxlength="200" value="<%=prof.getQualification()%>" style="width:300px; border:1px solid #999999" /></td>
		</tr>
		<tr>
			<td><b>Research Interest:</b></td>
			<td><input id="researchInterest" name="researchInterest" type="text" maxlength="500" value="<%=prof.getResearchInterest()%>" style="width:300px; border:1px solid #999999" /></td>
		</tr>
		<tr>
			<td><b>Email address:</b><b style="color:red;"> *</b></td>
			<td><input id="EmailAddress" name="prof_EmailAddress" type="text" maxlength="120" value="<%=prof.getEmail()%>" style="width:300px; border:1px solid #999999" /></td>
		</tr>
		<tr>
			<td><b>Contact number:</b></td>
			<td><input id="CellPhone" name="prof_CellPhone" type="text" maxlength="43" value="<%=prof.getContactNumber()%>" style="width:100px; border:1px solid #999999" /></td>
		</tr>
		<tr>
			<td><b>Office Address:</b></td>
			<td><textarea id="officeAddress" name="prof_officeAddress" rows="4" cols="50" style="width: 298px;"><%=prof.getMailingAddress()%></textarea>
		</tr>
	</table>
<%} %>
<br />
<table>		
	<tr>
		<td align="center">
			<br />
			<input type="submit" value="Update" />
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