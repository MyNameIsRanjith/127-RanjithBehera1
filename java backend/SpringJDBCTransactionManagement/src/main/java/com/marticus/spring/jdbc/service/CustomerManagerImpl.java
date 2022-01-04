package com.marticus.spring.jdbc.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import  org.springframework.transaction.annotation.Propagation;
import com.marticus.spring.jdbc.dao.CustomerDAO;
import com.marticus.spring.jdbc.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional 
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}

}
