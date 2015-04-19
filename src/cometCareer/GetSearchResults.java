package cometCareer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cometClasses.*;

@WebServlet(description = "Servlet for Posting a Job", urlPatterns = { "/postJobServlet" })
public class GetSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="rekon99";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
       
    public GetSearchResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Job> jobList = new ArrayList<Job>();
		HttpSession session = request.getSession();
		
//Taking Parameters from JSP
		
		String title = request.getParameter("oraganization");
	   String type=request.getParameter("type");
	   String selected=request.getParameter("skillDropDown1");
	  // String selectedValue[]=request.getParameterValues("options");
	   
		String query="select job_id,title,link from Job where title=? AND type=? AND primary_requirement=?";
		
		getDBConnection(request, response);
		try {
				PreparedStatement ps=(PreparedStatement)con.prepareStatement(query);
				ps.setString(1, title);
				ps.setString(2, type);
				ps.setString(3, selected);
			
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
	Job job1 = new Job();
					
					job1.setJob_id(rs.getInt(1));
					job1.setTitle(rs.getString(2));
					job1.setDescription(rs.getString(3));
					job1.setJob_type(rs.getString(4));
					job1.setAuthor_id(rs.getInt(5));
					jobList.add(job1);
				}
				session.setAttribute("jobList", jobList);
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher("SearchResults.jsp");
					dispatch.forward(request, response);								
				
		} catch(SQLException e) {
			System.out.println("SQL Syntax Error..!!!");
			e.printStackTrace();			
		}						
	}
	public static void getDBConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				System.out.println("Connection Error..!!!");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Error..!!!");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
