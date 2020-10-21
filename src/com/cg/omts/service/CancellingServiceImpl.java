package com.cg.omts.service;

import java.util.List;

import com.cg.omts.dao.CancellingDaoImpl;
import com.cg.omts.dao.ICancellingDao;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public class CancellingServiceImpl implements ICancellingService{

	ICancellingDao cancellingDao = new CancellingDaoImpl();
	
	@Override
	public int deleteBookingDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.deleteBookingDetails(ticketId);
	}

	@Override
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.getSeatsByTicket(ticketId);
	}

	@Override
	public int deleteAllocatedSeats(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.deleteAllocatedSeats(ticketId);
	}

	@Override
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.deleteSeatDetails(seatList);
	}

	@Override
	public Transaction getTransactionDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.getTransactionDetails(ticketId);
	}

	@Override
	public int deleteTransaction(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.deleteTransaction(ticketId);
	}

	@Override
	public int deleteTicketFromUser(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.deleteTicketFromUser(ticketId);
	}

	@Override
	public int cancelTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.cancelTicket(ticketId);
	}

	@Override
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException {
		// TODO Auto-generated method stub
		return cancellingDao.refundAfterCancellation(transaction, currentBalance);
	}
	

}
