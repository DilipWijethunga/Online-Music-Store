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
import com.oop.util.SearchDBUtil;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter("srchtext");

		try {
				List<Songs> searchPage = SearchDBUtil.search(search);
				request.setAttribute("searchResult", searchPage);
		}

		catch(Exception e) {
			e.printStackTrace();
		} 



		RequestDispatcher display = request.getRequestDispatcher("search.jsp");
		display.forward(request, response);
		}

}


