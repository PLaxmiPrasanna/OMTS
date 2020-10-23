<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<style>
* {
	padding: 0px;
	margin: 0px;
}

.bgpic {
	background-image: url("background.jpg");
	height: 100vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
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

.header {
	overflow: hidden;
	background-color:#291f04;
	padding: 0px 10px;
	opacity: 1;
}

.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 28px;
	line-height: 50px;
	border-radius: 4px;
}

.header a.logo {
	weight: 10;
	font-size: 50px;
}



.header a.active {
	
	color: white;
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

.input {
	width: 170px;
	height: 30px;
	border-radius: 10px;
	background: rgba(255, 255, 255, .1);
	font-size: 15px;
}


.btn {
  margin-bottom:10%;
  align: center;
  background-color: #291f04;
  border: none;
  border-radius: 16px;
  color: white;
  margin-left: -20px;
	margin-top: 40px;
  padding: 12px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}
.btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}
.img {
	width: 5%;
	height: 5%;
	margin-left: 95%;
	border-radius: 10%;
	position: relative;
	cursor: pointer;
}

.cross-button {
	width: 50px;
}

.caption {
	font-style: italic;
	font-size: 30px;
	margin-bottom: 20px;
	margin-top: 10px;
}

.caption-image {
	position: absolute;
	width: 20%;
	height: 20%;
	border-radius: 20%;
	left: 40%;
	top: -11%;
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
	width: 50%;
	margin-left: 20%;
	margin-top: 15%;
}

b {
	color: white;
}
img{
  width:65%;
  height:65%;
  float:left;
  padding: 0px 0px;
  margin-top:0%;
}
.errormessage {
	color: red;
	position: absolute;
	top: 20%;
	left: 40%;
	font-size: 150%;
}
</style>

<meta charset="ISO-8859-1">
<title>Home Page</title>

<script type="text/javascript">
	function login() {
		document.getElementById("log").style.display = "block";
	}

	function cross() {
		document.getElementById("log").style.display = "none";
	}

	//window.history.forward();
	//function noBack() {
		//window.history.foward();
	//}
</script>

</head>
<body class="bgpic">

	<div class="header">

		<ul>
			<li> <a class="logo"><img src="loggo.PNG" ></img></a></li>
			<div class="header-right">
				
				<% if (session.getAttribute("username") == null) {
					
			            %><li><a href="getstarted.html" class="active"><b>Home </b></a></li>
			            <li> <a class="active" href="register.jsp" > <b>Register</b></a></li> <%
					}  else {%>
					 <% }%>
				<% if (session.getAttribute("username") != null && session.getAttribute("roleCode") == "usr") {
			            int id = (Integer)session.getAttribute("username");
			            System.out.println("session id "+ id); 
			            
					%><li><li><a href="userhome.jsp" class="active"><b>Home </b></a></li>
					<a class="active" href="./LogoutServlet" id="logout"> <b>Logout</b></a></li><%
					}  else if(session.getAttribute("username") != null && session.getAttribute("roleCode") == "adm"){
							int adminId = (Integer)session.getAttribute("username");
		           			System.out.println("session id "+ adminId); 
		            
				%><li><li><a href="adminHomePage.jsp" class="active"><b>Home </b></a></li>
				<a class="active" href="./LogoutServlet" id="logout"> <b>Logout</b></a></li><%
					} else {%>
					<li><a class="active" href="#" onclick="login()" id="login"> <b>Login
					 <% }%>
					</b></a></li>
				<li><a href="about.html" class="active"><b>About US </b></a></li>

			</div>
		</ul>
	</div>
	<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  %> 
  <% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
            %><%= session.getAttribute("username")%> <%    
         }
      } 
%>
	
<% if(request.getAttribute("logout")!=null) {%>
<center><h1 style="color:Green;"><%=request.getAttribute("logout") %></h1></center>
<%} %>
<% if(request.getAttribute("errormessage")!=null) {%>
<center><h1 style="color:Red;"><%=request.getAttribute("errormessage") %></h1></center>
<%} %>
<% if(request.getAttribute("message") != null){ %>
<center><h1 style="color:Red;"><%=request.getAttribute("message") %></h1></center>
<%} %>

	<div class="loginform" id="log">
		<img src="cross.png" class="img" onclick="cross()">

		<table style="margin-top: 30%;">
			<caption>
				<img src="caption1.png" class="caption-image">
			</caption>
			<br>
			<form action="./LoginServlet" method="post">
				<tr>
					<td><b>UserId:</b></td>
					<td><input type="text" name="user" class="input" pattern="^[1]{1}[0-9]{3}$" title = "User Id should start with 1, should contain numbers only with length 4" required></td>
				</tr>

				<tr>
					<td><b>Password:</b></td>
					<td><input type="Password" name="pass" class="input" required></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit" class="btn">
							<b>Login</b>
						</button></td>
				</tr>
			</form>
		</table>

	</div>

	<div class="footer" style="font-size: 20px">
		<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
		India Pvt Ltd.
	</div>
</body>
</html>