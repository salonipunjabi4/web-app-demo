package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer id = Integer.parseInt(request.getParameter("eid"));
		String name = request.getParameter("ename");
		String password = request.getParameter("epwd");
		String email = request.getParameter("email");
		String salary = request.getParameter("esalary");
		Employee emp = new Employee(id, name, password, email, salary);
		EmployeeService eservice = new EmployeeService();
		try {
			boolean flag = eservice.save(emp);
			if(flag) {
				request.setAttribute("msg", "Data inserted successfully" + emp.getId());
				RequestDispatcher rd = request.getRequestDispatcher("/RegisterSuccess.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Data not inserted" + emp.getId());
				RequestDispatcher rd = request.getRequestDispatcher("/RegisterFailure.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
