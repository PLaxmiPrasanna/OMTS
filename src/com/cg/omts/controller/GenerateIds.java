package com.cg.omts.controller;

import java.sql.SQLException;

import com.cg.omts.dao.CustomerDaoImpl;
import com.cg.omts.exceptions.OMTSException;

import org.apache.log4j.Logger;
public class GenerateIds {
	final static Logger LOGGER = Logger.getLogger(GenerateIds.class);
	public static int startTicketID = 1000;
	public static int startSeatId = 1;
	public static int startBookingId = 1000;
	
	public static int startTransaction = 1000;
	
	static public int getTransactionId() {
		try {
			boolean isTransactionNull = CustomerDaoImpl.checkTransaction();
			if(! isTransactionNull) {
				LOGGER.info("First transaction");
				startTransaction = 1000;
			} else {
				startTransaction = CustomerDaoImpl.getMaxTransactionId() + 1;
			}
			
		} catch (SQLException | OMTSException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Exception occured");
			e.printStackTrace();
		}
		return startTransaction;
		
	}
	
	static public int getTicketId() {
		try {
			boolean isTicketNull = CustomerDaoImpl.checkTicket();
			if(isTicketNull == false) {
				LOGGER.info("First Ticket");
				startTicketID = 1000;
			} else {
				startTicketID = CustomerDaoImpl.getMaxTicketId()+1;
			}
			
		}catch(SQLException | OMTSException e) {
			e.printStackTrace();
		}
		LOGGER.info("Ticket id generated");
		return startTicketID;
	}
	static public int getSeatId() {
		try {
			boolean isSeatNull = CustomerDaoImpl.checkSeat();
			if(isSeatNull == false) {
				startSeatId = 1000;
			} else {
				LOGGER.info("Seat found");
				startSeatId = CustomerDaoImpl.getMaxSeatId()+1;
			}
			
		}catch(SQLException | OMTSException e) {
			LOGGER.warn("Exception occured");
			e.printStackTrace();
		}
		LOGGER.info("Seat id generated");
		return startSeatId;
	}
	static public int getBookingId() {
		try {
			boolean isBookingNull = CustomerDaoImpl.checkBooking();
			if(isBookingNull == false) {
				startBookingId = 1000;
			} else {
				startBookingId = CustomerDaoImpl.getMaxBookingId()+1;
			}
			
		}catch(SQLException | OMTSException e) {
			LOGGER.warn("Exception occured");
			e.printStackTrace();
		}
		return startBookingId;
	}
}
