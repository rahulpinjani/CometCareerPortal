package cometCareer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cometClasses.*;

@WebServlet(description = "Servlet for company Registration", urlPatterns = { "/companyRegistrationServlet" })
public class companyRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;

       
    public companyRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 Company com= new Company();
		Random rm = new Random ();
// Getting the objects from the registration Form JSp		
		String companyName = request.getParameter("companyName");
		String description = request.getParameter("companyDescription");
		String location = request.getParameter("companylocation");
		String website = request.getParameter("website");
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		HttpSession session = request.getSession(true);
		
		com.setName(companyName);
		com.setDescription(description);
		com.setLocation(location);
		com.setWebsite(website);
		com.setUsername(username1);
		com.setPassword(password1);
		
		getDBConnection(request,response);
		try {
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("INSERT INTO company(company_id,name,description,location,website,username,password) values (?,?,?,?,?,?,?)"); 
			
			ps.setInt(1, rm.nextInt(15000));
			ps.setString(2,companyName);
			ps.setString(3, description);
			ps.setString(4,location);
			ps.setString(5,website);
			ps.setString(6, username1);
			ps.setString(7, password1);
			
			ps.executeUpdate();
			
			session.setAttribute("company", com);
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/companyHome.jsp");
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
