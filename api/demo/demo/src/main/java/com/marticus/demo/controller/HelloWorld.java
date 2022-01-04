package com.marticus.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticus.demo.model.Employee;
import com.marticus.demo.model.Student;

@RestController
@RequestMapping(path="/hello")
public class HelloWorld {
	
	@GetMapping("/first")
	public String sayFirstPage()
	{
		return "Hello World";	
	}
	
	@PostMapping(path="/firststatic")
	 public ResponseEntity<String> save(String input)
	 {
		
		 HttpHeaders header = new HttpHeaders();
	     header.add("header1", "This is my header 1");
	     header.add("header2", "This is my header 2");
	     return ResponseEntity.status(HttpStatus.CREATED).headers(header).body("Hello");
	 }
	 
	 @PostMapping(path="/object")
	 public ResponseEntity<String> save1(String input)
	 {
		 ResponseEntity<String> res1= new ResponseEntity<>("Hello",HttpStatus.OK);
	     return res1;
	 }
	 
	 @PostMapping(path="/inline")
	 public ResponseEntity<String> save11(String input)
	 {
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .header("H1", "Value 1")
				 .header("H2", "Value 2")
				 .body("Test");
	 }
	 
	 @PostMapping(path="/nobody")
	 public ResponseEntity<Void> save111(String input)
	 {
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .header("H1", "Value 1")
				 .header("H2", "Value 2")
				 .build();
	 }
	 
	 @PostMapping(path="/reqhdr")
	 public ResponseEntity<String> reqhdr(        
			 @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
             @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
             @RequestBody String str)
	 {
		 String returnVal="X-COM-PERSIST="+headerPersist+"X-COM-LOCATION="+headerLocation;
		 return ResponseEntity.ok(returnVal);
	 }
	 
	 @PostMapping(path="/reqasresinhdr")
	 public ResponseEntity<String> reqasresinhdr(        
			 @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
             @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
             @RequestBody String str)
	 {
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .header("H1", headerPersist)
				 .header("H2", headerLocation)
				 .body("ReqHdr is returned as ResHdr");
	 }
	 
	@PostMapping(path="/first1")
	 public ResponseEntity<String> saveA(String input)
	 {
		 HttpHeaders header = new HttpHeaders();
	     header.add("header1", "This is my header 1");
	     header.add("header2", "This is my header 2");
	     return ResponseEntity.status(HttpStatus.CREATED).headers(header).body("Hello");
	 }
	
	@PostMapping(path="/getStudent")
	 public ResponseEntity<Student> getStudent(@RequestBody String input)
	 {
		 
		 System.out.println("input="+input);	
		 Student st= new Student("st1","Jayanta1");
		 
		 return ResponseEntity.status(HttpStatus.CREATED).header("X-INPUT", input)
			 .body(st);		
	 }
	
	@PostMapping(path="/getStudents")
	 public ResponseEntity<List<Student>> getStudents(@RequestBody String input)
	 {
		 
		 List<Student> lstStu= new ArrayList<Student>();
		 Student st= new Student("st1","Jayanta1");
		 Student st1= new Student("st2","Moumita");
		 Student st11= new Student("st3","Amit");
		 lstStu.add(st);
		 lstStu.add(st1);
		 lstStu.add(st11);
		 
		 return ResponseEntity.status(HttpStatus.CREATED).header("X-INPUT", input)
			 .body(lstStu);
	 }
	
	@PostMapping(path="/processStudents")
	 public ResponseEntity<Void> processStudents(@RequestBody List<Student> studentList)
	 {
		 for(Student stu:studentList)
		 {
			 System.out.println("Name="+stu.getStuName());			 
		 }		 
		 return ResponseEntity.status(HttpStatus.CREATED).header("X-INPUT", "Test").build(); 			
	 }
	
	@PostMapping(path="/getEmployee")
	 public ResponseEntity<Employee> getEmployee(@RequestBody String input)
	 {
		 
		 System.out.println("input="+input);	
		 Employee em= new Employee("emp1","employee1");
		 
		 return ResponseEntity.status(HttpStatus.CREATED).header("X-INPUT", input)
			 .body(em);		
	 }
	
	@PostMapping(path="/getEmployees")
	 public ResponseEntity<List<Employee>> getEmployees(@RequestBody String input)
	 {
		 
		 List<Employee> lstemp= new ArrayList<Employee>();
		 Employee emp1= new Employee("emp1","employee1");
		 Employee emp2= new Employee("emp2","employee2");
		 Employee emp3= new Employee("emp3","employee3");
		 lstemp.add(emp1);
		 lstemp.add(emp2);
		 lstemp.add(emp3);
		 
		 return ResponseEntity.status(HttpStatus.CREATED).header("X-INPUT", input)
			 .body(lstemp);
	 }
	
	@PostMapping(path="/processEmployees")
	 public ResponseEntity<Void> processEmployees(@RequestBody List<Employee> employeeList)
	 {
		 for(Employee emp:employeeList)
		 {
			 System.out.println("Name="+emp.getEmpName());			 
		 }		 
		 return ResponseEntity.status(HttpStatus.CREATED).header("X-INPUT", "Test").build(); 			
	 }

	@GetMapping("/second/{id}")
	public int sayHello1(@PathVariable int id)
	{		
		return id;
	}

//	@GetMapping("/second")
//	public String saySecondPage()
//	{
//		return "Welcome to the 2nd page";	
//	}
//	
//	@GetMapping("/third")
//	public String sayThirdPage()
//	{
//		return "Welcome to the 3rd page";	
//	}
}
