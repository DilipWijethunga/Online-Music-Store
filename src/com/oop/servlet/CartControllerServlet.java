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

	RequestDispatcher dispatcher = null;
	
	
	//ref variable for cart DAO
	CartDAO cartDAO = null;
	
	//initialize cart DAO and constructor 
	public CartControllerServlet() {
		cartDAO = new CartDAOImpl();
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

		
		if(action == null) {
			action ="LIST";
		}
			
			
		switch(action) {
		
			
			case "LIST": 
				cartList(request, response);
				break;
				
				
			//getting the item from cart
			case "EDIT": 
				getCartItem(request, response);
				break;
				
			//delete item
			case "DELETE": 
				deleteItem(request, response);
				break;
				
				
			default:
				cartList(request, response);
				break;
			}	
		
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String itemid = request.getParameter("itemid");
		String songid = request.getParameter("songid");
		String title = request.getParameter("title");
		String album = request.getParameter("album");
		String artist = request.getParameter("artist");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		
		Cart c = new Cart();
		
		c.setItemid(Integer.parseInt(itemid));
		c.setSongid(songid);
		c.setAlbum(album);
		c.setArtist(artist);
		c.setTitle(title);
		c.setQuantity(Integer.parseInt(quantity));
		c.setPrice(Double.parseDouble(price));
		
		
		if(cartDAO.update(c)) {
			request.setAttribute("message", "Updated!");
		}
		
		/**
		if(itemid.isEmpty() || itemid == null) {
			//save operation
			if(cartDAO.save(c)) {
				request.setAttribute("message", "Saved!");
			}
		}
		
		else{
			//updating operation
			c.setItemid(Integer.parseInt(itemid));
			
			if(cartDAO.update(c)) {
				request.setAttribute("message", "Updated!");
			}
			
			dispatcher = request.getRequestDispatcher("addtocart.jsp");
			dispatcher.forward(request, response);
		
		}**/
		
		cartList(request, response);
	}
	
		
		//cart
	public void cartList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// call DAO method to get cart list
			List<Cart> list = cartDAO.get();
			
			// add cart to request object
			request.setAttribute("list", list);
			
			//request dispatcher
			dispatcher = request.getRequestDispatcher("cart.jsp");
			
			//forward request and response 
			dispatcher.forward(request, response);
		}
		
		
	//add items manually
	public void getCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("itemid");
			Cart cart = cartDAO.get(Integer.parseInt(id));
			request.setAttribute("cart", cart);
			
			
			//request dispatcher
			dispatcher = request.getRequestDispatcher("addtocart.jsp");
			
			//forward request and response 
			dispatcher.forward(request, response);

		}
		
		
	//delete items
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("itemid");
		
		if(cartDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("message", "Record has been Deleted!");
		}
		
		cartList(request, response);
	}
		
		
		
}
