package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Customers;
import com.oop.service.CustomerServiceImpl;
import com.oop.service.ICustomerService;

/**
 * Update customers servlet
 */
public class UpdateCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Customers customer = new Customers();
		String customerID = request.getParameter("customerID");	
		customer.setCustomerID(customerID);
		customer.setCustomerName(request.getParameter("customerName"));
		customer.setCustomerEmail(request.getParameter("CustomerEmail"));
		customer.setCustomerPhone(request.getParameter("customerPhone"));
		customer.setCustomerAddress(request.getParameter("customerAddress"));
		customer.setGender(request.getParameter("gender"));
		customer.setUserName(request.getParameter("UserName"));
		customer.setPassword(request.getParameter("password"));
		
		ICustomerService iCustomerService = new CustomerServiceImpl();
		iCustomerService.updateCustomers(customerID, customer);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListCustomers.jsp");
		dispatcher.forward(request, response);
	}

}
