package com.oop.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Songs;
import com.oop.util.SongDisplayDBUtil;




@WebServlet("/DisplaySongsServlet")
public class DisplaySongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String itemid = request.getParameter("id");
		
		try {
			List<Songs> songDetails = SongDisplayDBUtil.validate(itemid);
			request.setAttribute("songDetails", songDetails);
		
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("songdetails.jsp");
		dis.forward(request, response);
	}
	
}






