<%@page import="com.cg.omts.service.MovieTheatreServiceImpl"%>
<%@page import="com.cg.omts.dao.MovieTheatreDaoImpl"%>
<%@page import="com.cg.omts.service.IMovieTheatreService"%>
<%@page import="com.cg.omts.dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserHome </title>
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
table {
	background-color: #ffff1a;
	border-collapse: collapse;
	font-size:18px;
	width: 50%;
	height: 20%
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: grey;
}

.selectclass {
	width:250px;
	height:35px;
	margin-top:2%;
	margin-left:70%;
	font-size:15px;
	background-color:#e3dddc;
}
</style>
<script>
	function selectCity() {
		var city= document.getElementById('city').value;
		 window.location.href="./DisplayMoviesToUser?city="+city;
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

<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int userId = (Integer)session.getAttribute("username");
         }
      }
%>
</form>
	 <div class="header">
	 		
	 		<a href="LogoutServlet" class = "logout" align="right"><b>Logout</b></a>
			<a href="ViewBookingController" class="active" ><b>My Bookings</b></a>
		    <a href="userhome.jsp" class="active" ><b>User Home </b></a>
		  	
		    
	</div> 
	
	

	<div class="userhome" id="userhome">
	<form action="/DisplayMoviesToUser" method="get" align="center">
		<select name="city" id="city" onchange="selectCity()" class="selectclass" align = "center">
		<option value="-1" selected disabled align="center">Select city</option>
		<option value="All Cities" align="center">ALL CITIES</option>
		<option value="Hyderabad" align="center">HYDERABAD</option>
		<option value = "Warangal" align="center">WARANGAL</option>
		<option value = "Nizambad" align="center">NIZAMBAD</option>
		</select>
		</br></br>
	<table align="center" border=1>
	<tr><th style="text-align:center">Movie</th><th style="text-align:center">Movie Details</th></tr>
	  		<% 
	  		IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
	  		
			List<Movie> moviesList = movieTheatreService.getAllMovies();
			for(Movie movie : moviesList) {
			String movieName = movie.getMovieName();
			int movId = movie.getMovieId();
			%>
	
	<tr><td style="text-align:center"><%= movieName%></th><td><center><a href="MovieDetailsServlet?movieId=<%= movId%>" >View Movie Details</a></center></td></tr>
	<% } %>
	</table> 
	</form>
	</div>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div> 
</body>
</html>