package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public interface IBookingService {

	/*******************************
	 * @description Method to generate ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @param ticket
	 * @return int
	 * @throws OMTSException
	 */
	public int generateTicket(Ticket ticket) throws OMTSException;
	
	
	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException;
	
	
	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException;
	
	/*******************************
	 * @description Method to get Theatre Names
	 * @author Supriya M
	 * 
	 * @param theatreIdList
	 * @return List<String>
	 * @throws OMTSException
	 */
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException;
	
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException;
	
	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;
	
	public List<String> getScreenNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;
	
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException;
	
	/*******************************
	 * @description Method to allocate seat
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param selectedSeatsList
	 * @param screenId
	 * @return int
	 * @throws OMTSException
	 */
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException;
	

	/*******************************
	 * @description Method to assign seats to tickets
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @param seatsList
	 * @return int
	 * @throws OMTSException
	 */
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException;
	
	public int setTicketStatus(int ticketId, String status) throws OMTSException;
	
	/*******
	 @Description : To validate payment
	 @author  : Ashutosh
	 @param : accountNo, cvv, password
	 @return : Boolean(true or false)
	 @Exception : throws OMTSException
	********/
	public boolean validatePayment(int accountNo,int cvv,String password) throws OMTSException;
	
	/********************************
	 * @description Method to get current balance
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param transaction
	 * @return int
	 * @throws OMTSException
	 */
	
	public int getCurrentBalance(Transaction transaction) throws OMTSException;
	

	/*******************************
	 * @description Method to add transaction
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param transaction
	 * @param ticketId
	 * @param userId
	 * @return int
	 * @throws OMTSException
	 */
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException;
	
	public int makePayment(int accountNo, int currentBalance, int totalCost) throws OMTSException;
	
	/*******************************
	 * @description Method to add booking
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param booking
	 * @param ticketId
	 * @param transactionId
	 * @return int
	 * @throws OMTSException
	 */
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException;
	
	/********************************
	 * @description Methods to get seats my ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException;
	
	/*******************************
	 * @description Method to set seat status
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param seatId
	 * @param status
	 * @return int
	 * @throws OMTSException
	 */
	
	public int setSeatStatus(int seatId, String status) throws OMTSException;
	
	/*******************************
	 * @description Method to get movie details 
	 * @author Laxmi Prasanna Pujari
	 *  
	 * @param movieId
	 * @return Movie
	 * @throws OMTSException
	 */

	public Movie getMovieDetails(int movieId) throws OMTSException;
	
	public String getTheatreName(int theatreId) throws OMTSException;
	
	public String getScreenName(int screenId) throws OMTSException;
	
	public String getShowName(int showId) throws OMTSException;
	
	/*****
	 * @description Method to return screen details
	 * @author Supriya M
	 * 
	 * @param theatreId
	 * @return List<Screen>
	 * @throws OMTSException
	 */
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException;
	
	/*****
	 * @description Method to return Shows
	 * @author Supriya M
	 * 
	 * @param screenId
	 * @param theatreId
	 * @param movieId
	 * @return List<Show>
	 * @throws OMTSException
	 */
	public List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException;
	
	/*****
	 * @description Method to return seat price
	 * @author Supriya M
	 * 
	 * @param seatId
	 * @return Seat
	 * @throws OMTSException
	 */
	public Seat getSeatPrice(int screenId) throws OMTSException;
	
	public int getSeatsAvailable(int screenId) throws OMTSException;
	
	public Screen getScreen(int screenId) throws OMTSException;
	
	Ticket getTicket(int ticketId) throws OMTSException;
	
}
