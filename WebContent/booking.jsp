<%@page import="com.cg.omts.service.MovieTheatreServiceImpl"%>
<%@page import="com.cg.omts.dao.MovieTheatreDaoImpl"%>
<%@page import="com.cg.omts.service.IMovieTheatreService"%>
<%@page import="com.cg.omts.dto.Show"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.omts.dto.Screen"%>
<%@page import="com.cg.omts.dto.Theatre"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>

 <style>
h1{
	margin-top:-80px;
}
 select { 
                appearance: none; 
                outline: 0;  
                background-image: none; 
                width: 50%; 
                height: 100%; 
                color: black; 
                cursor: pointer; 
                border:1px solid black; 
                border-radius:3px; 
            } 
            .select { 
                position: relative; 
                display: block; 
                width: 15em; 
                height: 2em; 
                line-height: 3; 
                overflow: hidden; 
                border-radius: .25em; 
                padding-bottom:10px; 
                  
            } 
table {
	/*background-color: #ffff1a;*/
	border-collapse: collapse;
	width: 50%;
	height: 50%;
	margin-left:400px;
	margin-top:0px;
}

th, td {
	padding: 8px;
	text-align: left;
	font-size:18px;
	font-weight:bold;
	height:25px;
}
input,select{
	font-size:18px;
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

}

body {
	margin:0;
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

.selectclass {
	width:250px;
	height:35px;
	margin-right:81%;
	font-size:15px;
	background-color:#e3dddc;
}
.btn {
	margin-bottom: 10%;
	align: center;
	background-color: #291f04;
	border: none;
	border-radius: 16px;
	color: white;
	padding: 12px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 20px 550px;
	cursor: pointer;
}

.btn:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}
table{
	margin-top:0px;
}

</style>
 
 <script type="text/javascript">


	function changeActionForScreen(){
		document.bookingForm.action = "BookingScreenController";
		document.bookingForm.submit();
	}
	function changeActionForShow(){
		document.bookingForm.action = "BookingShowController";
		document.bookingForm.submit();
	}
	function proceedToPay(){
		document.bookingForm.action = "ProceedToPayController";
		document.bookingForm.submit();
	}
	function imposeMinMax(el){
		  if(el.value != ""){
		    if(parseInt(el.value) < parseInt(el.min)){
		      el.value = el.min;
		    }
		    if(parseInt(el.value) > parseInt(el.max)){
		      el.value = el.max;
		    }
		  }
		}
</script>
</head>
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
	<br><br><br><br><br>
