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
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.dto.Ticket.TicketStatus;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.BookingServiceImpl;
import com.cg.omts.service.IBookingService;

public class BookingModuleTesting {

	IBookingService bookingService = new BookingServiceImpl();
	
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
	public void getTicketIdsByUserTest() throws OMTSException {
		try {
			int customerId = 1001;
			List<Integer> expectedTicketIdList = new ArrayList<Integer>();
			expectedTicketIdList.add(1);
			expectedTicketIdList.add(2);
			expectedTicketIdList.add(3);
			expectedTicketIdList.add(4);
			
			List<Integer> actualTicketIdList = bookingService.getSeatsByTicket(customerId);
			assertEquals(expectedTicketIdList, actualTicketIdList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
	
	@Test
	public void validatePaymentTest() throws OMTSException{
		boolean validate=true;
		try {
			boolean result = bookingService.validatePayment(123456, 662, "Ashu");
			assertEquals(validate,result);
		}
		catch(OMTSException e) {
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
	public void getTicketByIDSTest() throws OMTSException {
		try {
		List<Integer> ticketIdList = new ArrayList<Integer>();
		ticketIdList.add(1);
		List<Ticket> expectedTicketList = new ArrayList<Ticket>();
		Ticket ticket1 = new Ticket(1, 2, TicketStatus.BOOKED, 4000, 2000, 5000, 3000);
		Ticket ticket2 = new Ticket(2, 1, TicketStatus.BOOKED, 4000, 2001, 5000, 3000);
		expectedTicketList.add(ticket1);
		expectedTicketList.add(ticket2);
		List<Ticket> actualTicketList = bookingService.getTicketByIDS(ticketIdList);
		assertEquals(expectedTicketList,actualTicketList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}
	
	@Test
	public void getTransactionByTicketTest() throws OMTSException {
		try {
		List<Integer> ticketIdList = new ArrayList<Integer>();
		ticketIdList.add(1);
		List<Transaction> expectedTransactionList = new ArrayList<Transaction>();
		Transaction transaction1 = new Transaction(1, 123456, 500);
		Transaction transaction2 = new Transaction(2, 123456, 500);
		expectedTransactionList.add(transaction1);
		expectedTransactionList.add(transaction2);
		List<Transaction> actualTransactionList = new ArrayList<Transaction>();
		actualTransactionList = bookingService.getTransactionByTicket(ticketIdList);
		assertEquals(expectedTransactionList,actualTransactionList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}

	@Test
	public void getBookingByUserTest() throws OMTSException {
		try {
			List<Transaction> transactionList = new ArrayList<Transaction>();
			Transaction transaction1 = new Transaction(1, 123456, 500);
			Transaction transaction2 = new Transaction(2, 123456, 500);
			transactionList.add(transaction1);
			transactionList.add(transaction2);
			List<Booking> expectedBookingList = new ArrayList<Booking>();
			Booking booking1 = new Booking(1, Date.valueOf("2020-10-09"));
			Booking booking2 = new Booking(1, Date.valueOf("2020-10-09"));
			expectedBookingList.add(booking1);
			expectedBookingList.add(booking2);
			List<Booking> actualBookingList = new ArrayList<Booking>();
			actualBookingList = bookingService.getBookingByUser(transactionList);
			assertEquals(expectedBookingList, actualBookingList);
			}
			catch(OMTSException e) {
				throw new OMTSException("Exception in testing");
			}
	}
	
	@Test
	public void getTheatreNamesTest() throws OMTSException {
		try {
		List<Integer> theatreIdList = new ArrayList<Integer>();
		theatreIdList.add(2000);
		List<String> expectedTheatreNamesList = new ArrayList<String>();
		expectedTheatreNamesList.add("Vimal");
		expectedTheatreNamesList.add("IMAX");
		List<String> actualTheatreNamesList = new ArrayList<String>();
		actualTheatreNamesList = bookingService.getTheatreNames(theatreIdList);
		assertEquals(expectedTheatreNamesList,actualTheatreNamesList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}
	
	@Test
	public void getMoviesByTheatreTest() throws OMTSException {
		try {
		List<Integer> theatreIdList = new ArrayList<Integer>();
		theatreIdList.add(2000);
		List<Integer> expectedMovieIdList = new ArrayList<Integer>();
		expectedMovieIdList.add(1);
		expectedMovieIdList.add(2);
		List<Integer> actualMovieIdList = new ArrayList<Integer>();
		actualMovieIdList = bookingService.getMoviesByTheatre(theatreIdList);
		assertEquals(expectedMovieIdList,actualMovieIdList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}
	
	@Test
	public void getMoviesByIdTest() throws OMTSException {
		try {
		List<Integer> movieIdList = new ArrayList<Integer>();
		movieIdList.add(1);
		List<Movie> expectedMovieList = new ArrayList<Movie>();
		Movie movie1 = new Movie(1, "one", "comedy", "suresh", 180, "Telugu", Date.valueOf("2020-20-10"));
		Movie movie2 = new Movie(1, "one", "comedy", "suresh", 180, "Telugu", Date.valueOf("2020-20-10"));
		expectedMovieList.add(movie1);
		expectedMovieList.add(movie2);
		List<Movie> actualMovieList = new ArrayList<Movie>();
		actualMovieList = bookingService.getMoviesById(movieIdList);
		assertEquals(expectedMovieList,actualMovieList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}
	
	@Test
	public void getShowNamesByTheatreTest() throws OMTSException {
		try {
		List<Integer> theatreIdList = new ArrayList<Integer>();
		theatreIdList.add(2000);
		List<String> expectedShowNamesList = new ArrayList<String>();
		expectedShowNamesList.add("Morning");
		expectedShowNamesList.add("matinee");
		List<String> actualShowNamesList = new ArrayList<String>();
		actualShowNamesList = bookingService.getShowNamesByTheatre(theatreIdList);
		assertEquals(expectedShowNamesList,actualShowNamesList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}	
	
	@Test
	public void getScreenNamesByTheatreTest() throws OMTSException {
		try {
		List<Integer> theatreIdList = new ArrayList<Integer>();
		theatreIdList.add(2000);
		List<String> expectedScreenNamesList = new ArrayList<String>();
		expectedScreenNamesList.add("screen1");
		expectedScreenNamesList.add("screen2");
		List<String> actualScreenNamesList = new ArrayList<String>();
		actualScreenNamesList = bookingService.getScreenNamesByTheatre(theatreIdList);
		assertEquals(expectedScreenNamesList,actualScreenNamesList);
		}
		catch(OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
		
	}
	
	@Test
	public void assignTicketToUserTest() throws OMTSException {
		try {
		int ticketId=1,userId=2;
		int isAssigned = bookingService.assignTicketToUser(ticketId, userId);
		assertTrue(isAssigned > 0);
		} catch(OMTSException e) {
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
}
