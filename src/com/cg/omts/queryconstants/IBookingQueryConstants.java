package com.cg.omts.queryconstants;

public interface IBookingQueryConstants {

	String GENERATE_TICKET = "insert into ticket(ticketId, noOfSeats, screenId, theatreId, showId, movieId) values(?,?,?,?,?,?)";

	String GET_TICKET_IDS = "select ticketId from userticket where userId = ?";
	
	String GET_TICKET_BY_ID = "select * from ticket where ticketId = ? and ticketStatus = ?";
	
	String GET_TRANSACTION_BY_TICKET = "select * from transaction where ticketId = ?";
	
	String GET_BOOKING_BY_TRANSACTION = "select bookingId, bookingDate from booking where transactionId = ?";
	
	String GET_THEATRE_NAME_BY_ID = "select theatreName from theatre where theatreId = ?";
	
	String GET_MOVIES_BY_THEATRE_ID = "select movieId from movietheatre where theatreId=?";
	
	String GET_MOVIES_BY_ID = "select * from movie where movieId = ?";
	
	String GET_SHOWNAME_BY_THEATREID= "select showName from showdetails where theatreId=?";
	
	String GET_SCREENNAME_BY_THEATREID= "select screenName from screen where theatreId=?";
	
	String ADD_TICKET_TO_USER = "insert into userticket values(?,?)";
	
	String ALLOCATE_SEATS = "insert into seat values(?,?,?)";
	
	String ASSIGN_SEATS_TO_TICKET = "insert into ticketseat values(?,?)";
	
	String SET_TICKET_STATUS = "update ticket set ticketStatus = ? where ticketId = ?";
	
	String VALIDATE_PAYMENT = "select cvv,password from bankaccount where accountNo=?";
	
	String GET_CURRENT_BALANCE = "select accountBal from bankaccount where accountNo = ?";
	
	String ADD_TRANSACTION = "insert into transaction values(?,?,?,?)";
	
	String DEDUCT_AMOUNT = "update bankaccount set accountBal = ? where accountNo = ?";
	
	String ADD_BOOKING = "insert into booking values(?,?,?,?)";
	
	String SET_SEAT_STATUS = "update seat set seatStatus = ? where seatId = ?";
	
	String GET_MOVIE_DETAILS = "select * from movie where movieId = ?";
	
	String GET_THEATRE_NAME = "select theatreName from theatre where theatreId = ?";
	
	String GET_SCREEN_NAME = "select screenName from screen where screenId = ?";
	
	String GET_SHOW_NAME = "select showName from showdetails where showId = ?";
	
	String GET_SEATS = "select seatId from ticketseat where ticketId = ?";
	
	String GET_SCREEN_BY_THEATRE_ID = "select * from screen where theatreId=?";
	
	String GET_SHOWS_BY_MOVIE_THEATRE = "select * from showdetails where screenId=? and theatreId=? and movieId=?";

	String GET_SCREENSEATPRICE_BY_SCREENID = "select seatPrice from screenseatprice where screenId=?";
	
	String GET_AVAILABLE_SEATS = "select count(*) from seat where screenId = ?";
	
	String GET_SCREEN_BY_ID = "select screenRows, columns from screen where screenId = ?";
	
	String GET_TICKET="select noOfSeats,ticketStatus,screenId,theatreId,showId,movieId from ticket where ticketId=?";

}