<center>
	<form action ="BookingController" method = "post" id = "theatreSelection" name = "bookingForm">
		<h1>Ticket Booking</h1>
		<table align="center">
		<caption></caption>
			<tr >
				<td>Select Theatre</td><br>
				<td>:</td>
				<td><select name = "theatreId" onchange = "document.bookingForm.submit();" id = "selectedTheatre">
						<option value="-1" selected disabled>Select Theatre</option>
						<%
							String mId = request.getParameter("movieId");
							int movieId = Integer.parseInt(mId);
							IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
							
							List<Integer> theatreIdList = movieTheatreService.getTheatresByMovie(movieId);
			
							List<Theatre> theatresList = movieTheatreService.getTheatres(theatreIdList);
							for(Theatre theatre : theatresList){
						%>
						<option value = <%=theatre.getTheatreId() %>><%=theatre.getTheatreName() %></option>
						<%
							}			
						%>
						<input type = "hidden" value=<%=movieId %> name = "movieId" id = "selectedMovie">
					</select>
				</td>
			</tr>
			
			<tr>
				<td>Select screen</td><td>:</td>
				<td><select name = "screenId" onchange = "changeActionForScreen();" id = "selectedScreen">
						<option value="-1"  selected disabled>Select Screen</option>
						<%
							if(request.getAttribute("screenList") != null) {
					
								List<Screen> screenList = (ArrayList<Screen>)request.getAttribute("screenList");
					
								if(screenList.size() !=  0){
									for(Screen screen : screenList){				
						%>
										<option value = <%=screen.getScreenId()%>><%=screen.getScreenName() %>
						<%
									}
								}else{
									
						%>
									<option value="" selected disabled>No Screen</option>
						<%	
								}
							}else {
								
						%>
								<option value = <%=request.getAttribute("screenId")%> ><%=request.getAttribute("screenName")%></option>
								<script>
									document.getElementById("selectedScreen").value=<%=request.getAttribute("screenId")%>;
								
								</script>
						<%
							}
						%>
					
				
					</select>
				</td>
			</tr>
			<tr>
				<td>Select Show</td><td>:</td>
				<td><select name = "showId" onchange = "changeActionForShow();" id = "selectedShow">
						<option value="-1" selected disabled>Select Show</option>
						<%
							if(request.getAttribute("showList") != null) {
					
								List<Show> showList = (ArrayList<Show>)request.getAttribute("showList");
					
								if(showList.size() !=  0){
									for(Show show : showList){				
						%>
										<option value = <%=show.getShowId()%>><%=show.getShowName() %></option>
						<%
									}
								}else{
						%>
									<option value="" selected disabled>No Shows</option>
						<%	
								}
							}else {
						%>
								<option value = <%=request.getAttribute("showId") %>><%=request.getAttribute("showName")%></option>
								
						<%
							}
						%>
				
					</select>
				</td>
			</tr>
			<tr>
				<td>Enter Number of seats</td><td>:</td>
				<td><% int totalSeatsAvailable = 0; 
				if(session.getAttribute("totalSeatsAvailable") != null) {
					totalSeatsAvailable = (Integer)session.getAttribute("totalSeatsAvailable");
		         }
					if(totalSeatsAvailable > 10){
				%>
					<input type ="number" name = "noOfSeats" min = "1"  max = "10" onkeyup=imposeMinMax(this) value="1" required>
				<%} else if(totalSeatsAvailable > 0){ %>
						<input type ="number" name = "noOfSeats" min = "1"  max =<%=totalSeatsAvailable %> onkeyup=imposeMinMax(this) value="1" required>
				<%} else{
					%>
					<input type ="number" name = "noOfSeats" min = "0"  max =<%=totalSeatsAvailable %> onkeyup=imposeMinMax(this) value="1" required>
				
				<%}%>
				</td>
			</tr>
			<tr>
				
				<td></td>
				<td></td>
		<%
			if(totalSeatsAvailable > 0){         
         %>
							<td><label>****Number of seats available : </label> <%=request.getAttribute("totalSeatsAvailable") %></td>
				<%} else{%>
							<td><label>****Number of seats available : 0(House Full)</label></td>
				<%} %>
				</td>
			</tr>
			<tr>
				
				<td></td>
				<td></td>
				<td>
					
					<label>****Number of seats you can book : </label> <%=10 %>
				</td>
			</tr>
			<tr>
				<td>Cost</td><td>:</td>
				<td><input type = "text" value=<%=request.getAttribute("price") %> name = "seatPrice" id = "selectedScreenSeatPrice" readonly style="width:80px;">
				</td>
			</tr>
			<!-- <tr>
				<td><label>Total Price</label></td><td>:</td>
				<td><input type = "text" value=<%=request.getAttribute("totalPrice") %> name="totalPrice" id = "totalPrice" readonly> </td>
			</tr>-->
			
		</table>
		
		
		<Script>
			<%				
				if(request.getAttribute("screenList")!= null && request.getAttribute("theatreId") != null){
					System.out.println("In booking after selecting theatre"+request.getAttribute("theatreId"));
			%>
					document.getElementById("selectedMovie").value=<%=request.getAttribute("movieId")%>;
					document.getElementById("selectedTheatre").value=<%=request.getAttribute("theatreId")%>;
			<%
				}
				if(request.getAttribute("screenId")!= null && request.getAttribute("theatreId") != null && request.getAttribute("showList") != null){
					System.out.println("In booking after selecting screen"+request.getAttribute("screenId"));
			%>
					document.getElementById("selectedMovie").value=<%=request.getAttribute("movieId")%>;
					document.getElementById("selectedTheatre").value=<%=request.getAttribute("theatreId")%>;
					document.getElementById("selectedScreen").value=<%=request.getAttribute("screenId")%>;
			<%
				}if(request.getAttribute("price") != null && request.getAttribute("screenId")!= null && request.getAttribute("theatreId") != null && request.getAttribute("showId") != null){
					System.out.println("In booking after selecting show"+request.getAttribute("theatreId"));
					System.out.println("In booking after selecting show"+request.getAttribute("screenId"));
					System.out.println("In booking after selecting show"+request.getAttribute("showId"));
			%>
					document.getElementById("selectedMovie").value=<%=request.getAttribute("movieId")%>;
					document.getElementById("selectedTheatre").value=<%=request.getAttribute("theatreId")%>;
					document.getElementById("selectedScreen").value=<%=request.getAttribute("screenId")%>;
					document.getElementById("selectedShow").value=<%=request.getAttribute("showId")%>;
					document.getElementById("selectedScreenSeatPrice").value=<%=request.getAttribute("price")%>;
			<%
				}
			%>
		</Script>
		
		
	</form><br><br>
	<%
	
	if((request.getAttribute("theatreId") != null) && (request.getAttribute("screenId") != null) && (request.getAttribute("showId") != null) && (totalSeatsAvailable > 0)){ %>
			<input type="button" id="myBtn" value="Proceed to Pay" onclick="proceedToPay()" class="btn">
	<%}else{ %>		
			<input type="button" id="myBtn" value="Proceed to Pay" disabled class="btn">
			<!-- <button onclick="proceedToPay()" diabled>Proceed to Pay</button> -->
	<%} %>
	</center>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Pvt Ltd.
	</div> 
</body>
</html>