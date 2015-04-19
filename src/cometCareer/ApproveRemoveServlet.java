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

import cometClasses.Job;

@WebServlet("/ApproveRemoveServlet")
public class ApproveRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
       
    public ApproveRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] post=request.getParameterValues("postCheckBox");
		HttpSession session = request.getSession();
		ArrayList<Job> job= (ArrayList<Job>)session.getAttribute("jobList");
		String query=null;
		String keyPressed = request.getParameter("approvepost");
		getDBConnection(request,response);
		try {
			
			if(keyPressed.equals("Aprrove")) {
				query="UPDATE JOB SET status='A' WHERE job_id=?";
				PreparedStatement ps = (PreparedStatement)con.prepareStatement(query);				
				for (int i=0;i < post.length;i++) {
                    int job_id = job.get(Integer.parseInt((post[i]))).getJob_id();
                    ps.setInt(1, job_id);
                    ps.executeUpdate();
				}
			}  else {
				query="DELETE FROM JOB WHERE job_id=?";
				PreparedStatement ps = (PreparedStatement)con.prepareStatement(query);
				for (int i=0;i < post.length;i++) {
                    int job_id = job.get(Integer.parseInt((post[i]))).getJob_id();
                    ps.setInt(1, job_id);
                    ps.executeUpdate();
				}
			}
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/departmentHome.jsp");
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
