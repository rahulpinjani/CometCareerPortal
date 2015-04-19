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
import com.mysql.jdbc.Statement;
import cometClasses.*;

@WebServlet("/ProjectDetailServlet")
public class ProjectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
	private int id;
       
    public ProjectDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
// Getting the objects from the registration Form JSp

		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String project_domain=request.getParameter("domain");
		String prog_langauages=request.getParameter("languages");
		String database_used=request.getParameter("database");
		String tools_frameworks=request.getParameter("tools");
		String teamsize=request.getParameter("teamsize");
		HttpSession session=request.getSession();
		String query = null;
		int id2=0;
		
		String role=(String)session.getAttribute("role");

		if(role.equals("Student")) {
			Student stud=(Student)session.getAttribute("student");
			id2= stud.getID();
			query="INSERT INTO STUDENT_PROJECTS(student_id,project_id) VALUES(?,?)";
		} 
		if(role.equals("Professor")) {
			Professor prof=(Professor)session.getAttribute("professor");
			id2= prof.getID();
			query="INSERT INTO PROJECTS_PROFESSOR(professor_id,project_id) VALUES(?,?)";			
		}
		
		String keyPressed = request.getParameter("addProject");
		
//Database Insertion
		getDBConnection(request,response);
		try {
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("INSERT INTO PROJECTS(project_title,project_description,project_domain,prog_lang,database_used,team_size,tools) VALUES (?,?,?,?,?,?,?)"); 
			
			
			ps.setString(1,title);
			ps.setString(2,description);
			ps.setString(3,project_domain);
			ps.setString(4,prog_langauages);
			ps.setString(5,database_used);
			ps.setString(6,teamsize);
			ps.setString(7,tools_frameworks);
			ps.executeUpdate();
			
			Statement stmt = (Statement) con.createStatement();
			rs= stmt.executeQuery("SELECT COALESCE(MAX(project_id),0) AS id FROM PROJECTS");	
			while(rs.next()) {
				id = rs.getInt("id");
			}
			ps=(PreparedStatement)con.prepareStatement(query);
			ps.setInt(1, id2);
			ps.setInt(2, id);
			ps.executeUpdate();
			
			if(session.getAttribute("page").equals("UpdateProfile")) {
				if(keyPressed.equals("Save & Next")) {

					RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/updateProfile.jsp");
					dispatch.forward(request, response);								
					
				} else {
					
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/projectDetails.jsp");
					dispatch.forward(request, response);				
				}			
				
			} else {
				if(keyPressed.equals("Save & Next")) {
	
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/addNewSkill.jsp");
					dispatch.forward(request, response);								
					
				} else {
					
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/projectDetails.jsp");
					dispatch.forward(request, response);				
				}			
			}
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
