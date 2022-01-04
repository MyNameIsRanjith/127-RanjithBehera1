package com.marticus.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marticus.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findEmployeeById(long id);

//	List<Employee> findAll();
	
	Employee findEmployeeByEmpId(long empId);


}
