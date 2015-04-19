<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@page import="cometClasses.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Technical Skills</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>
<%
	String role;
	HttpSession session = request.getSession();
	Student stud = (Student)session.getAttribute("student");
	Professor prof = (Professor)session.getAttribute("professor");
	if(stud==null) {
		role="Professor";
		session.setAttribute("professor",prof);
	} else {
		role="Student";
		session.setAttribute("student", stud);
	}	
	session.setAttribute("role", role);
%>
<body>
<h1><center><%=role%> Registration</center></h1>
<h2>Add Technical Skills</h2>
<form class="studentReg" method="post" action="addNewSkillServlet">
	<frame>
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
				<td><b>Skill*:</b></td>
				<td>
					<input id="skill" name="skill" type="text" maxlength="60" style="width:250px; border:1px solid #999999" />
				</td>
		</tr>
		<tr>
				<td><b>Years of Experience*:</b></td>
				<td>
					<input id="yearsExp" name="yearsExp" type="text" maxlength="60" style="width:250px; border:1px solid #999999" />
				</td>
		</tr>
		<tr>
				<td><b>Proficiency*:</b>(Rate on the scale of 5 (1-Beginner,5-Expert))</td>
				<td>
					<input id="proficiency" name="proficiency" type="text" maxlength="60" style="width:250px; border:1px solid #999999" />
				</td>
		</tr>
		</frame>

		<tr>
				<td colspan="2" align="center">
					<br />
					<table border="0" cellpadding="0" cellspacing="0">
						<tr valign="top">
					</table>
					<input type="submit" name="addNewSkill" value="Add Another" />
				</td>
				<td colspan="2" align="center">
					<br />
					<table border="0" cellpadding="0" cellspacing="0">
						<tr valign="top">
					</table>
					<input type="submit" name="addNewSkill" value="Save & Next" />
				</td>
		</tr>		
</table>	
</form>
</body>
</html>