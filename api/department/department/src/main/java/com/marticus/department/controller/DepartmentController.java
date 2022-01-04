package com.marticus.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.marticus.department.entity.DepartmentEntity;
import com.marticus.department.model.RestData;
import com.marticus.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	RestTemplate  restTemplate;
	
	@PostMapping("/")
	public ResponseEntity<Void> saveCustomer(@RequestBody DepartmentEntity dept1)
	 {
		departmentService.saveCustomer(dept1);
		return ResponseEntity.status(HttpStatus.CREATED).header("creation status", "created").build();
	 }
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable long id)
	 {
		DepartmentEntity dept2=departmentService.findDepartmentById(id);
	     return ResponseEntity.ok(dept2);
	 }
	
	@GetMapping("/")
	public ResponseEntity<List<DepartmentEntity>> getDepartmentList()
	 {
		List<DepartmentEntity> dept3=departmentService.findAllDepartments();
	     return ResponseEntity.ok(dept3);
	 }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable long id)
	{
		String body="record succesfully deleted";
		
		Boolean deleteStatus=departmentService.deleteDepartmentById(id);
		if(!deleteStatus)
		{
			body="could not perform the delete operation";
		}
	     return ResponseEntity.ok().body(body);

	}
	
	@PutMapping("/")
	public ResponseEntity<String> updateDepartment(@RequestBody DepartmentEntity deptupdate)
	 {
		String updateStatus="updation operation successful";
		departmentService.updateDepartment(deptupdate);
	    return ResponseEntity.ok().body(updateStatus);
	 }
	
	@GetMapping("/callfreeapi/{name}")
	public ResponseEntity<RestData> getRestDatas(@PathVariable String name)
	{
		RestData rstdata= new RestData();
		String url="https://api.genderize.io/?name="+name;
//		String url="https://www.boredapi.com/api/activity";
		//RestTemplate template=new RestTemplate();
		rstdata=restTemplate.getForObject(url, RestData.class) ;
		return ResponseEntity.ok(rstdata);		
	}	
}
