package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.BookingServiceImpl;
import com.cg.omts.service.CancellingServiceImpl;
import com.cg.omts.service.CustomerServiceImpl;
import com.cg.omts.service.IBookingService;
import com.cg.omts.service.ICancellingService;
import com.cg.omts.service.ICustomerService;
import com.cg.omts.service.IMovieTheatreService;
import com.cg.omts.service.IScreenShowService;
import com.cg.omts.service.MovieTheatreServiceImpl;
import com.cg.omts.service.ScreenShowServiceImpl;

import static com.cg.omts.dto.Ticket.TicketStatus;

public class UserModuleTesting {


	IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl(); 
	IScreenShowService screenShowService = new ScreenShowServiceImpl(); 
	IBookingService bookingService = new BookingServiceImpl();
	ICancellingService cancellingService = new CancellingServiceImpl();
	ICustomerService customerService = new CustomerServiceImpl();
	
	@Test
	public void getMovieDetailsTest() throws OMTSException {
		try {
			Movie actualMovie = movieTheatreService.getMovieDetails(1);
			assertNotNull(actualMovie);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void generateTicketTest() throws OMTSException {
		try {
			Ticket ticket = new Ticket(1, 2, TicketStatus.BOOKED, 1, 1, 1, 1);
			int isGenerated = bookingService.generateTicket(ticket); 
			assertTrue(isGenerated > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void allocateSeatTest() throws OMTSException {
		try {
			int screenId = 1;
			List<Integer> selectedSeatsList = new ArrayList<Integer>();
			selectedSeatsList.add(1);
			selectedSeatsList.add(2);
			selectedSeatsList.add(3);
			selectedSeatsList.add(4);
			
			int isAllocated = bookingService.allocateSeat(selectedSeatsList, screenId);
			assertTrue(isAllocated > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void assignSeatsToTicketsTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> seatsList = new ArrayList<Integer>();
			seatsList.add(1);
			seatsList.add(2);
			seatsList.add(3);
			seatsList.add(4);
			
			int isAssigned = bookingService.assignSeatsToTickets(ticketId, seatsList);
			assertTrue(isAssigned > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	

	
	@Test
	public void  getSeatsByTicketTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> expectedSeatsList = new ArrayList<Integer>();
			expectedSeatsList.add(1);
			expectedSeatsList.add(2);
			expectedSeatsList.add(3);
			expectedSeatsList.add(4);
			
			List<Integer> actualSeatsList = bookingService.getSeatsByTicket(ticketId);
			assertEquals(expectedSeatsList, actualSeatsList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	
	
	@Test
	public void getTransactionDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
			//Transaction actualTransaction = new Transaction(1, 123456, 900);
			
			Transaction expectedTransaction = cancellingService.getTransactionDetails(ticketId);
			assertNotNull(expectedTransaction);
			
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteBookingDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = cancellingService.deleteBookingDetails(ticketId);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}	
	
	@Test
	public void deleteTransactionTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = cancellingService.deleteTransaction(ticketId);
			System.out.println(isDeleted);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteAllocatedSeatsTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isDeleted = cancellingService.deleteAllocatedSeats(ticketId);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void deleteSeatDetailsTest() throws OMTSException {
		try {
			List<Integer> seatsList = new ArrayList<Integer>();
			seatsList.add(1);
			seatsList.add(2);
			seatsList.add(3);
			seatsList.add(4);
			
			int isDeleted = cancellingService.deleteSeatDetails(seatsList);
			assertTrue(isDeleted > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void cancelTicketTest() throws OMTSException {
		try {
			int ticketId = 1;
						
			int isCancelled = cancellingService.cancelTicket(ticketId);
			assertTrue(isCancelled > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getCurrentBalanceTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(1, 123456, 900);
						
			int currentBalance = bookingService.getCurrentBalance(transaction);
			assertTrue(currentBalance > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void refundAfterCancellationTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(1, 123456, 900);
			int currentBalance = 24600;
			int isCancelled = cancellingService.refundAfterCancellation(transaction, currentBalance);
			assertTrue(isCancelled > 0);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getTheatresByMovieTest() throws OMTSException {
		int movieId=1;
		try {
		List<Integer> expectedTheatreList = new ArrayList<Integer>();
		expectedTheatreList.add(1);
		List<Integer> actualTheatreList = movieTheatreService.getTheatresByMovie(movieId);
		assertEquals(expectedTheatreList,actualTheatreList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void getTheatreNamesTest() throws OMTSException {
		try {
		List<Integer> theatreIdList = new ArrayList<Integer>();
		theatreIdList.add(1);
		List<String> expectedTheatreIdList = new ArrayList<String>();
		expectedTheatreIdList.add("vimal");
		List<String> actualTheatreIdList = movieTheatreService.getTheatreNames(theatreIdList);
		assertEquals(expectedTheatreIdList,actualTheatreIdList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}
	
	@Test
	public void setTicketStatusTest() throws OMTSException{
		try {
			int ticketId=1;
			String status="BOOKED";
			int expected = 1;
			int actual = bookingService.setTicketStatus(ticketId, status);
			assertEquals(expected, actual);
			
			
		}catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void addTransactionTest() throws OMTSException {
		try {
			Transaction transaction = new Transaction(3,934784,1890);
			int ticketId = 3;
			int userId=3;
			int actual = bookingService.addTransaction(transaction, ticketId);
			assertTrue(actual > 0);
		}catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void addBookingTest() throws OMTSException {
		try {
			int ticketId=3;
			int transactionId=3;
			LocalDate localDate = LocalDate.of(2004, 10, 12);
			Date date = Date.valueOf(localDate);
			Booking booking = new Booking(3,date);
			int addBooking = bookingService.addBooking(booking, ticketId, transactionId);
			assertTrue(addBooking>0);
			
		}catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void setSeatStatusTest() throws OMTSException {
		try {
		int seatId=1;
		String status="BOOKED";
		int actual = bookingService.setSeatStatus(seatId, status);
		assertTrue(actual > 0);
		} catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	
//	@Test
//	public void validatePaymentTest() throws OMTSException{
//		boolean validate=true;
//		try {
//			boolean result = customerService.validatePayment(123456, 662, "Ashu");
//			assertEquals(validate,result);
//		}
//		catch(OMTSException e) {
//			throw new OMTSException("Exception in testing");
//		}
//	}

	@Test
	public void getTicketTest() throws OMTSException{
		try {
			int ticketId=1;
			Ticket actual = bookingService.getTicket(ticketId);
			assertNotNull(actual);
		}catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	
}
