package com.oop.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Forgot
 */
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:mysql://localhost:3306/oop";
		String user="root";
		String pass="root";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			String email=request.getParameter("email");
			String Pass =request.getParameter("Pass");
			
			PreparedStatement ps = conn.prepareStatement("update forgot123 set password=? where email=?");
			ps.setString(2 ,email);
			ps.setString(1, Pass);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				
				response.sendRedirect("update.jsp");
				}
			
			else{
				response.sendRedirect("error.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
