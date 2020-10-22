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
  else if(session.getAttribute("roleCode").equals("usr")){
	  response.sendRedirect("userhome.jsp");
  }
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
<input type="text" name="theatreName" pattern= "^[a-zA-Z0-9]+[a-zA-Z0-9 ]+$" title="Theatre Name can consists of alphabets and numbers" required>
</td>
</tr>
<tr>
<td>
Enter Theater city: 
</td>
<td>
<input type="text" name = "theatreCity" pattern="^[a-zA-Z0-9]+[a-zA-Z0-9 ]+$" title="Theatre city can consists of alphabets and numbers" required>
</td>
</tr>
<tr>
<td>
Enter Manager name: 
</td>
<td>
<input type="text" name="managerName" pattern="^[a-zA-Z0-9]+[a-zA-Z0-9 ]+$" title="Enter only alphabets" required>
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
