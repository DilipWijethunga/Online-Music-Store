package com.oop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Cart;
import com.oop.service.CartDAO;
import com.oop.service.CartDAOImpl;


@WebServlet("/CartControllerServlet")
public class CartControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//ref variable for cart DAO
	CartDAO cartDAO = null;
	
	//initialize cart DAO and constructor 
	public CartControllerServlet() {
		cartDAO = new CartDAOImpl();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// call DAO method to get cart list
		List<Cart> list = cartDAO.get();
		
		// add cart to request object
		request.setAttribute("list", list);
		
		//request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
		
		//forward request and response 
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
