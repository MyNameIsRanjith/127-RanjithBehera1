package com.marticus.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticus.auth.entity.User;
import com.marticus.auth.repo.AuthRepo;

@Service
public class AuthService {
	
	@Autowired
	AuthRepo authRepo;

	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("username="+username);
		System.out.println("password="+password);
		List<User> userList=authRepo.findByUsernameAndPassword(username,password);
		System.out.println(userList.size());
		if(userList!=null && userList.size()>0)
		{
			return true;
		}
			
		return false;
	}

}
