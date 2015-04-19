<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ page import="cometClasses.Department"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Home</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
</head>
<%
	HttpSession session = request.getSession();
	Department dept = (Department)session.getAttribute("department");
	session.setAttribute("role", "Department");
%>
<body>
<h2 class="departmentHome"><br />&nbsp;Welcome Department of <%=dept.getDepartmentName()%>,</h2>
<div align="center" class="navButtons">
	<table>
		<tr>
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
			<td>
				<form class="transparent" method="post" action="approvePostServlet">
					<input type="submit" name="approvePostButton" value="Aprrove Job Post">
				</form>
			</td>		
			<td>
				<form class="transparent" method="post" action="LogoutServlet">
					<input type="submit" name="Logout" value="Logout">
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
</html>