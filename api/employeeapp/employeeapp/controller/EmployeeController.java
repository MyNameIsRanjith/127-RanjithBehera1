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

import com.marticus.employee.entity.EmployeeEntity;
import com.marticus.employee.service.EmployeeService;
import com.marticus.employee.vo.EmployeeVO;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeVO>> getAllRestdata() {
		List<EmployeeVO> empList = employeeService.getAllRestData();
		return ResponseEntity.ok(empList);

	}

	@GetMapping("/emp/{empid}")
	public ResponseEntity<EmployeeEntity> employeeByEmpId(@PathVariable("empid") int empId) {
		EmployeeEntity emp = employeeService.getEmpByEmpId(empId);
		return ResponseEntity.ok(emp);

	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getRestDataFromProject(@PathVariable("id") int id) {
		String response=employeeService.getRestDataForSingleOne(id);
		return ResponseEntity.ok(response);

	}

	@PostMapping("/create")
	public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employeeEntity) {
		EmployeeEntity emp = employeeService.save(employeeEntity);
		return ResponseEntity.ok(emp);
	}

}
