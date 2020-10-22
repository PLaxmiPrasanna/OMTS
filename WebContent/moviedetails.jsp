<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MovieDetails</title>
<style>
body {
	margin:0;
}


.header a.logout {
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


.header a.logout:hover {
	background-color: #a89e8a;

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
.header a.back{
	float : left;
	padding: 15px 15px;
}
.bgpic {
	background-image: url("background.jpg");
	height: 100vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
table {
	background-color: #ffff1a;
	border-collapse: collapse;
	width: 40%;
	height: 30%;
	font-size:18px;
}

th, td {
	padding: 8px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: grey;
}
.btn {
  margin-bottom:10%;
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
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

</style>
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
			<a href="userhome.jsp" class = "back" align="left">
		  	<img src="backbutton.png" alt="back button" style="width:20px;height:25px;border:0;">
		    </a>
	</div> 
	<br><br><br><br>
	<div class="display">
	<table align="center" border=1>
	<caption><h1>Movie Details</h1></caption>
	<tr><th>Movie Id</th><td><c:out value="${movie.movieId}" /></td></tr>
	<tr><th>Movie Name</th><td><c:out value="${movie.movieName}"/></td></tr>
	<tr><th>Movie Genre</th><td><c:out value="${movie.movieGenre}" /></td></tr>
	<tr><th>Movie Director</th><td><c:out value="${movie.movieDirector}" /></td></tr>
	<tr><th>Movie Length</th><td><c:out value="${movie.movieLength}" /></td></tr>
	<tr><th>Language</th><td><c:out value="${movie.language}" /></td></tr>
	<tr><th>Movie Release Date</th><td><c:out value="${movie.movieReleaseDate}" /></td></tr>
	</table>
	</div>
	<br>
	<center><div align="center">
		<a href="booking.jsp?movieId=${movie.movieId}" class="btn">BOOK TICKET</a>
	</div></center>
	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
	</div>
</body>
</html>