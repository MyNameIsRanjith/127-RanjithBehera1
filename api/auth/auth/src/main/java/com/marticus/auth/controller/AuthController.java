package com.marticus.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticus.auth.service.AuthService;
import com.marticus.auth.utility.TokenGenerator;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@GetMapping("login/{name}/{pass}")
	public ResponseEntity<String> login(@PathVariable("name") String username,
			@PathVariable("pass") String password)
	{
		String str1="Token is not available, access denied";
		boolean checkResult=authService.authenticate(username, password);
		if(checkResult)
		{
			str1=TokenGenerator.getJWTToken(username);
		}
		return ResponseEntity.ok(str1);		
	}
}
