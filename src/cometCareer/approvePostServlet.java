package cometCareer;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import cometClasses.*;

@WebServlet(description = "Servlet to display all pending posts that needs to be approved by the admin", urlPatterns = { "/approvePostServlet" })
public class approvePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
       
	public approvePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query="SELECT job_id,title,description,job_type,author_id FROM JOB WHERE status='P'";
		ArrayList<Job> jobList = new ArrayList<Job>();
		HttpSession session = request.getSession();
		getDBConnection(request,response);
		try {
				Statement stmt = (Statement)con.createStatement();
				rs=stmt.executeQuery(query);
				int trav=0;
				while(rs.next()) {
					Job job1 = new Job();
					
					job1.setJob_id(rs.getInt(1));
					job1.setTitle(rs.getString(2));
					job1.setDescription(rs.getString(3));
					job1.setJob_type(rs.getString(4));
					job1.setAuthor_id(rs.getInt(5));
					jobList.add(job1);
				}
				
				session.setAttribute("jobList", jobList);
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/approvePost.jsp");
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
