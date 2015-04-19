<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>
<%
	HttpSession session = request.getSession();
	session.setAttribute("page", "UpdateProfile");
	String role = (String)session.getAttribute("role");
	
%>
<body>
<h1><center>Update Your Profile</center></h1>
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

<div align="center" class="navButtons">
<table>
	<tr>

		<td>
			<form class="transparent" method="post" action="updatePersonalInfo.jsp">
				<input type="submit" name="updatePersonalInfoButton" value="Update Personal Information">
			</form>
		</td>
		<td>
			<form class="transparent" method="post" action="projectDetails.jsp">		
				<input type="submit" name="updateProjectButton" value="Add Projects">
			</form>
		</td>
		<td>
			<form class="transparent" method="post" action="addNewSkill.jsp">
				<input type="submit" name="updateSkillsButton" value="Add Skills">
			</form>
		</td>
		<td>
			<form class="transparent" method="post" action="workExperience.jsp">
				<input type="submit" name="updateWorkExButton" value="Add Work Details">
			</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>