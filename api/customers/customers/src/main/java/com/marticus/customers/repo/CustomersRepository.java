package com.marticus.customers.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marticus.customers.entity.CustomersEntity;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, Long>
{

	CustomersEntity findCustomersById(long id);
	
	List<CustomersEntity> findCustomersByCustName(String name);

	List<CustomersEntity> findCustomersByCustNameContaining(String name);

	List<CustomersEntity> findCustomersByCustNameContainingAndCustNumber(String forname, String fornumber);
 
}
