package com.cg.omts.dao;

import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;

public interface ICustomerDao {

	public String validateLogin(Customer customer) throws OMTSException;
	
	public int register(Customer customer) throws OMTSException;
	
}
