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
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Ticket.TicketStatus;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.BookingServiceImpl;
import com.cg.omts.service.IBookingService;
import org.apache.log4j.Logger;

@WebServlet("/ProceedToPayController")
public class ProceedToPayController extends HttpServlet {
	final static Logger LOGGER = Logger.getLogger(MovieDetailsController.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IBookingService bookingService = new BookingServiceImpl();
		RequestDispatcher dispatcher = null;
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int theatreId = Integer.parseInt(request.getParameter("theatreId"));		
		int screenId = Integer.parseInt(request.getParameter("screenId"));
		int showId = Integer.parseInt(request.getParameter("showId"));
		int noOfSeats = Integer.parseInt(request.getParameter("noOfSeats"));
		int price = Integer.parseInt(request.getParameter("seatPrice"));
		int ticketId = GenerateIds.getTicketId();
		System.out.println(ticketId);
		List<Integer> selectedSeatsList = new ArrayList<Integer>();
		int seatStartId = GenerateIds.getSeatId();
		System.out.println(seatStartId);
		LOGGER.info("Ticket Id generated");
		for(int seats = 0; seats < noOfSeats; seats++) {
			selectedSeatsList.add(seatStartId++);
		}
		LOGGER.info("Selected seats list generated");
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("username");
		try {
			Ticket ticket = new Ticket(ticketId, noOfSeats, TicketStatus.INPROCESS, screenId, theatreId, showId, movieId);	
			int isGenerated = bookingService.generateTicket(ticket);
			bookingService.assignTicketToUser(ticketId,userId);
			bookingService.allocateSeat(selectedSeatsList, screenId);
			bookingService.assignSeatsToTickets(ticketId, selectedSeatsList);
			bookingService.setTicketStatus(ticketId, "INPROCESS");
			LOGGER.info("Ticket id status set to InProcess");
			request.setAttribute("ticketId", ticketId);
			request.setAttribute("movieId", movieId);
			request.setAttribute("theatreId", theatreId);
			request.setAttribute("screenId", screenId);
			request.setAttribute("showId", showId);
			request.setAttribute("totalPrice", price*noOfSeats);
			dispatcher = request.getRequestDispatcher("payment.jsp");
			dispatcher.forward(request, response);
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Exception Occured");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
