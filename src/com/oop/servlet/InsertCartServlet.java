package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.util.CartDBUtil;


@WebServlet("/InsertCartServlet")
public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String songid = request.getParameter("songid");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String album = request.getParameter("album");
		String artist = request.getParameter("artist");
		String quantity = request.getParameter("quantity");
		
		
		
		boolean isTrue;
		isTrue = CartDBUtil.Insertcart(songid, title, price, album, artist, quantity);
			
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}
