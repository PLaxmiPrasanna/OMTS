<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
  else if(session.getAttribute("roleCode").equals("usr")){
	  response.sendRedirect("userhome.jsp");
  }

  %>

<% if (session != null) {
         if (session.getAttribute("username") != null) {
            int id = (Integer)session.getAttribute("username");
         }
      }
%>
</form>
	<div class="header">
		   
		  	
			<a href="LogoutServlet" class = "logout" align="right"><b>Logout</b></a>
			<a href="getTheatreScreenDetails.jsp" class = "back" align="left">
		  	<img src="backbutton.png" alt="back button" style="width:20px;height:25px;border:0;">
		    </a>
	</div> 
	
	</br></br></br></br>
		<form method = "post" action = "SelectTheatreIdDetails" align = "center">
		<input type = "hidden" name = "seatPrice" value = <%= request.getAttribute("seatPrice") %>>
		<input type = "hidden" name = "theatreCity" value = <%=request.getAttribute("theatreCity") %>>
		Theatre ID: <input type = "text" name = "theatreId" placeholder = "Enter Theatre ID" pattern="[2]{1}[0-9]{3}" title="Theatre Id should start with number 2 and of only 4 digits" required></br>
			<button type = "submit" class="btn"> Submit </button></br>
			
	<c:if test="${theatreDetails != null}">
		<table border="1" align = "center">
			<caption><h2>Theatre Details</h2></caption>
			<tr><th style="text-align: center">Theatre ID<th style="text-align: center">Theatre Name</tr>
			
					<c:forEach items="${theatreDetails}" var="details"> 
							<tr>
					<td style="text-align: center"><c:out value = "${details.theatreId}"></c:out>
					<td style="text-align: center"><c:out value = "${details.theatreName}"></c:out>
										
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	</form>
	<div class="footer" style="font-size: 20px">
<span style="font-size: 15px">&#9400;</span> Copyrights Capgemini
India Pvt Ltd.
</div>
</body>
</html>