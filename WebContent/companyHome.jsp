<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@page import="cometClasses.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Home</title>
</head>
<%
	HttpSession session = request.getSession();
	Company comp = (Company)session.getAttribute("company");
	session.setAttribute("role", "Company");
%>
<body>
<h2>Welcome <%=comp.getName()%>,</h2><br>
<div align="center" class="navButtons">
<table>
	<tr>
		<form class="transparent" method="post" action="postJob.jsp">
			<input type="submit" name="postJobButton" value="Post Job">
		</form>
	</tr>
	<tr>
		<form class="transparent" method="post" action="updateCompanyProfile.jsp">		
			<input type="submit" name="updateProfileButton" value="Update Profile">
		</form>
	</tr>
	<tr>
		<form class="transparent">
			<input type="submit" name="searchProfileButton" value="Search Profile">
		</form>
	</tr>
	<tr>
		<form class="transparent" method="post" action="LogoutServlet">
			<input type="submit" name="Logout" value="Logout">
		</form>
	</tr>
</table>
</div>
<center>
<h2>Company Description</h2>
<table border="2">
	<tr>
		<td>Company Id: </td>
		<td><%=comp.getId()%></td>
	</tr>
	<tr>
		<td>Name: </td>
		<td><%=comp.getName()%></td>
	</tr>
	<tr>
		<td>Description: </td>
		<td><%=comp.getDescription()%></td>
	</tr>
	<tr>
		<td>Location: </td>
		<td><%=comp.getLocation()%></td>
	</tr>
	<tr>
		<td>Website: </td>
		<td><a href="<%=comp.getWebsite()%>"><%=comp.getWebsite()%></a></td>
	</tr>
</table>
</center>
</body>
</html>