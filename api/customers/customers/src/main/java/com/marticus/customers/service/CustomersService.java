package com.marticus.customers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticus.customers.entity.CustomersEntity;
import com.marticus.customers.repo.CustomersRepository;

@Service
public class CustomersService {
	
	@Autowired
	CustomersRepository customersRepository;
	
	public void saveCustomer(CustomersEntity cust1) {
		// TODO Auto-generated method stub
		customersRepository.save(cust1);
	}

	public CustomersEntity findCustomersById(long id) {
		// TODO Auto-generated method stub
		return customersRepository.findCustomersById(id);
	}

	public List<CustomersEntity> findAllCustomers() {
		// TODO Auto-generated method stub
		return customersRepository.findAll();
	}

	public Boolean deleteCustomersById(long id) {
		// TODO Auto-generated method stub
		CustomersEntity cust2=customersRepository.findCustomersById(id);
		if(cust2!=null)
		{
			customersRepository.delete(cust2);
			return true;
		}
		return false;
	}

	public void updateCustomers(CustomersEntity custupdate) {
		// TODO Auto-generated method stub
				CustomersEntity custNew=customersRepository.findCustomersById(custupdate.getId());
		custNew.setCustName(custupdate.getCustName());
		custNew.setCustNumber(custupdate.getCustNumber());
		custNew.setCustAddress(custupdate.getCustAddress());
		customersRepository.save(custNew);		
	}
	
	public List<CustomersEntity> findCustomersByName(String name) {
		// TODO Auto-generated method stub	
		return customersRepository.findCustomersByCustName(name);
	 
	}

	public List<CustomersEntity> findCustomersByCustNameLike(String name) {
		// TODO Auto-generated method stub
		return customersRepository.findCustomersByCustNameContaining(name);
		 
	}

	public List<CustomersEntity> findCustomersByCustNameAndCustId(String name, String custId) {
		// TODO Auto-generated method stub
		return customersRepository.findCustomersByCustNameContainingAndCustNumber(name, custId);
	}

}
