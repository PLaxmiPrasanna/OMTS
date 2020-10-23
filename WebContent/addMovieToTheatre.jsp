<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie To Theatre</title>
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
    border-spacing: 0;
    width:30%;
    margin-left:40px; 
    margin-right:auto;
    
}
th, td {
    /*border: 1px solid #171a18;*/
    padding: 0.5em 1em;
    border: solid black 2px;
    text-align: center;
}

thead tr:first-child th:first-child {
    border-radius: 0.6em 0 0 0;
    border: solid black 2px;
 
    
}

thead tr:first-child th:last-child {
    border-radius: 0 0.6em 0 0;
}

tbody tr:last-child td:first-child {
    border-radius: 0 0 0 0.6em;
    
}
 
tbody tr:last-child td:last-child {
    border-radius: 0 0 0.6em 0;


}

thead {
 font-size:30px;
 background-color: #75f542;
}
tbody {
font-size:20px;
background-color:white;
}
 th, td{
  padding: 8px;
  text-align: left;
 border: solid black 2px;
}

tr:hover {background-color:#d1cdd1}
body {
background-image: url("bg1.jpg");

}

	
	.selectclass {
	width:250px;
	height:35px;
	margin-right:81%;
	font-size:15px;
	background-color:#e3dddc;
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

table.leftTable {
	margin-left:140px;
}

table.rightTable {
	margin-right:140px
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

  %>

<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
         }
         else if(session.getAttribute("roleCode").equals("usr")){
       	  response.sendRedirect("userhome.jsp");
         }
      }
%>
</form>
	<div class="header">
		   
		  	
			<a href="LogoutServlet" class = "logout" align="right"><b>Logout</b></a>
			<a href="getTheatreDetails.jsp" class = "back" align="left">
		  	<img src="backbutton.png" alt="back button" style="width:20px;height:25px;border:0;">
		    </a>
	</div> 
	</br>
	<form method = "post" action = "AddMovieToTheatre" align = "center">
		<input type = "hidden" name = "theatreCity" value = <%=request.getAttribute("theatreCity") %>>
		<input type = "text" name = "theatreId" placeholder = "Enter Theatre ID" pattern="^[2]{1}[0-9]{3}$" title="Theatre ID should start with number 2 and of only 4 digits"required></br>
		<input type = "text" name = "movieId" placeholder = "Enter Movie ID" pattern="^[3]{1}[0-9]{3}$" title="Movie ID should start with number 3 and of only 4 digits"required></br>
		<!-- <input type = "submit" class="btn" value = "Submit"></br></br> -->
		<button type = "submit" class="btn"> Submit </button>
	
	<c:if test="${theatreDetails != null}">
		<table border="1"  align = "left" class="leftTable">
			<caption><h3>Theatre Details</h3></caption>
			<thead><tr><th>Theatre ID<th>Theatre Name</tr></thead>
			
					<c:forEach items="${theatreDetails}" var="details"> 
							<tr>
					<td><c:out value = "${details.theatreId}"></c:out>
					<td><c:out value = "${details.theatreName}"></c:out>
										
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${movieDetails != null}">
		<table border="1" align = "right" class="rightTable">
			<caption><h3>Movie Details</h3></caption>
			<thead><tr><th>Movie ID<th>Movie Name</tr></thead>
			
					<c:forEach items="${movieDetails}" var="details"> 
							<tr>
					<td><c:out value = "${details.movieId}"></c:out>
					<td><c:out value = "${details.movieName}"></c:out>
										
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	</form>
	<div class="footer" style="font-size: 20px">
<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini India Pvt Ltd.
</div>
</body>
</html>