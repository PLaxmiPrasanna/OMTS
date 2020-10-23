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

import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.BookingServiceImpl;
import com.cg.omts.service.CancellingServiceImpl;
import com.cg.omts.service.IBookingService;
import com.cg.omts.service.ICancellingService;
import org.apache.log4j.Logger;

@WebServlet("/CancelBookingController")
public class CancelBookingController extends HttpServlet {
	final static Logger LOGGER = Logger.getLogger(CancelBookingController.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		System.out.println(ticketId+"jnsdd");
		ICancellingService cancellingService = new CancellingServiceImpl();
		IBookingService bookingService = new BookingServiceImpl();
		RequestDispatcher dispatcher = null;
		int isDeletedBooking = 0, isSeatDeleted = 0, isDeletedTransaction = 0, isDeletedSeatDetails = 0, isCancelled = 0, isRefunded = 0, isDeletedUser = 0;;
		List<Integer> seatsList = new ArrayList<Integer>();
		Transaction transaction = null;
		int currentBalance = 0;
		try {
			
			isDeletedBooking = cancellingService.deleteBookingDetails(ticketId);
			seatsList = cancellingService.getSeatsByTicket(ticketId);
			isSeatDeleted = cancellingService.deleteAllocatedSeats(ticketId);
			isDeletedSeatDetails = cancellingService.deleteSeatDetails(seatsList);
			transaction = cancellingService.getTransactionDetails(ticketId);
			isDeletedTransaction = cancellingService.deleteTransaction(ticketId);
			isDeletedUser = cancellingService.deleteTicketFromUser(ticketId);
			isCancelled = cancellingService.cancelTicket(ticketId);
			
			currentBalance = bookingService.getCurrentBalance(transaction);
			isRefunded = cancellingService.refundAfterCancellation(transaction, currentBalance);
			LOGGER.info("Cancelling and refund successful");
			request.setAttribute("message", "Successfully cancelled the ticket Id : "+ ticketId+"and refunded");
			dispatcher = request.getRequestDispatcher("ViewBookingController");
			dispatcher.forward(request, response);
			
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Exception occurred");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
