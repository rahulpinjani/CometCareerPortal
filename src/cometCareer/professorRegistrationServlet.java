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

import com.mysql.jdbc.Statement;

import cometClasses.*;

@WebServlet(description = "Servlet for registering the prfessor", urlPatterns = { "/professorRegistrationServlet" })
public class professorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
       
    public professorRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Professor prof = new Professor();
		Random rm = new Random();
		String query = "INSERT INTO professor(first_name,last_name,"
				+ "professor_qualification,research_interest,contact_number,email,office_address,username,password)"
				+ " values (?,?,?,?,?,?,?,?,?)";
// Getting the objects from the registration Form JSp		
		String firstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String qualification = request.getParameter("qualification");
		String ResearchInterest = request.getParameter("researchInterest");
		String email = request.getParameter("EmailAddress");
		String phone = request.getParameter("CellPhone");
		String officeAddress = request.getParameter("officeAddress");
		String department = request.getParameter("department");
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		HttpSession session = request.getSession(true);
		
//Setting the parameters for the student object that we need to pass to the next jsp
		prof.setFirstName(firstName);
		prof.setLastName(LastName);
		prof.setQualification(qualification);
		prof.setContactNumber(phone);
		prof.setEmail(email);
		prof.setMailingAddress(officeAddress);
		prof.setResearchInterest(ResearchInterest);
		prof.setUsername(username1);
		prof.setPassword(password1);

		//Database Insertion
				getDBConnection(request,response);
				try {
					PreparedStatement ps=(PreparedStatement)con.prepareStatement(query); 
					
					
					ps.setString(1,firstName);
					ps.setString(2, LastName);
					ps.setString(3,qualification);
					ps.setString(4,ResearchInterest);
					ps.setString(5,phone);
					ps.setString(6,email);
					ps.setString(7,officeAddress);
					ps.setString(8,username1);
					ps.setString(9,password1);
					
					ps.executeUpdate();

					Statement stmt = (Statement) con.createStatement();
					rs= stmt.executeQuery("SELECT COALESCE(MAX(professor_id),0) AS id FROM PROFESSOR");	
					while(rs.next()) {
						prof.setID(rs.getInt(1));
					}											
					session.setAttribute("professor", prof);
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/projectDetails.jsp");
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
