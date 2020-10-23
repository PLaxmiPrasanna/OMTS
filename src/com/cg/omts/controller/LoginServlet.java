package com.cg.omts.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.ICustomerService;
import com.cg.omts.service.CustomerServiceImpl;

import org.apache.log4j.Logger;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	final static Logger LOGGER = Logger.getLogger(LoginServlet.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int userId=Integer.parseInt(request.getParameter("user"));
		String password=request.getParameter("pass");
		ICustomerService loginRegisterService = new CustomerServiceImpl();
		Customer customer = new Customer(userId, password);
		RequestDispatcher dispatcher =null;
		try {
			String roleCode = loginRegisterService.validateLogin(customer);
			if(roleCode.equals("adm"))
			{
				LOGGER.info("Logged in as Admin");
				HttpSession session = request.getSession(true);
				session.setAttribute("username", customer.getCustomerId());
				session.setAttribute("roleCode", "adm");
				System.out.println("Admin");
				response.sendRedirect("adminHomePage.jsp");
			
			}
			else if(roleCode.equals("usr"))
			{
				LOGGER.info("Logged in as User");
				HttpSession session = request.getSession(true);
				session.setAttribute("username", customer.getCustomerId());
				session.setAttribute("roleCode", "usr");
				dispatcher= request.getRequestDispatcher("userhome.jsp");
				dispatcher.forward(request, response);
				System.out.println("User");
			} else  {
				LOGGER.info("Invalid Credentials");
				request.setAttribute("errormessage", "Invalid Credentials!!");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		        rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.warn("Exception occured");
			response.sendRedirect("error.jsp");
		}
		
	}

}
