package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.IScreenShowService;
import com.cg.omts.service.MovieTheatreServiceImpl;
import com.cg.omts.service.ScreenShowServiceImpl;
import org.apache.log4j.Logger;

@WebServlet("/SelectTheatreIdDetails")
public class SelectTheatreIdDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger LOGGER = Logger.getLogger(MovieDetailsController.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
		IScreenShowService screenShowService = new ScreenShowServiceImpl();
		
		String theatreCity = request.getParameter("theatreCity");
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));
		LOGGER.info("Theatre ID in SelectTheatreScreenIdDetails Controller");
		System.out.println("Theatre ID in SelectTheatreScreenIdDetails Controller" + theatreId);
		Boolean isAdded = false, isPriceAdded = false;
		
		ServletContext context=getServletContext();
		Screen screen = (Screen)context.getAttribute("screen");
		int seatPrice = Integer.parseInt(request.getParameter("seatPrice"));
		
		PrintWriter out = response.getWriter();
		String message;
		try {
			if(movieTheatreService.isTheatreIdExists(theatreId) && movieTheatreService.checkTheatreIdInCity(theatreId, theatreCity)) {
				isAdded = screenShowService.addScreen(screen, theatreId);
				
				int screenId = screen.getScreenId();
				LOGGER.info("screenid and theatreid are added to admin");
				System.out.println("Screen Id : "+screenId+"\nSeat price = "+seatPrice);
				isPriceAdded = screenShowService.addScreenSeatPrice(screenId, seatPrice);
				if(isAdded && isPriceAdded) {
					LOGGER.info("Screen details successfully added");
					message = "Successfully added screen details with ID: "+ screen.getScreenId();
					request.setAttribute("message", message);
					request.getRequestDispatcher("addScreen.jsp").forward(request, response);
				} else {
					LOGGER.info("FAiled to add screen details");
					message = "Failed to add Screen details with ID: "+screen.getScreenId();
					request.setAttribute("message", message);
					request.getRequestDispatcher("addScreen.jsp").forward(request, response);
				}
			} else {
				LOGGER.info("Valid theatreid not added");
				message = "Enter valid theatre ID";
				request.setAttribute("message", message);
				request.getRequestDispatcher("addScreen.jsp").forward(request, response);
			}
		} catch (OMTSException e) {
			LOGGER.warn("Exception occured");
			System.out.println("Couldn't add the details\n" + e);
			
		}
	}

}
