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
<% 
	HttpSession sess = request.getSession();
	ArrayList<Skills> sk= (ArrayList<Skills>)sess.getAttribute("skill");
%>
</head>
<body>
<center><h1 style="font-size:300%"   style="text-align:center">SEARCH JOB</h1></center>


<form class="studentReg" method="post" action="GetSearchResults">

   <center>  <input type="text" id="organization" name="organization" style="width=100%;" /></center> 

<table border=5 cellpadding="4" cellspacing="2">
<select name="skillDropDown1" size="3"  tabindex="1"> 
<% for(int i=0; i<sk.size(); i++) { %> 
           
        <option value="+sk.get(i).getSkillName()+">"+sk.get(i).getSkillName()+"</option>   
          
       
           
      
<% } %>	

</select>


</table>




  <BR><center> <table>
 <tr> <td> <input type="radio" name="type" value="Summer"> Summer Internship</td>
    <td> <input type="radio" name="type" value="Fall"> Fall Internship</td>
<td> <input type="radio" name="type" value="Spring"> Spring</td>
 <td> <input type="radio" name="type" value="FullTime"> Full- time </td></tr>
 
</table>
   <BR>
   <BR>   <input type="submit" value="Submit" /></center>
    </form>








</body>
</html>