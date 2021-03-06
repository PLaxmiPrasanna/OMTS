package com.cg.omts.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Show;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.IScreenShowService;
import com.cg.omts.service.MovieTheatreServiceImpl;
import com.cg.omts.service.ScreenShowServiceImpl;
import org.apache.log4j.Logger;

@WebServlet("/AddShowServlet")
public class AddShowController extends HttpServlet {
	final static Logger LOGGER = Logger.getLogger(AddShowController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		// IAdminService adminService = new AdminServiceImpl();
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		IScreenShowService screenShowService = new ScreenShowServiceImpl();
		int showId = Integer.parseInt(request.getParameter("showId"));
		String showName = request.getParameter("showName");
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		int screenId = Integer.parseInt(request.getParameter("screenId"));
		java.util.Date startTime, endTime;
		int finaltime = 0;
		Show show = new Show();
		String movieName = "";
		try {
			movieName = movieTheatreService.getMovieNameById(movieId);
			System.out.println(movieName + " Movie name");
		} catch (OMTSException e) {
			response.sendRedirect("adminError.jsp");
		}
		show.setMovieName(movieName);
		try {
			startTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("stime"));
			// endTime = new SimpleDateFormat("HH:mm").parse(request.getParameter("etime"));
			long t = startTime.getTime();
			// long hours = TimeUnit.MILLISECONDS.toHours(t);
			int movieLength = movieTheatreService.getMovieLength(movieId);
			;
			// System.out.println(movieLength);
			long ONE_MINUTE_IN_MILLIS = 60000;
			Date afterAddingMovieLength = new Date(t + (movieLength * ONE_MINUTE_IN_MILLIS));
			java.sql.Time showStartTime = new java.sql.Time(startTime.getTime());
			java.sql.Time showEndTime = new java.sql.Time(afterAddingMovieLength.getTime());
			// System.out.println("showstart" + showStartTime);
			// System.out.println("end time " + showEndTime);
			show.setShowId(showId);
			show.setShowName(showName);
			show.setShowStartTime(showStartTime);
			show.setShowEndTime(showEndTime);
			show.setMovieId(movieId);
			show.setTheatreId(theatreId);
			show.setScreenId(screenId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("adminError.jsp");
		} catch (OMTSException e1) {
			// TODO Auto-generated catch block
			response.sendRedirect("adminError.jsp");
		}
		try {
			String existShow = screenShowService.checkShowNameandScreenId(showName, screenId);
			System.out.println("exist show" + existShow);
			if (existShow.length() == 0) {
				System.out.println("You can enter");
			} else {
				LOGGER.info("Show already exists");
				message += "Show is already available at this time";
			}
			List<Integer> sList = screenShowService.getScreenFromMovieAndTheatre(theatreId, movieId);
			System.out.println("sList" + sList + " list contains " + sList.contains(screenId));
			if (sList.contains(screenId)) {
				System.out.println("screen is there");
			} else {
				message += "TheatreId, ScreenId and MovieId do not match";
			}
			System.out.println(sList);
			if ((sList.contains(screenId) && (existShow.length() == 0))) {
				LOGGER.info("all conditions true");
				System.out.println("all conditions true");
				int rowsInserted = screenShowService.addShow(show);
				System.out.println(rowsInserted);
				if (rowsInserted > 0) {
					LOGGER.info("Added Show Successfully");
					request.setAttribute("successMessage", "Successful inserted showId " + showId);
					RequestDispatcher rd = request.getRequestDispatcher("displayShows.jsp");
					rd.forward(request, response);
				}
			}
		} catch (OMTSException e) {
			message += "Show Id already exists";
			System.err.println(e);
			LOGGER.warn("Show alredy exists");
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("addShow.jsp");
		rd.forward(request, response);

	}

}
