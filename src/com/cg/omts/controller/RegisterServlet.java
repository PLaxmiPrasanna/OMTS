package com.cg.omts.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.ICustomerService;
import com.cg.omts.service.CustomerServiceImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		try {
			String customerName = req.getParameter("name");
			int customerId = Integer.parseInt(req.getParameter("custid"));
			String customerPassword = req.getParameter("pass");
			String dateOfBirth = req.getParameter("custdob");
			String customerContact = req.getParameter("contact");
			String roleCode = "usr";
			RequestDispatcher rd;
			Date date = java.sql.Date.valueOf(dateOfBirth);
			Customer customer = new Customer(customerId, customerName, customerPassword, date, customerContact,
					roleCode);
			ICustomerService customerService = new CustomerServiceImpl();
			
			int rows = 0;
			rows = customerService.register(customer);
			if (rows > 0) {
				// out.println("<h2> Customer added succesfully</h2>");
				req.setAttribute("message", "User registered successfully");
				rd = req.getRequestDispatcher("./index.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("errorMessage", "Could not register try again");
				rd = req.getRequestDispatcher("./register.jsp");
				rd.forward(req, resp);
			}
			// rows=admin.register(customer);
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
