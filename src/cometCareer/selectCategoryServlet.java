package cometCareer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class selectCategoryServlet
 */
@WebServlet(description = "Servlet to select the category prior to the registration of the candidate", urlPatterns = { "/selectCategoryServlet" })
public class selectCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("Category");
		if(category.equals("Student")) {
			RequestDispatcher requestObject = request.getRequestDispatcher("/studentRegistration.jsp");
			requestObject.forward(request, response);
			
		} else if (category.equals("Professor")) {
			RequestDispatcher requestObject = request.getRequestDispatcher("/professorRegistration.jsp");
			requestObject.forward(request, response);
			
		} else if (category.equals("Company")) {
			RequestDispatcher requestObject = request.getRequestDispatcher("/companyRegistration.jsp");
			requestObject.forward(request, response);
			
		} else {
			RequestDispatcher requestObject = request.getRequestDispatcher("/departmentRegistration.jsp");
			requestObject.forward(request, response);
			
		}
	}

}
