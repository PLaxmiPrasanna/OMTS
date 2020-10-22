<%@page import="com.cg.omts.service.ScreenShowServiceImpl"%>
<%@page import="com.cg.omts.service.IScreenShowService"%>
<%@page import="com.cg.omts.dto.Show"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Shows</title>
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
 background-image:url('background.jpg');
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
    width:90%;
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
  <a href="addShow.jsp" class = "back" align="right">
		  	<img src="backbutton.png" alt="back button" style="width:20px;height:25px;border:0;">
		    </a>
  <ul>
  <div class="header-right">
    <li><a class="active" href="#home">Home</a></li>
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
         else if(session.getAttribute("roleCode").equals("usr")){
       	  response.sendRedirect("userhome.jsp");
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
<center>
<h1>List of Shows </h1>
</center>
<table  border=1>

<%//IAdminService adminService = new AdminServiceImpl();
//List<Show> showList = adminService.getShowDetails();
IScreenShowService screenShowService = new ScreenShowServiceImpl();
List<Show> showList = screenShowService.getShowDetails();
%>
<thead>
<tr>
<td>
Show Id
</td>
<td>
Show Start Time
</td>
<td>
Show end Time
</td>
<td>
Show Name
</td>
<td>
Movie Name
</td>
<td>
Screen Id
</td>
<td>
Theatre Id
</td>
<td>
Movie Id
</td>
</tr>
</thead>
<tbody>
<tr>
<%for(Show show: showList) {
%>
<td>
<%=show.getShowId() %>
</td>
<td>
<%=show.getShowStartTime() %>
</td>
<td>
<%=show.getShowEndTime() %>
</td>
<td>
<%=show.getShowName() %>
</td>
<td>
<%=show.getMovieName() %>
</td>
<td>
<%=show.getScreenId() %>
</td>
<td>
<%=show.getTheatreId() %>
</td>
<td>
<%=show.getMovieId() %>
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
