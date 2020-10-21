<%@page import="com.cg.omts.dto.Show"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.omts.dto.Screen"%>
<%@page import="com.cg.omts.dto.Theatre"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.service.UserServiceImpl"%>
<%@page import="com.cg.omts.service.IUserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
<!-- <style>

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


ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	width: 200px;
	font-size: 60%;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #a89e8a;
	font-size: 200%;
}



.loginform {
	margin-top: 10%;
	background: #a89e8a;
	width: 26%;
	height: 50%;
	border-radius: 7%;
	opacity: 0.8;
	color: white;
	align: center;
	margin-left: 35%;
	display: none;
	position: absolute;
	box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0
		rgba(0, 0, 0, .19);
	border: 3px solid #f1f1f1;
}

.header a:hover {
	background-color: #a89e8a;
}

.header a.active {
	background-color: #a89e8a;
	color: white;
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
 -->
 <style>

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
		<table align="center">
		<caption><h1>Ticket Booking</h1></caption><br>
			<tr>
				<td><label>Select Theatre </label></td>
				<td>:</td>
				<td><select name = "theatreId" onchange = "document.bookingForm.submit();" id = "selectedTheatre">
						<option value="-1" selected disabled>Select Theatre</option>
						<%
							String mId = request.getParameter("movieId");
							int movieId = Integer.parseInt(mId);
							IUserService userService = new UserServiceImpl();
							List<Integer> theatreIdList = userService.getTheatresByMovie(movieId);
			
							List<Theatre> theatresList = userService.getTheatres(theatreIdList);
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
				<td><label>Select screen </label></td><td>:</td>
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
				<td><label>Select Show </label></td><td>:</td>
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
				<td><label>Enter Number of seats</label></td><td>:</td>
				<td>
					<input type ="number" name = "noOfSeats" min = "1" max = "10" onkeyup=imposeMinMax(this) value="1" required>
				</td>
			</tr>
			<tr>
				
				<td></td>
				<td></td>
				<td>
					
					<label>****Number of seats available : </label> <%=request.getAttribute("totalSeatsAvailable") %>
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
				<td><label>Cost </label></td><td>:</td>
				<td><input type = "text" value=<%=request.getAttribute("price") %> name = "seatPrice" id = "selectedScreenSeatPrice" readonly>
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
		
		
	</form><br><br><br>
	<% if((request.getAttribute("theatreId") != null) && (request.getAttribute("screenId") != null) && (request.getAttribute("showId") != null)){ %>
			<input type="button" id="myBtn" value="Proceed to Pay" onclick="proceedToPay()">
	<%}else{ %>		
			<input type="button" id="myBtn" value="Proceed to Pay" disabled>
			<!-- <button onclick="proceedToPay()" diabled>Proceed to Pay</button> -->
	<%} %>
	</center>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div> 
</body>
</html>