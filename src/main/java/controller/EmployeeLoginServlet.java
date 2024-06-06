package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginValidate;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//XML - DD - Deployment Descriptor
	//Server status code -- 404(Resource not found), 500(Internal server), 405(method mismatch)
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("eid"));
		String password = request.getParameter("epwd");
		LoginValidate lv = new LoginValidate();
		try {
			boolean status = lv.checkLogin(id, password);
			request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("/LoginSuccess.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
