
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Payment</title>
</head>
<body class = "bgpic">
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
<form action ="paymentController" method ="post">

<input type = "hidden" value=<%=request.getAttribute("ticketId")%> name = "ticketId">
<input type = "hidden" value=<%=request.getAttribute("theatreId") %> name = "theatreId">
<input type = "hidden" value=<%=request.getAttribute("movieId") %> name = "movieId">
<input type = "hidden" value=<%=request.getAttribute("showId") %> name = "showId">
<input type = "hidden" value=<%=request.getAttribute("screenId") %> name = "screenId">
<%if(request.getAttribute("message") != null){%>
	<%=request.getAttribute("message")	%>
<%} %>
<br><br><br><br><br>
<table align="center">

<tr><td>Account Number<td><input type="number" name="acc"  pattern="^[0-9]{10}$" title="Account number should be of 10 digits"required>
<tr><td>Cvv<td><input type="number" name="cvv"  pattern="^[0-9]{3}$" title="CVV should be of 3 digits"required>
<tr><td>Password<td><input type="password" name="pass" required>
<tr><td>Total Amount<td><input type = "text" name = "totalPrice" value = <%=request.getAttribute("totalPrice") %> readonly>
<br><br><tr><td><td><input type ="submit" value="PAY">
</table>
</form>
<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>