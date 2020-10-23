package com.cg.omts.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.BookingServiceImpl;
import com.cg.omts.service.IBookingService;

import org.apache.log4j.Logger;
@WebServlet("/paymentController")
public class PaymentController extends HttpServlet{
	final static Logger LOGGER = Logger.getLogger(PaymentController.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub.
		PrintWriter out = resp.getWriter();
		RequestDispatcher dispatcher = null;
		IBookingService bookingService = new BookingServiceImpl();
		int accountNo=Integer.parseInt(req.getParameter("acc"));
		int cvv =Integer.parseInt(req.getParameter("cvv"));
		String password=req.getParameter("pass");
		int ticketId = Integer.parseInt(req.getParameter("ticketId"));
		int theatreId = Integer.parseInt(req.getParameter("theatreId"));
		int screenId = Integer.parseInt(req.getParameter("screenId"));
		int showId = Integer.parseInt(req.getParameter("showId"));
		int movieId = Integer.parseInt(req.getParameter("movieId"));
		int totalCost = Integer.parseInt(req.getParameter("totalPrice"));
		
		int currentBalance = 0;
		String movieName = "", theatreName = "", screenName = "", showName = "";
		try {
			
			Boolean flag= bookingService.validatePayment(accountNo, cvv, password);
			if(flag==true) {
				LOGGER.info("Validated credentials");
				int transactionId = GenerateIds.getTransactionId();
				int bookingId = GenerateIds.getBookingId();
				LOGGER.info("Transaction id generated");
				System.out.println("Transaction Id generated id: "+transactionId);
				Transaction transaction = new Transaction(transactionId, accountNo, totalCost);
				System.out.println("Transaction obj in paymentprocess: " + transaction);
				currentBalance = bookingService.getCurrentBalance(transaction);
				int isTransact= bookingService.addTransaction(transaction, ticketId);
				int isdeducted = bookingService.makePayment(accountNo, currentBalance, totalCost);
				LOGGER.info("Payment made");
				System.out.println("is Transaction done: "+ isTransact);
				Date todayDate = new Date(System.currentTimeMillis());
				System.out.println("Today's date : "+ todayDate);
				
				Booking booking = new Booking(bookingId, todayDate);
				int isBooked = bookingService.addBooking(booking, ticketId, transactionId);
				
				if(isBooked > 0) {
					bookingService.setTicketStatus(ticketId, "BOOKED");			
					List<Integer> seatList =  bookingService.getSeatsByTicket(ticketId);
					int seatListLength = seatList.size();
					
					for(Integer seatId: seatList) {
						bookingService.setSeatStatus(seatId, "BOOKED");
		
					}
					movieName = bookingService.getMovieDetails(movieId).getMovieName();
					theatreName = bookingService.getTheatreName(theatreId);
					screenName = bookingService.getScreenName(screenId);
					showName = bookingService.getShowName(showId);
					req.setAttribute("ticketId", ticketId);
					req.setAttribute("booking", booking);
					req.setAttribute("transaction", transaction);
					req.setAttribute("movieName", movieName);
					req.setAttribute("theatreName", theatreName);
					req.setAttribute("screenName", screenName);
					req.setAttribute("showName", showName);
					req.setAttribute("message", "payment successful");
					dispatcher = req.getRequestDispatcher("bookingConfirmation.jsp");
					
					dispatcher.forward(req, resp);
				}
			}else {
				LOGGER.info("Invalid Credentials");
				req.setAttribute("message", "Invalid Credentials");
				req.setAttribute("totalPrice", totalCost);
				req.setAttribute("ticketId", ticketId);
				
				req.setAttribute("movieId", movieId);
				req.setAttribute("theatreId", theatreId);
				req.setAttribute("screenId", screenId);
				req.setAttribute("showId", showId);
				dispatcher = req.getRequestDispatcher("payment1.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Exception occured");
		}		
	}
}
