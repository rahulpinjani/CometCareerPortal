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
	ArrayList<Job> job= (ArrayList<Job>)session.getAttribute("jobList");
%>
<body>
<table border=5 cellpadding="4" cellspacing="2">
	<tr>
		<td><b>Id</b></td>
		<td><b>Title</b></td>
		<td><b>Job Type</b></td>
		<td><b>Author Id</b></td>
		<td><b>Approve</b></td>
	</tr>
<% for(int i=0; i<job.size(); i++) { %> 
        <tr>      
            <td><a href="http://localhost:8080/CometCareerPortal/jobDetailServlet"><%=job.get(i).getJob_id()%></a></td>
        
            <td><%=job.get(i).getTitle()%></td>
            <td><%=job.get(i).getLink()%></td>
            <td><%=job.get(i).getAuthor_id()%></td>
            <td><input type="checkbox" name="postCheckBox" value="<%=(i)%>"></td>
        </tr>
<% } %>	
</table>
</body>
</html>