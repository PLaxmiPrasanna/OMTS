<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	background-color: #ffff1a;
	border-collapse: collapse;
	width: 40%;
	height: 20%
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
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
      }
else if(session.getAttribute("roleCode").equals("usr")){
	  response.sendRedirect("userhome.jsp");
}
%>
</form>
	<div class="header">
		   
		  	
			<a href="LogoutServlet" class = "logout" align="right"><b>Logout</b></a>
			<a href="adminHomePage.jsp" class = "back" align="left">
		  	<img src="backbutton.png" alt="back button" style="width:20px;height:25px;border:0;">
		    </a>
	</div> 

	<%
		String message = (String)request.getAttribute("message");
		if(message != null)
			out.print(message);
	%>
	</br></br></br>
	<form method = "post" action = "AddScreenServlet" align = "center">
		<table align = "center">
			<caption><h2>Enter the Screen Details</h2></caption>
			<tr><td style = "text-align:center">Screen Id<td><center><input type="text" name = "screenId"  pattern="^[4]{1}[0-9]{3}$" title="Screen Id should start with number 4 and of only 4 digits" required></center>
			<tr><td style = "text-align:center">Screen Name<td><center><input type = "text" name = "screenName" pattern = "^[a-zA-Z0-9]+[a-zA-Z0-9 ]+$" title = "Screen Name must contain letters and digits only" required></center>
			<tr><td style = "text-align:center">Screen Rows<td><center><input type = "text" name = "screenRows" pattern="^[1-9]{1}[0-9]{1}$" title="Screen rows should consist digits only and with max 99 rows" required></center>
			<tr><td style = "text-align:center">Screen Columns<td><center><input type = "text" name = "screenColumns" pattern="^[1-9]{1}[0-9]{1}$" title="Screen columns should consist digits only and with max 99 coulumns"required></center>
			<tr><td style = "text-align:center">Screen Seat Price<td><center><input type = "text" name = "seatPrice" pattern="^[1-9]{1}[0-9]{1,}$" title="Screen Price should a number" required></center>
			<!-- <tr colspan="2" align = "centre"><td><input type = "submit" value = "Submit"> -->	
		</table>
		<button type = "submit" class="btn"> Submit </button>
	</form>
	<div class="footer" style="font-size: 20px">
<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini India Ltd.
</div>
</body>
</html>