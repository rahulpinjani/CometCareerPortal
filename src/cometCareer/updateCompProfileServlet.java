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

import cometClasses.Company;

@WebServlet(description = "Updating the company Profile", urlPatterns = { "/updateCompProfileServlet" })
public class updateCompProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;	
       
    public updateCompProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String companyName = request.getParameter("companyName");
		String description = request.getParameter("companyDescription");
		String location = request.getParameter("companylocation");
		String website = request.getParameter("website");

		HttpSession session = request.getSession();
		Company com = (Company)session.getAttribute("company");
		int id = com.getId();
		
		com.setName(companyName);
		com.setDescription(description);
		com.setLocation(location);
		com.setWebsite(website);
		
		getDBConnection(request,response);
		try {
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("UPDATE COMPANY SET name=?,description=?,location=?,website=? WHERE company_id=?"); 
		
			ps.setString(1,companyName);
			ps.setString(2, description);
			ps.setString(3,location);
			ps.setString(4,website);
			ps.setInt(5, id);
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
