package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.queryconstants.ICustomerQueryConstants;
import com.cg.omts.utility.DBConnection;

public class CustomerDaoImpl implements ICustomerDao{
	
	static Connection connection = null;
	static Statement statement = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public String validateLogin(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		boolean status=false;
		String roleCode="";
		try {
			connection=DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICustomerQueryConstants.VALIDATE_CUSTOMER);
			prepareStatement.setInt(1, customer.getCustomerId());
			prepareStatement.setString(2, customer.getCustomerPassword());
			ResultSet rs = prepareStatement.executeQuery();
			if(rs.next())
			{
				roleCode=rs.getString(1);
			}
		}catch (SQLException e) {
			System.out.println("Failed to get the login"+ e);
		} finally {
			try {
				connection.close();
				prepareStatement.close();
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" +e);
			}
		}
		
		return roleCode;
	}

	@Override
	public int register(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		int rows=0;
		int error=-1;
		try {
			connection=DBConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(ICustomerQueryConstants.REGISTER_CUSTOMER);
			ps.setInt(1,customer.getCustomerId());
			ps.setString(2,customer.getCustomerName());
			Date date=customer.getDateOfBirth();
		    ps.setDate(4, customer.getDateOfBirth());
		    ps.setString(3,customer.getCustomerPassword());
			ps.setString(5,customer.getCustomerContact());
			ps.setString(6,customer.getRoleCode());
			rows=ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Failed to get the login"+ e);
		} finally {
			try {
				connection.close();
				
			} catch (SQLException e) {
				System.out.println("Failed to close the database connection" +e);
			}
		}
		
		return rows;
	}

	public static boolean checkTransaction() throws SQLException, OMTSException {
		connection = DBConnection.getConnection();
		prepareStatement = connection.prepareStatement(ICustomerQueryConstants.CHECK_TRANSACTION);
		resultSet = prepareStatement.executeQuery();
		if(resultSet.next())
			return true;
		return false;
	}
	
	public static int getMaxTransactionId() throws SQLException, OMTSException {
		connection = DBConnection.getConnection();
		prepareStatement = connection.prepareStatement(ICustomerQueryConstants.MAX_TRANSACTION_ID);
		resultSet = prepareStatement.executeQuery();
		int maxId=0;
		if(resultSet.next())
		 maxId = resultSet.getInt(1);
		return maxId;
	}
	

	public static boolean checkTicket() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		boolean isFound = false;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICustomerQueryConstants.CHECK_TICKET);
		
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				isFound = true;
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
		return isFound;
	}

	
	public static int getMaxTicketId() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		int maxTicId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICustomerQueryConstants.MAX_TICKET_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				maxTicId = resultSet.getInt(1);
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
		return maxTicId;
	}

	public static boolean checkSeat() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		boolean isFound = false;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICustomerQueryConstants.CHECK_SEAT);
		
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				isFound = true;
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
		return isFound;
	}
	public static boolean checkBooking() throws SQLException, OMTSException {
		// TODO Auto-generated method stub
		boolean isFound = false;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICustomerQueryConstants.CHECK_BOOKING);
		
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				isFound = true;
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
		return isFound;
	}
	public static int getMaxSeatId() throws OMTSException {
		// TODO Auto-generated method stub
		int maxSeatId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICustomerQueryConstants.MAX_SEAT_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				maxSeatId = resultSet.getInt(1);
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
		return maxSeatId;
	}
	public static int getMaxBookingId() throws OMTSException {
		// TODO Auto-generated method stub
		int maxBookingId = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(ICustomerQueryConstants.MAX_BOOKING_ID);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				maxBookingId = resultSet.getInt(1);
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
		return maxBookingId;
	}
}
