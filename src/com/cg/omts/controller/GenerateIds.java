package com.cg.omts.controller;

import java.sql.SQLException;

import com.cg.omts.dao.CustomerDaoImpl;
import com.cg.omts.exceptions.OMTSException;

public class GenerateIds {
	public static int startTicketID = 1000;
	public static int startSeatId = 1;
	public static int startBookingId = 1000;
	
	public static int startTransaction = 1000;
	
	static public int getTransactionId() {
		try {
			boolean isTransactionNull = CustomerDaoImpl.checkTransaction();
			if(! isTransactionNull) {
				startTransaction = 1000;
				System.out.println("From generate transaction id class:" + isTransactionNull);
			} else {
				startTransaction = CustomerDaoImpl.getMaxTransactionId() + 1;
			}
			
		} catch (SQLException | OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startTransaction;
		
	}
	
	static public int getTicketId() {
		try {
			boolean isTicketNull = CustomerDaoImpl.checkTicket();
			if(isTicketNull == false) {
				startTicketID = 1000;
			} else {
				startTicketID = CustomerDaoImpl.getMaxTicketId()+1;
			}
			System.out.println("isFound"+isTicketNull);
			
		}catch(SQLException | OMTSException e) {
			e.printStackTrace();
		}
		System.out.println("In Generate ticket id"+startTicketID );
		return startTicketID;
	}
	static public int getSeatId() {
		try {
			boolean isSeatNull = CustomerDaoImpl.checkSeat();
			if(isSeatNull == false) {
				startSeatId = 1000;
			} else {
				startSeatId = CustomerDaoImpl.getMaxSeatId()+1;
			}
			System.out.println("isFound"+isSeatNull);
			
		}catch(SQLException | OMTSException e) {
			e.printStackTrace();
		}
		System.out.println("In GENERATE SEAT ID"+startSeatId);
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
			System.out.println("isFound"+isBookingNull);
			
		}catch(SQLException | OMTSException e) {
			e.printStackTrace();
		}
		return startBookingId;
	}
}
