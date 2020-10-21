package com.cg.omts.queryconstants;

public interface ICancellingQueryConstants {

	String DELETE_BOOKING_DETAILS = "delete from booking where ticketId = ?";
	
	String GET_SEATS = "select seatId from ticketseat where ticketId = ?";
	
	String DELETE_ALLOCATED_SEATS = "delete from ticketseat where ticketId = ?";
	
	String DELETE_SEATS = "delete from seat where seatId = ?";
	
	String GET_TRANSACTION_DETAILS = "select transactionId, accountNo, totalAmt from transaction where ticketId = ?";
	
	String DELETE_TRANSACTION = "delete from transaction where ticketId = ?";
	
	String DELETE_TICKET = "delete from ticket where ticketId = ?";
	
	String DELETE_FROM_USER= "delete from userticket where ticketId=?";
	
	String REFUND_AMOUNT = "update bankaccount set accountBal = ? where accountNo = ?";
}
