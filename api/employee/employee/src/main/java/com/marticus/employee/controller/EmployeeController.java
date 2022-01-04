package com.marticus.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticus.employee.entity.Employee;
import com.marticus.employee.service.EmployeeService;
import com.marticus.employee.vo.EmployeeVO;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
//	@Autowired
//	RestTemplate restTemplate;
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
//	 {
//		Employee e1=employeeService.findEmployeeById(id);
//	     return ResponseEntity.ok(e1);
//	 }
	
//	@GetMapping("/")
//	public ResponseEntity<List<Employee>> getEmployeeList()
//	 {
//		List<Employee> e2=employeeService.findAllEmployee();
//	     return ResponseEntity.ok(e2);
//	 }
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeVO>> getAllRestData()
	{
		List<EmployeeVO> empList=employeeService.getAllRestData();
		return ResponseEntity.ok(empList);
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable long empId)
	 {
		Employee e3=employeeService.findEmployeeByEmpId(empId);
	     return ResponseEntity.ok(e3);
	 }
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeVO> getRestForEachId(@PathVariable long id)
	{
		EmployeeVO resp=employeeService.getRestForEachId(id);
	     return ResponseEntity.ok(resp);

	}
	
//	@PostMapping("/create")
//	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//		Employee emp = employeeService.save(employee);
//		return ResponseEntity.ok(emp);
//	}

}

