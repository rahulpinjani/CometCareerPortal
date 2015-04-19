package cometCareer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;






import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import cometClasses.*;

@WebServlet(description = "Servlet for the storing the student Registration information", urlPatterns = { "/searchProfileServlet" })
public class searchProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String username="root";
	protected static String password="1234Hjkl";
	protected static  String dbname="CometCareerPortal";
	protected static  String driver="com.mysql.jdbc.Driver";
	protected static  Connection con;
	protected static  ResultSet rs;
	protected static  String url="jdbc:mysql://localhost:3306/"+dbname;
       
	Map<Integer,Integer>studSkillSet;
    List<Entry<Integer, Integer>> list;
    public searchProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
        studSkillSet=new HashMap<Integer,Integer>();
        list=null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("oraganization");
		HttpSession session = request.getSession();
	DisplayProfiles dp=new DisplayProfiles();
		  // String selectedValue[]=request.getParameterValues("options");
	ArrayList<DisplayProfiles> profileList = new ArrayList<DisplayProfiles>(); 
			String query="select * from Skills";
			getDBConnection(request, response);
			try {
					PreparedStatement ps=(PreparedStatement)con.prepareStatement(query);
					ps.setString(1, title);
					
				
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next())
					{
					Skills sk = new Skills();
					int candidateID=rs.getInt(5);
				
					int proficiency=rs.getInt(4);
					int numberOfYears=rs.getInt(3);
					int total=proficiency*numberOfYears;
					studSkillSet.put(candidateID, total);
					}
					
					
				    Set<Entry<Integer, Integer>> set = studSkillSet.entrySet();
			    list= new ArrayList<Entry<Integer, Integer>>(set);
			        Collections.sort( list, new Comparator<Map.Entry<Integer, Integer>>()
			        {
			            public int compare( Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2 )
			            {
			                return (o2.getValue()).compareTo( o1.getValue() );
			            }
			        } );
			        
			        
			    	

					 for(Map.Entry<Integer, Integer> entry:list){
						 String query1="select * from Student where student_id=?";
							PreparedStatement ps1=(PreparedStatement)con.prepareStatement(query1);
							ps1.setInt(1,entry.getKey().intValue());
							
							ResultSet rs1=ps1.executeQuery();
							
							dp.setId(rs1.getInt(1));
							dp.setFirstName(rs1.getString(2));
							dp.setLastName(rs1.getString(3));
							dp.setMajor(rs1.getString(4));
							dp.setContact(rs1.getInt(5));
							dp.setEmail(rs1.getString(6));
							dp.setAddress(rs1.getString(7));
							dp.setTotal(entry.getValue());
							
							profileList.add(dp);
				        }
					
			} catch(SQLException e) {
				System.out.println("SQL Syntax Error..!!!");
				e.printStackTrace();			
			}						
		session.setAttribute("profile", profileList);
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/profileResults.jsp");
			dispatch.forward(request, response);
			
			
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