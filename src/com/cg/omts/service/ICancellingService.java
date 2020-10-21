package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public interface ICancellingService {

	/********************************
	 * @description Methods to delete booking details
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	public int deleteBookingDetails(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Methods to get seats my ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to delete allocated seats
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	public int deleteAllocatedSeats(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to delete seat details
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param seatList
	 * @return int
	 * @throws OMTSException
	 */
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException;
	
	/********************************
	 * @description Method to get transaction details
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return Transaction
	 * @throws OMTSException
	 */
	public Transaction getTransactionDetails(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to delete transaction 
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	public int deleteTransaction(int ticketId) throws OMTSException;
	
	public int deleteTicketFromUser(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to cancel ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	public int cancelTicket(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to refund after cancellation
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param transaction
	 * @param currentBalance
	 * @return int
	 * @throws OMTSException
	 */
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException;
}
