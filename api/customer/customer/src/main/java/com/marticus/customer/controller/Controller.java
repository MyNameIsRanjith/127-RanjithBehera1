package com.marticus.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticus.customer.model.Customer;

@RestController
@RequestMapping(path="/customers")
public class Controller {
		
	@PostMapping("/")
	ResponseEntity<Void>saveCustomer(@RequestBody Customer cust)
		{
		System.out.println(cust.getCustomerCode());
		return ResponseEntity.status(HttpStatus.CREATED)
				 .header("H1", "Value 1")
				 .header("H2", "Value 2")
				 .build();		
		}
	
	@GetMapping("/")
	ResponseEntity<List<Customer>> getCustomers()
	 	{		 
		 List<Customer> customerList= new ArrayList<Customer>();
		 Customer c1= new Customer(1,"Customer1","CustomerWithId1");
		 Customer c2= new Customer(2,"Customer2","CustomerWithId2");
		 Customer c3= new Customer(3,"Customer3","CustomerWithId3");
		 customerList.add(c1);
		 customerList.add(c2);
		 customerList.add(c3);		 
		 return ResponseEntity.status(HttpStatus.CREATED).body(customerList);
	 	}
}
