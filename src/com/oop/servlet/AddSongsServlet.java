
package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.AddSongs;
import com.oop.service.SongServiceImpl;
import com.oop.service.ISongService;


/**
 * Servlet implementation class LoginServlet
 */
public class AddSongsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSongsServlet() {
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

		AddSongs songs = new AddSongs();
		
		songs.setSongName(request.getParameter("songName"));
		songs.setArtist(request.getParameter("artist"));
		songs.setDuration(request.getParameter("duration"));
		songs.setAlbum(request.getParameter("album"));
		songs.setGenre(request.getParameter("genre"));
		songs.setComposer(request.getParameter("composer"));
		songs.setYear(request.getParameter("year"));


		ISongService iSongService = new SongServiceImpl();
		iSongService.addSongs(songs);

		request.setAttribute("songs", songs);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListSongs.jsp");
		dispatcher.forward(request, response);
	}

}
