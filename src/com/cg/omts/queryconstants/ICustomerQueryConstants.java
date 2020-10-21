package com.cg.omts.queryconstants;

public interface ICustomerQueryConstants {

	String VALIDATE_CUSTOMER = "select roleCode from user where userId = ? and password = ?";
	
	String REGISTER_CUSTOMER = "insert into user values(?,?,?,?,?,?)";
	
	String CHECK_TRANSACTION = "select * from transaction";
	
	String MAX_TRANSACTION_ID = "select max(transactionid) from transaction";
	
	String CHECK_TICKET = "select * from ticket";
	
	String CHECK_SEAT = "select * from seat";
	
	String CHECK_BOOKING = "select * from booking";
	
	String MAX_TICKET_ID = "select max(ticketId) from ticket";
	
	String MAX_SEAT_ID = "select max(seatId) from seat";
	
	String MAX_BOOKING_ID = "select max(bookingId) from booking";
	
	String GET_TRANSACTION_ID = "select transactionId from booking where bookingId = ?";
}
