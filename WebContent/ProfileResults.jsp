<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@page import="cometClasses.*"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>

<% 
	HttpSession session = request.getSession();
	ArrayList<DisplayProfiles> p= (ArrayList<DisplayProfiles>)session.getAttribute("profileList");
%> 
<body>
<table border=5 cellpadding="4" cellspacing="2">
	<tr>
		<td><b>Id</b></td>
		<td><b>FName</b></td>
		<td><b>LName</b></td>
		<td><b>Major</b></td>
		<td><b>Contact</b></td>
		<td><b>Email</b></td>
		
			<td><b>Total</b></td>
	</tr>
<% for(int i=0; i<p.size(); i++) { %> 
        <tr>      
            <td><%=p.get(i).getId() %></td>
            <td><%=p.get(i).getFirstName()%></td>
            <td><%=p.get(i).getLastName()%></td>
            <td><%=p.get(i).getContact()%></td>
            <td><%=p.get(i).getEmail()%></td>
            <td><%=p.get(i).getTotal()%></td>
        </tr>
<% } %>	
</table>
</body>
</html>