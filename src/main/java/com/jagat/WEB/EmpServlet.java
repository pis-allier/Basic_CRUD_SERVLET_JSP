package com.jagat.WEB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jagat.DAO.EmpDetailsDao;
import com.jagat.MODEL.EmpDetails;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDetailsDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		dao = new EmpDetailsDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmpInDatabase(request, response);
				break;
			default:
				litAllEmp(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}

	}

	private void litAllEmp(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<EmpDetails> listEmp = dao.selectAllUsers();
		request.setAttribute("listEmp", listEmp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("empList.jsp");
		dispatcher.forward(request, response);// TODO Auto-generated method stub

	}

	private void insertEmpInDatabase(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String bankAcc = request.getParameter("bank account");
		String company = request.getParameter("company");
		String jobTitle = request.getParameter("job title");
		String lastName = request.getParameter("last name");
		String name = request.getParameter("name");
		String salaryParam = request.getParameter("salary");
		Optional<Double> optionsal = Optional.ofNullable(salaryParam).map(Double::parseDouble);
		double salary = optionsal.orElse(0.0);
		String pfBalanceParam = request.getParameter("pf balance");
		Optional<Double> optionalPf = Optional.ofNullable(pfBalanceParam).map(Double::parseDouble);
		double pfBalance = optionalPf.orElse(0.0);
		EmpDetails details = new EmpDetails(0l, bankAcc, company, jobTitle, lastName, name, salary, pfBalance);
		dao.insertEmp(details);
		response.sendRedirect("list");

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("empForm.jsp");
        dispatcher.forward(request, response);
	}

}
