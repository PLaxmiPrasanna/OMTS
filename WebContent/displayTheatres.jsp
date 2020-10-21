<%@page import="com.cg.omts.service.IMovieTheatreService"%>
<%@page import="com.cg.omts.service.MovieTheatreServiceImpl"%>
<%@page import="com.cg.omts.dto.Theatre"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.service.AdminServiceImpl"%>
<%@page import="com.cg.omts.dao.AdminDaoImpl"%>
<%@page import="com.cg.omts.service.IAdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
* {box-sizing: border-box;}


body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
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
	font-size: 80%;
}
.header {
  overflow: hidden;
  background-color: #291f04;
  padding: 13px 10px;
}

.header a {
  float: left;
  color: white;
  text-align: center;
  padding: 10px;
  text-decoration: none;
  font-size: 30px; 
  line-height: 35px;
  border-radius: 4px;
}

img{
  width:25%;
  float:left;
  display: inline-block;
}
/*.header a:hover {
  background-color: #ddd;
  color: black;
}*/

.header-right a:hover {
  float: right;
  right:55px;
  background-color: #ddd;
  color: black;
}
.header-right {
float: right;
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
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	color: white;
	background-color: #291f04;
	margin-top: 100%;
	width: 100%;
	height: 5%;
	font-size: 20px;
	text-align: center;
}
body {
 background-image:url('images/background.jpg');
  background-repeat:repeat-y;
 height: 100vh;
 margin:0;
	background-position: center;
	background-size: cover;
	overflow: scroll;
}

#header ul li {
    display:block;
    padding:20px;
}

table {
    border-spacing: 0;
    width:70%;
    margin-left:auto; 
    margin-right:auto;
    
}
th, td {
    /*border: 1px solid #171a18;*/
    padding: 0.5em 1em;
    border: solid black 2px;
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


</style>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  if(session.getAttribute("username")==null)
      response.sendRedirect("index.jsp");
  %> 
<div class="header">
  <a href="addTheatre.jsp" class = "back" align="right">
		  	<img src="images/backbutton.png" alt="back button" style="width:60px;height:55px;border:0;">
		    </a>
  <ul>
  <div class="header-right">
    <li><a class="active" href="./adminHomePage.jsp">Home</a></li>
				<% if (session.getAttribute("username") != null) {
			            int id = (Integer)session.getAttribute("username");
			            System.out.println("session id "+ id); 
					%><li><a href="./LogoutServlet" id="logout"> Logout</a></li><%
					 }%>
					</a></li>
  </div>
  </ul>
</div>
<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
         }
      } 
%>

<h1>
<center>
<% if(request.getAttribute("message")!=null) { %>
<%= request.getAttribute("message") %>
<%} %>
</center>
</h1>
<h1>
<center>List of Theatres</center> </h1>
<br>
<table  border=1>

<%//IAdminService adminService = new AdminServiceImpl();
//List<Theatre> theatreList = adminService.getTheatreDetails();
IMovieTheatreService movieTheatreService = new MovieTheatreServiceImpl();
List<Theatre> theatreList = movieTheatreService.getTheatreDetails();
%>
<thead>
<tr>
<td>Theatre Id</td>
<td>Theater Name</td>
<td>Theater City</td>
<td>Theater Manager Name</td>
<td>Theater Manager Contact</td>
</tr>
</thead>
<tbody>
<tr>
<%for(Theatre theatre: theatreList) {
%>
<td>
<%=theatre.getTheatreId() %>
</td>
<td>
<%=theatre.getTheatreName() %>
</td>
<td>
<%=theatre.getTheatreCity() %>
</td>
<td>
<%=theatre.getManagerName() %>
</td>
<td>
<%=theatre.getManagerContact() %>
</td>
</tr>
<%} %>
</tbody>
</table>
<br>
<br>
<br>
<br>
<br>
<div class="footer">
  <span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
</div>
</body>
</html>
<%-- <%@page import="com.cg.omts.dto.Theatre"%>
<%@page import="java.util.List"%>
<%@page import="com.cg.omts.service.AdminServiceImpl"%>
<%@page import="com.cg.omts.dao.AdminDaoImpl"%>
<%@page import="com.cg.omts.service.IAdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
      } 
%>
<form action="./LogoutServlet" method="post">
      <input type="submit" value="Logout">
</form>
<h1>
<% if(request.getAttribute("message")!=null) { %>
<%= request.getAttribute("message") %>
<%} %>
</h1>
<h1>List of Theatres </h1>
<br>
<table  border=1>

<%IAdminService adminService = new AdminServiceImpl();
List<Theatre> theatreList = adminService.getTheatreDetails();
%>
<tr>
<td>Theatre Id</td>
<td>Theater Name</td>
<td>Theater City</td>
<td>Theater Manager Name</td>
<td>Theater Manager Contact</td>
</tr>
<tr>
<%for(Theatre theatre: theatreList) {
%>
<td>
<%=theatre.getTheatreId() %>
</td>
<td>
<%=theatre.getTheatreName() %>
</td>
<td>
<%=theatre.getTheatreCity() %>
</td>
<td>
<%=theatre.getManagerName() %>
</td>
<td>
<%=theatre.getManagerContact() %>
</td>
</tr>
<%} %>
</table>
</body>
</html> --%>