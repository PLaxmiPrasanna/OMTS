package com.cg.omts.dao;

import java.util.List;

import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public interface ICancellingDao {
	
	public int deleteAllocatedSeats(int ticketId) throws OMTSException;//cancel
	
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException;//cancel
	
	public Transaction getTransactionDetails(int ticketId) throws OMTSException;//cancel
	
	public int deleteTransaction(int ticketId) throws OMTSException;//cancel
	
	public int cancelTicket(int ticketId) throws OMTSException;//cancel
	
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException;//cancel
	
	public int deleteBookingDetails(int ticketId) throws OMTSException;
	
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException;
	
	public int deleteTicketFromUser(int ticketId) throws OMTSException;

}
