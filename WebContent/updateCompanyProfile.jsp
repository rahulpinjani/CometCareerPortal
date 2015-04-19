<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@page import="cometClasses.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
<title>Update Profile</title>
</head>
<%
	HttpSession session = request.getSession();
	Company comp = (Company)session.getAttribute("company");
	session.setAttribute("role", "Company"); 
%>
<body>
<h1><center>Organization Center</center></h1>
<h2><center>Update Profile</center></h2>
<form class="companyReg" method="post" action="updateCompProfileServlet">
<table>
	<tr>
		<td align="left"><b>Name:</b></td>
		<td><input id="companyName" name="companyName" type="text" maxlength="200" value="<%=comp.getName()%>" style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td valign="top"><b>Description:</b></td>
		<td><textarea id="companyDescription" name="companyDescription" rows="6" cols="50" style="width: 298px;"><%=comp.getDescription()%></textarea>
	</tr>
	<tr>
		<td><b>Company Location:</b></td>
		<td><input id="companylocation" name="companylocation" type="text" maxlength="200" value="<%=comp.getLocation()%>"  style="width:300px; border:1px solid #999999" /></td>
	</tr>
	<tr>
		<td><b>Website:</b></td>
		<td><input id="website" name="website" type="url" maxlength="200" value="<%=comp.getWebsite()%>" style="width:300px; border:1px solid #999999" /></td>
	</tr>
</table>
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
</body>
</html>