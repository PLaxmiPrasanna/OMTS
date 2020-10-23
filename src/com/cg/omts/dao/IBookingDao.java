package com.cg.omts.dao;

import java.util.List;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public interface IBookingDao {

	public int generateTicket(Ticket ticket) throws OMTSException;
	
	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException;
	
	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException;

	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException;
	
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException;
	
	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;
	
	public List<String> getScreenNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public int assignTicketToUser(int ticketId, int userId) throws OMTSException;
	
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException;

	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException;
	
	public int setTicketStatus(int ticketId, String status) throws OMTSException;
	
	boolean validatePayment(int accountNo, int cvv, String password) throws OMTSException;
	
	public int getCurrentBalance(Transaction transaction) throws OMTSException;
	
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException;
	
	public int makePayment(int accountNo, int currentBalance, int totalCost) throws OMTSException;
	
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException;
	
	public int setSeatStatus(int seatId, String status) throws OMTSException;

	public Movie getMovieDetails(int movieId) throws OMTSException;
	
	public String getTheatreName(int theatreId) throws OMTSException;
	
	public String getScreenName(int screenId) throws OMTSException;
	
	public String getShowName(int showId) throws OMTSException;
	
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException;
	
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException;

	public List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException;
	
	public Seat getSeatPrice(int screenId) throws OMTSException;
	
	public int getSeatsAvailable(int screenId) throws OMTSException;
	
	public Screen getScreen(int screenId) throws OMTSException;
	
	Ticket getTicket(int ticketId) throws OMTSException;
	
	public int deleteSeatByStatus() throws OMTSException;
	
	public List<Integer> getTicketWithoutPayment() throws OMTSException;

	public int deleteTicketToUser(List<Integer> ticketIdList) throws OMTSException;
	
	public int deleteTicket(List<Integer> ticketIdList) throws OMTSException;
}
