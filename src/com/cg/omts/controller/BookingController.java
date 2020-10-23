package com.cg.omts.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Screen;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.BookingServiceImpl;
import com.cg.omts.service.IBookingService;
import org.apache.log4j.Logger;
@WebServlet("/BookingController")
public class BookingController extends HttpServlet{
	 final static Logger LOGGER = Logger.getLogger(BookingController.class);
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
		IBookingService bookingService = new BookingServiceImpl();
		List<Screen> screenList = null;
		try {
			int theatreId = Integer.parseInt(request.getParameter("theatreId"));
			
			int movieId = Integer.parseInt(request.getParameter("movieId"));
			if(theatreId != -1) {
				screenList = new ArrayList<Screen>();
				screenList = bookingService.getScreenByTheatreId(theatreId);
			}
			request.setAttribute("theatreId", theatreId);
			request.setAttribute("screenList", screenList);
			request.setAttribute("movieId", movieId);
			dispatcher = request.getRequestDispatcher("booking.jsp");
			dispatcher.forward(request, response);
		}catch(OMTSException e) {
			LOGGER.warn("Exception occured");
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}
