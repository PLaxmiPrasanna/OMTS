package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.CustomerServiceImpl;
import com.cg.omts.service.ICustomerService;

public class LoginTest {
	ICustomerService customerService = new CustomerServiceImpl();
	
	@Test
	public void loginTestUser() throws OMTSException
	{
		String validate ="usr";
		Customer user = new Customer(54321, "usr");
		String result= customerService.validateLogin(user);
		assertEquals(validate,result);
	}
	
	@Test
	public void registerTest() throws OMTSException
	{
		int rows=1;
		Date d=Date.valueOf("2001-12-12");
		Customer user = new Customer(2, "Ashutosh", "hi@123", d, "1234567892", "usr");
		int isRegistered = customerService.register(user);
		assertTrue(isRegistered > 0);
	}
	
	@Test
	public void loginTestAdmin() throws OMTSException
	{
		String validate ="adm";
		Customer user = new Customer(12345, "adm");
		String result= customerService.validateLogin(user);
		assertEquals(validate,result);
	}
}
