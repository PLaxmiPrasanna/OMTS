package com.cg.omts.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	final static Logger LOGGER = Logger.getLogger(LogoutServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  HttpSession session = request.getSession(false);
	      
	     session.removeAttribute("name");
	     session.invalidate();
	     request.setAttribute("logout", "Successfully logged out");
	     RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	     rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 HttpSession session = request.getSession(false);
	     
	     session.removeAttribute("username");
	   
	     session.invalidate();
	     request.setAttribute("logout", "Successfully logged out");
	     RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	     rd.forward(request, response);
	}

}
