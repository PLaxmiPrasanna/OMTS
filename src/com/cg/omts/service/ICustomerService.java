package com.cg.omts.service;

import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;

public interface ICustomerService {

	/*******
	 @Description : To validate login
	 @author  : Ashutosh
	 @param : customer object
	 @return : roleCode
	 @Exception : throws OMTSException
	********/
	public String validateLogin(Customer customer) throws OMTSException;
	
	/*******
	 @Description : To register a new user
	 @author  : Ashutosh
	 @param : customer object
	 @return : number of users added
	 @Exception : throws OMTSException
	********/
	public int register(Customer customer) throws OMTSException;
}
