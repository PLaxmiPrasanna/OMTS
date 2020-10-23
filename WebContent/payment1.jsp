<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Payment Checkout Form</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css">
	<link rel="stylesheet" href="paymentstyles.css">
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
	font-size: 170%;
}
a {
	float: left;
}
.header a:hover {
	background-color: #a89e8a;
	font-size: 170%;
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
  

<div class="footer">
  <span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
    India Pvt Ltd.
</div>
<div class="wrapper">
  <div class="payment">
    <div class="payment-logo">
      <p>p</p>
    </div>
    
   

    <h2> Make Payment </h2>
    <form action="paymentController" method ="post">
      
<input type = "hidden" value=<%=request.getAttribute("ticketId")%> name = "ticketId">
<input type = "hidden" value=<%=request.getAttribute("theatreId") %> name = "theatreId">
<input type = "hidden" value=<%=request.getAttribute("movieId") %> name = "movieId">
<input type = "hidden" value=<%=request.getAttribute("showId") %> name = "showId">
<input type = "hidden" value=<%=request.getAttribute("screenId") %> name = "screenId">
<input type = "hidden" value=<%=request.getAttribute("totalPrice") %> name = "totalPrice">

    <div class="form">
      <div class="card space icon-relative">
        <label class="label">Account Number:</label>
        <input type="text" class="input" placeholder="Account Number" name="acc" pattern="^[0-9]{10}$" title="Account number should be of 10 digits" required>
        <i class="fas fa-user"></i>
      </div>
      <div class="card space icon-relative">
        <label class="label">Password:</label>
        <input type="password" class="input" placeholder="Password" name="pass" required>
        <i class="fas fa-lock"></i>
      </div>
      <div class="card-grp space">
        <div class="card-item icon-relative">
          <label class="label">Amount to be paid</label>
          <input type="text" name="expiry-data" class="input" name = "totalPrice" value = <%=request.getAttribute("totalPrice") %>  readonly>
          <i class="far fa-credit-card"></i>
        </div>
        <div class="card-item icon-relative">
          <label class="label">CVV:</label>
          <input type="password" class="input" data-mask="000" placeholder="000" name="cvv" pattern="^[0-9]{3}$" title="CVV should be of 3 digits"required>
          <i class="fas fa-lock"></i>
        </div>
      </div>
        <%if(request.getAttribute("message") != null){%>
 <center><h3 style="color:red;"><%=request.getAttribute("message")	%></h3></center>
<%} %>
      <button class="btn" type="submit" >  <!-- onClick="document.forms[0].submit()" -->
        Pay
      </button> 
      
    </div>
    </form>
  </div>
</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

</body>
</html>