package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.queryconstants.ICancellingQueryConstants;
import com.cg.omts.utility.DBConnection;

public class CancellingDaoImpl implements ICancellingDao{

	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public int deleteBookingDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.DELETE_BOOKING_DETAILS);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public  List<Integer> getSeatsByTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> seatList = new ArrayList<>();

		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.GET_SEATS);
			prepareStatement.setInt(1, ticketId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				seatList.add(resultSet.getInt(1));
			}
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return seatList;	
	}

	@Override
	public int deleteAllocatedSeats(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.DELETE_ALLOCATED_SEATS);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.DELETE_SEATS);   
			for(Integer seat : seatList) {
				prepareStatement.setInt(1, seat);
				isDeleted = prepareStatement.executeUpdate();  
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public Transaction getTransactionDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Boolean isFound = false;
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.GET_TRANSACTION_DETAILS);
			prepareStatement.setInt(1, ticketId);
			resultSet = prepareStatement.executeQuery();
			
			isFound = resultSet.next();
			if(isFound == true) {
				transaction = new Transaction();
				transaction.setTransactionId(resultSet.getInt(1));
				transaction.setAccountNumber(resultSet.getInt(2));
				transaction.setTotalAmount(resultSet.getInt(3));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object" + e.getMessage());
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}

		}
		return transaction;
	}

	@Override
	public int deleteTransaction(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.DELETE_TRANSACTION);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}

	@Override
	public int cancelTicket(int ticketId) throws OMTSException {
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.DELETE_TICKET);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}
	

	@Override
	public int deleteTicketFromUser(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		int isDeleted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.DELETE_FROM_USER);   
			prepareStatement.setInt(1, ticketId);
			isDeleted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isDeleted;
	}
	

	@Override
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException {
		// TODO Auto-generated method stub
		int isUpdated = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICancellingQueryConstants.REFUND_AMOUNT);   
			prepareStatement.setInt(1, transaction.getTotalAmount()+currentBalance);
			prepareStatement.setInt(2, transaction.getAccountNumber());
			isUpdated = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem while creating PS object");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isUpdated;
	}
}
