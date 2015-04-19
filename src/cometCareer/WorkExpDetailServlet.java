package cometCareer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cometClasses.Professor;
import cometClasses.Student;

@WebServlet(description = "Inserting work experience details for Student;", urlPatterns = { "/WorkExpDetailServlet" })
public class WorkExpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
	
       
    public WorkExpDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
// Getting the objects from the registration Form JSp
		String employer=request.getParameter("employer");
		String yearsExp=request.getParameter("yearsExp");
		String designation = request.getParameter("designation");
		int id2=0;
	
		HttpSession session=request.getSession();
		String role=(String)session.getAttribute("role");
		System.out.println(role);
		if(role.equals("Student")) {
			Student stud=(Student)session.getAttribute("student");
			id2= stud.getID();
		} 
		if(role.equals("Professor")) {
			Professor prof=(Professor)session.getAttribute("professor");
			id2= prof.getID();				
		}

		String keyPressed = request.getParameter("addWorkExp");
		if ((keyPressed.equals("Save & Next"))|| keyPressed.equals("Add Another")) {
			//Database Insertion
			getDBConnection(request,response);
			try {
				PreparedStatement ps=(PreparedStatement)con.prepareStatement("INSERT INTO EMPLOYMENT_DETAILS(employer,years_of_exp,company_designation,student_id) VALUES(?,?,?,?)"); 
				ps.setString(1,employer);
				ps.setString(2,yearsExp);
				ps.setString(3,designation);
				ps.setInt(4, id2);
				ps.executeUpdate();
				
				if(session.getAttribute("page").equals("UpdateProfile")) {
					if(keyPressed.equals("Save & Next")) {
						RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/updateProfile.jsp");
						dispatch.forward(request, response);						
					} else {
						
						RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/workExperience.jsp");
						dispatch.forward(request, response);				
					}								
				} else {
					if(keyPressed.equals("Save & Next")) {
		
						if(role.equals("Student")) {
							RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/studentHome.jsp");
							dispatch.forward(request, response);
						} else {
							RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/professorHome.jsp");
							dispatch.forward(request, response);						
						}
						
					} else {
						
						RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/workExperience.jsp");
						dispatch.forward(request, response);				
					}			
				}
			} catch(SQLException e) {
				System.out.println("SQL Syntax Error..!!!");
				e.printStackTrace();			
			}		
		}  else {	
			if(role.equals("Student")) {
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/studentHome.jsp");
				dispatch.forward(request, response);
			} else {
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/professorHome.jsp");
				dispatch.forward(request, response);						
			}
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
