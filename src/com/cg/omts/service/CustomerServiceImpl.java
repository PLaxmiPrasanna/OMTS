package com.cg.omts.service;

import com.cg.omts.dao.ICustomerDao;
import com.cg.omts.dao.CustomerDaoImpl;
import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;

public class CustomerServiceImpl implements ICustomerService{

	ICustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public String validateLogin(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		return customerDao.validateLogin(customer);
	}

	@Override
	public int register(Customer customer) throws OMTSException {
		// TODO Auto-generated method stub
		return customerDao.register(customer);
	}

}
