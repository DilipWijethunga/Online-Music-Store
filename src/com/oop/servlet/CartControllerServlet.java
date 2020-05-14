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
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
		public void getCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("itemid");
			Cart cart = cartDAO.get(Integer.parseInt(id));
			request.setAttribute("cart", cart);
			
			
			//request dispatcher
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			
			//forward request and response 
			dispatcher.forward(request, response);
		}
	
		

}
