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

@WebServlet(description = "Servlet for the storing the student Registration information", urlPatterns = { "/studentRegistrationServlet" })
public class studentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
       
    public studentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student stud= new Student();
		
// Getting the objects from the registration Form JSp
		String firstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String major = request.getParameter("Major");
		String studentType = request.getParameter("StudentType");
		String email = request.getParameter("email");
		String phone = request.getParameter("CellPhone");
		String StreetAddress1 = request.getParameter("StreetAddress1");
		String StreetAddress2 = request.getParameter("StreetAddress2");
		String City = request.getParameter("City");
		String State = request.getParameter("State");
		String Zip = request.getParameter("Zip");
		String mailingAddress = StreetAddress1 +" "+ StreetAddress2 + " "+ City +" "+ State +" "+ Zip;
		String username1 = request.getParameter("username");
		String password1 = request.getParameter("password");
		HttpSession session = request.getSession(true);	
		
//Setting the parameters for the student object that we need to pass to the next jsp 
		stud.setFirstName(firstName);
		stud.setLastName(LastName);
		stud.setMajor(major);
		stud.setEmail(email);
		stud.setContactNumber(phone);
		stud.setMailingAddress(mailingAddress);		
		stud.setUsername(username1);
		stud.setPassword(password1);
		
//Database Insertion
		getDBConnection(request,response);
		try {
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("INSERT INTO student(first_name,last_name,major,contact_number,email,mailing_address,username,password,StudentType) values (?,?,?,?,?,?,?,?,?)"); 
			ps.setString(1,firstName);
			ps.setString(2, LastName);
			ps.setString(3,major);
			ps.setString(4,phone);
			ps.setString(5,email);
			ps.setString(6,mailingAddress);
			ps.setString(7,username1);
			ps.setString(8,password1);
			ps.setString(9,studentType);
			ps.executeUpdate();
			
			Statement stmt = (Statement) con.createStatement();
			rs= stmt.executeQuery("SELECT COALESCE(MAX(student_id),0) AS id FROM STUDENT");	
			while(rs.next()) {
				stud.setID(rs.getInt(1));
			}			
			session.setAttribute("student", stud);
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
