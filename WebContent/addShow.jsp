<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Theatre</title>
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
  padding: 0px 10px;
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
 height: 100vh;
 margin:0;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
#header ul li {
    display:block;
    padding:20px;
}
table.center {
  margin-left:auto; 
  margin-right:auto;
  border-spacing: 60px 15px;
}
td {
  text-align: left; 
  vertical-align: middle;
  font-size:25px;
  
}
.submit {
background-color: black;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  border-radius: 20px;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
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
  <a href="adminHomePage.jsp" class = "back" align="right">
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
      } 
%>
<h1 style="color:red">
<center>
<% if(request.getAttribute("message")!=null) { %>
<%=request.getAttribute("message") %>
<%} %>
</center>
</h1>
<br>
<br>
<h1><center> Enter Theatre Details to Register</center> </h1>
<br>
<div >
<form method="post" action="./AddTheatreController">
<table class ="center">
<tr>
<td>Enter Theater id : 
</td>
<td>
<input type="text" name = "theatreId" pattern="[2]{1}[0-9]{3}" title="Theatre Id should start with number 2 and of only 4 digits" required>
</td>
</tr>
<tr>
<td>
Enter Theater name :  
</td>
<td>
<input type="text" name="theatreName" pattern= "[a-zA-Z]{1,}" title="Enter only alphabets" required>
</td>
</tr>
<tr>
<td>
Enter Theater city: 
</td>
<td>
<input type="text" name = "theatreCity" pattern="[a-zA-Z]{1,}" title="Enter only alphabets" required>
</td>
</tr>
<tr>
<td>
Enter Manager name: 
</td>
<td>
<input type="text" name="managerName" pattern="[a-zA-Z]{1,}" title="Enter only alphabets" required>
</td>
</tr>
<tr>
<td>
Enter Manager contact: 
</td>
<td>
<input type="text" name="managerContact" pattern="[1-9]{1}[0-9]{9}" title="Enter 10 digit phone number" required>
</td>
</tr>
<tr>
<td colspan="2" style="text-align:center">
<input type="submit" class="submit" value = "Register Theatre">
</td>
</tr>
</table>
</form>
</div>
<div class="footer">
  <span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Ltd.
</div>
</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Show</title>
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
<h1>Enter Details to Register Show</h1>
<%if(request.getAttribute("message")!= null)  { %>
<h1><%= request.getAttribute("message")%></h1>
<%} %>
<br>
<form method="post" action="./AddShowServlet">
Enter Show Id : 
<input type="text" name="showId" pattern="[5]{1}[0-9]{3}" title="Show Id should start with number 5 and of only 4 digit" required>
<br>
<br>
Enter Show Name:<select id="showType" name="showName" onchange="myFunction()">
 <option value="" selected disabled hidden>Choose here</option>
<option value="morning show">Morning</option>
<option value="matinee show">Matinee</option>
<option value="first show">First show</option>
<option value="second show">Second Show</option>
</select>
<br>

<br>
Enter Show Start Time:
<input type="time" id="stime" name="stime" required>
<br>
<br>
Enter Theatre Id:
<input type="text" name="theatreId" pattern="[2]{1}[0-9]{3}" title="Theatre ID should start with number 2 and of only 4 digits" required>
<br>
<br>
Enter Movie Id :
<input type="text" name="movieId" pattern="[3]{1}[0-9]{3}" title="Movie ID should start with number 3 and of only 4 digits" required>
<br>
<br>
Enter Screen Id :
<input type="text" name="screenId"pattern="[4]{1}[0-9]{3}" title="Screen ID should start with number 4 and of only 4 digits" required>
<br>
<br>
<input type="submit" value="Enter Show">
</form>
<script type="text/javascript">
function myFunction() {
  var x = document.getElementById("showType").value;
  console.log(x);
  if(x==='morning show') {
	  document.getElementById("stime").min="06:00"
	  document.getElementById("stime").max="09:00"
  } else if(x==='matinee show') {
	  document.getElementById("stime").min="10:00"
	  document.getElementById("stime").max="14:00"
  } else if(x==='first show') {
	  document.getElementById("stime").min="15:00"
	  document.getElementById("stime").max="19:00"
  } else {
	  document.getElementById("stime").min="20:00"
	  document.getElementById("stime").max="23:00"
  }
  //document.getElementById("num").min=89;
  //document.getElementById("starttime").min="07:00"
}
</script>

</body>
</html> --%>