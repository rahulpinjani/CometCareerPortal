<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Job</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>
<% 
	HttpSession session = request.getSession();

%>
<body>
<h1>Post Job</h1>
<div align="center" class="navButtons">
<table>

	<tr>
<%if(session.getAttribute("role").equals("Student")) {%>
		<td>
			<form class="transparent" method="post" action="studentHome.jsp">
				<input type="submit" name="HomeButton" value="Home">
			</form>
		</td>
<%} else if (session.getAttribute("role").equals("Professor")) {%>
		<td>
			<form class="transparent" method="post" action="professorHome.jsp">
				<input type="submit" name="HomeButton" value="Home">
			</form>
		</td>
<%} else if (session.getAttribute("role").equals("Department")) {%>
		<td>
			<form class="transparent" method="post" action="departmentHome.jsp">
				<input type="submit" name="HomeButton" value="Home">
			</form>
		</td>
<%} else {%>
		<td>
			<form class="transparent" method="post" action="companyHome.jsp">
				<input type="submit" name="HomeButton" value="Home">
			</form>
		</td>
<%} %>
		<td>
			<form class="transparent" method="post" action="postJob.jsp">
				<input type="submit" name="postJobButton" value="Post Job">
			</form>
		</td>
		<td>
			<form class="transparent" method="post" action="updateProfile.jsp">		
				<input type="submit" name="updateProfileButton" value="Update Profile">
			</form>
		</td>
		<td>
			<form class="transparent">
				<input type="submit" name="searchProfileButton" value="Search Profile">
			</form>
		</td>
<%if(session.getAttribute("role").equals("Student")) {%>
		<td>
			<form class="transparent" method="post" action="searchJob.jsp">
				<input type="submit" name="searchJobButton" value="Search Job">
			</form>
		</td>
<%}%>
		<td>
			<form class="transparent" method="post" action="LogoutServlet">
				<input type="submit" name="Logout" value="Logout">
			</form>
		</td>
	</tr>
</table>
</div>
<br></br>

<form class="postJob" method="post" action="postJobServlet">
	<table border="0" cellpadding="5" cellspacing="0" width="600">
			
	<tr>
			<td><b>Title:</b></td>
			<td><input id="Title" name="Title" type="text" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
	</tr>

	<tr>
			<td><b>Description:</b></td>
			<td><textarea id="Description" name="Description" rows="6" cols="50"  style="width: 298px;"></textarea></td>
	</tr>
	<tr>
			<td><b>Visa Category:</b></td>
			<td>
	    		<select name="VisaCategory">
	    			<option value="Select">Select</option>
	    			<option value="USCitizen">US Citizen</option>
	    			<option value="F1">F1</option>
	    			<option value="USCitizen/F1">US Citizen/F1</option>
				</select>								
			</td>
	</tr>
	<tr>
			<td><b>Job Type:</b></td>
			<td>
	    		<select name="JobType">
	    			<option value="Select">Select</option>
	    			<option value="OnCampus">On Campus</option>
	    			<option value="InternshipPartTime">Internship-PartTime</option>
	    			<option value="InternshipFullTime">Internship-FullTime</option>
	    			<option value="FullTime">Full Time</option>
	    			<option value="Contract">Contract based</option>
				</select>								
			</td>
	</tr>
	<tr>
			<td><b>Primary Requirement:</b></td>
			<td><input id="primaryreq" name="primaryreq" type="text" maxlength="100" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
			<td><b>Secondary Requirement:</b></td>
			<td><input id="secondaryreq" name="secondaryreq" type="text" maxlength="100" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
			<td><b>Additional Requirement:</b></td>
			<td><input id="additionalreq" name="additionalreq" type="text" maxlength="100" style="width:300px; border:1px solid #999999" /></td>
	</tr>

	<tr>
			<td><b>Job Link:</b></td>
			<td><input id="JobLink" name="JobLink" type="text" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
			<td colspan="2" align="center">
			<br />
			<table border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
			</table>
				<input type="submit" value="Post Job" />
				<input type="reset" value="Reset" />
			</td>
			<td colspan="2" align="center">
			<br />
				
			</td>
	</tr>	
	</table>
	<br />
</form>
</body>
</html>