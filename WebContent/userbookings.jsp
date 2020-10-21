<%@page import="com.cg.omts.dto.Booking"%>
<%@page import="com.cg.omts.dto.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.omts.dto.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

body {
	margin:0;
}
.header a.active, a.active, a.logout {
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

.header a.active:hover {
	background-color: #a89e8a;
	font-size: 200%;
}
.header a.logout:hover {
	font-size: 200%;
}
.bgpic {
	background-image: url("background.jpg");
	height: 100vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
.header a.back{
	float : left;
	padding: 15px 15px;
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
table {
	background-color: #ffff1a;
	border-collapse: collapse;
	width: 70%;
	height: 20%
}

th, td {
	padding: 5px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: grey;
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
		  	<a href="userhome.jsp" class = "back" align="left">
		  	<img src="backbutton.png" alt="back button" style="width:20px;height:25px;border:0;">
		    </a>
		    
	</div> 
	
	<%
		List<Ticket> ticketList = new ArrayList<Ticket>();
	
		List<Transaction> transactionList = new ArrayList<Transaction>();
		List<Booking> bookingList = new ArrayList<Booking>();
		ticketList = (List<Ticket>)request.getAttribute("ticketList");
		transactionList = (List<Transaction>) request.getAttribute("transactionList");
		bookingList = (List<Booking>) request.getAttribute("bookingList");
		List<String> theatreNameList = new ArrayList<String>();
		List<String> movieNameList = new ArrayList<String>();
		List<String> showNameList = new ArrayList<String>();
		List<String> screenNameList = new ArrayList<String>();
		theatreNameList = (List<String>)request.getAttribute("theatreNameList");
		showNameList = (List<String>)request.getAttribute("showNameList");
		screenNameList = (List<String>)request.getAttribute("screenNameList");
		movieNameList = (List<String>)request.getAttribute("movieNameList");
	%>
	<br><br><br>
	<h1 align ="center">MY BOOKINGS</h1>
	<table border="1" align ="center" id="myTable">
		<tr>
			
			<th>TICKETID</th>
			<th>NUMBER OF SEATS</th>
			<th>THEATRE NAME</th>
			<th>MOVIE NAME</th>
			<th>SHOW NAME</th>
			<th>SCREEN NAME</th>
			<th>TOTAL AMOUNT</th>
			<th>BOOKING DATE</th>
			<th>CANCEL TICKET</th>
			
		</tr>
		<%	for(int i = 0; i < ticketList.size(); i++){
		%> 		<tr height="5px">
					<td><%=ticketList.get(i).getTicketId() %></td>
					<td><%=ticketList.get(i).getNoOfSeats() %></td>
					<td><%=theatreNameList.get(i) %> </td>
					<td><%=movieNameList.get(i) %></td>
					<td><%=showNameList.get(i) %></td>
					<td><%=screenNameList.get(i)%></td>
					<td><%=transactionList.get(i).getTotalAmount() %></td>
					<td><%=bookingList.get(i).getBookingDate() %></td>
					<td><a href="CancelBookingController?ticketId=<%=ticketList.get(i).getTicketId()%>">cancel</a></td>
				</tr>	
			<%
			}%>
			<%if(request.getAttribute("message") != null){ %>
		<%=request.getAttribute("message")%>
	<%} %>
	</table>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>