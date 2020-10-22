<%@page import="com.cg.omts.service.BookingServiceImpl"%>
<%@page import="com.cg.omts.service.IBookingService"%>
<%@page import="com.cg.omts.dto.Transaction"%>
<%@page import="com.cg.omts.dto.Booking"%>
<%@page import="com.cg.omts.dto.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmation</title>
</head>

<style>

body {
	margin:0;
}
.header a {
	float:right;
	color: white;
	padding: 12px;
	text-decoration: none;
	line-height: 25px;
	border-radius: 4px;
	display: block;
	color: white;
	text-align: right;
	width:0%;
	padding: 14px 20px;
	width: 200px;
	font-size: 180%;
}
a {
	float: left;
}

.header a:hover {
	background-color: #a89e8a;
	font-size: 200%;
}

.bgpic {
	background-image: url("background.jpg");
	height: 100vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
.header {
	overflow: hidden;
	background-color: #291f04;
	padding: 0px 0px;
	opacity: 1;
	height:8%;
	margin-top:0%;
}
.header a.logout {
	background-color: #291f04;
	color: white;

}
.header logo {
	weight: 10;
	color: white;
	font-size: 40px;
}
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color:#291f04;
	margin-top: 100%;
	width: 100%;
	height: 6%;
	font-size: 200%;
	text-align: center;
	opacity: 1;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-right {
		float: none;
	}
}

.input {
	width: 170px;
	height: 30px;
	border-radius: 10px;
	background: rgba(255, 255, 255, .1);
	font-size: 15px;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color: #a89e8a;
	margin-top: 100%;
	width: 100%;
	height: 5%;
	font-size: 200%;
	text-align: center;
	opacity: 0.7;
}

</style>
<body class="bgpic">
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("username")==null)
      response.sendRedirect("index.jsp");
  else if(session.getAttribute("roleCode").equals("adm")){
	  response.sendRedirect("adminHomePage.jsp");
  }
  %> 
 <div class="header">
	 		
	 		<a href="LogoutServlet" class = "logout" align="right"><b>Logout</b></a>
			<a href="ViewBookingController" class="active" ><b>My Bookings</b></a>
		    <a href="userhome.jsp" class="active" ><b>User Home </b></a>
		    
	</div>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
	<%if(request.getAttribute("message") != null){ %>
		<center><h3 style="color:green;"><%=request.getAttribute("message")	%></h3></center>
	<%} %>
<center><h1>BOOKING CONFIRMATION</h1></center>
<center><h2>TICKET DETAILS</h2></center>

 <%
int ticketId=(Integer)request.getAttribute("ticketId");
IBookingService bookingService = new BookingServiceImpl();
Ticket ticket = bookingService.getTicket(ticketId);
%>
<center>
<table>
<tr><td>Ticket ID<td>: <td><%=ticket.getTicketId() %>
<tr><td>No Of Seats<td>: <td><%=ticket.getNoOfSeats() %>
<tr><td>Ticket Status<td>:<td> <%=ticket.getTicketStatus() %>
<tr><td>Movie Id<td>:<td><%=request.getAttribute("movieName") %>
<tr><td>Theatre Id<td>:<td> <%=request.getAttribute("theatreName")  %>
<tr><td>Show Id<td>:<td><%=request.getAttribute("showName")  %>
<tr><td>Screen Id<td>:<td> <%=request.getAttribute("screenName") %>

<% Booking booking = (Booking)request.getAttribute("booking");
System.out.println("In booking config transactioin obj is: "+booking);
request.setAttribute("booking", booking.getBookingId());
%>

<%--
<%
Booking booking = user.getBookingDetails(ticketId);


%>
--%>

<tr><td>Booking Id<td>:<td><%=booking.getBookingId() %>
<tr><td>Booking Date<td>:<td><%=booking.getBookingDate() %>


 
<% Transaction transaction = (Transaction)request.getAttribute("transaction");
System.out.println("In booking config transactioin obj is: "+transaction);%>

<tr><td>Transaction Id<td>:<td><%=transaction.getTransactionId() %><br>
<tr><td>Account Number<td>:<td><%=transaction.getAccountNumber() %><br>
<tr><td>Total Amount<td>:<td><%=transaction.getTotalAmount() %>
</center> 

</body>
</html>