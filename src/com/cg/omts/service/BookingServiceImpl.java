package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dao.BookingDaoImpl;
import com.cg.omts.dao.IBookingDao;
import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public class BookingServiceImpl implements IBookingService{

	IBookingDao bookingDao = new BookingDaoImpl();
	@Override
	public int generateTicket(Ticket ticket) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.generateTicket(ticket);
	}
	@Override
	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getTicketIdsByUser(userId);
	}
	@Override
	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getTicketByIDS(ticketIdList);
	}
	@Override
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getTransactionByTicket(ticketIdList);
	}
	@Override
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getBookingByUser(transactionId);
	}
	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getTheatreNames(theatreIdList);
	}
	@Override
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getMoviesByTheatre(theatreIdList);
	}
	@Override
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getMoviesById(movieIdList);
	}
	@Override
	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getShowNamesByTheatre(theatreIdList);
	}
	@Override
	public List<String> getScreenNamesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getScreenNamesByTheatre(theatreIdList);
	}
	@Override
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.assignTicketToUser(ticketId, userId);
	}
	@Override
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.allocateSeat(selectedSeatsList, screenId);
	}
	@Override
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.assignSeatsToTickets(ticketId, seatsList);
	}
	@Override
	public int setTicketStatus(int ticketId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.setTicketStatus(ticketId, status);
	}
	@Override
	public boolean validatePayment(int accountNo, int cvv, String password) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.validatePayment(accountNo, cvv, password);
	}
	@Override
	public int getCurrentBalance(Transaction transaction) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getCurrentBalance(transaction);
	}
	@Override
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.addTransaction(transaction, ticketId);
	}
	@Override
	public int makePayment(int accountNo, int currentBalance, int totalCost) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.makePayment(accountNo, currentBalance, totalCost);
	}
	@Override
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.addBooking(booking, ticketId, transactionId);
	}
	@Override
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getSeatsByTicket(ticketId);
	}
	@Override
	public int setSeatStatus(int seatId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.setSeatStatus(seatId, status);
	}
	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getMovieDetails(movieId);
	}
	@Override
	public String getTheatreName(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getTheatreName(theatreId);
	}
	@Override
	public String getScreenName(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getScreenName(screenId);
	}
	@Override
	public String getShowName(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getShowName(showId);
	}
	@Override
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getScreenByTheatreId(theatreId);
	}
	@Override
	public List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getShowsByMovieAndTheatre(screenId, theatreId, movieId);
	}
	@Override
	public Seat getSeatPrice(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getSeatPrice(screenId);
	}
	@Override
	public int getSeatsAvailable(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getSeatsAvailable(screenId);
	}
	@Override
	public Screen getScreen(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getScreen(screenId);
	}
	@Override
	public Ticket getTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getTicket(ticketId);
	}
	@Override
	public int deleteSeatByStatus() throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.deleteSeatByStatus();
	}
	@Override
	public List<Integer> getTicketWithoutPayment() throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.getTicketWithoutPayment();
	}
	@Override
	public int deleteTicketToUser(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.deleteTicketToUser(ticketIdList);
	}
	@Override
	public int deleteTicket(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return bookingDao.deleteTicket(ticketIdList);
	}

}
