<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@page import="cometClasses.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Job</title>
<link rel="stylesheet" type="text/css" href="./ccpstyle.css">

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
\
</head>
<body>
<center><h1 style="font-size:300%"   style="text-align:center">SEARCH JOB</h1></center>


<form class="studentReg" method="post" action="searchProfileServlet">

   <center>  <input type="text" id="profileSearch" name="profileSearch" style="width=100%;" /></center> 






   
   <br>   <input type="submit" value="Submit" /></center>
    </form>








</body>
</html>