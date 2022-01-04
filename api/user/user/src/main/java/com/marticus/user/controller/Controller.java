package com.marticus.user.controller;

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

import com.marticus.user.entity.Users;
import com.marticus.user.service.UsersService;


@RestController
@RequestMapping("/users")
public class Controller {
	@Autowired
	UsersService usersService;
	
	@PostMapping("/")
	public ResponseEntity<Void> saveUsers(@RequestBody Users ust1)
	 {
		usersService.saveUsers(ust1);
		return ResponseEntity.status(HttpStatus.CREATED).header("creation status", "created").build();
	 }
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsersByID(@PathVariable long id)
	 {
		Users ust2=usersService.findUsersById(id);
	     return ResponseEntity.ok(ust2);
	 }
	
	@GetMapping("/")
	public ResponseEntity<List<Users>> getUsersList()
	 {
		List<Users> ust3=usersService.findAllUsers();
	     return ResponseEntity.ok(ust3);
	 }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsersersById(@PathVariable long id)
	{
		String body="record succesfully deleted";
		
		Boolean deleteStatus=usersService.deleteUsersById(id);
		if(!deleteStatus)
		{
			body="could not perform the delete operation";
		}
	     return ResponseEntity.ok().body(body);

	}
	
	@PutMapping("/")
	public ResponseEntity<String> updateUsers(@RequestBody Users userupdate)
	 {
		String updateStatus="updation successful";
		usersService.updateUsers(userupdate);
	    return ResponseEntity.ok().body(updateStatus);
	 }
	

}
