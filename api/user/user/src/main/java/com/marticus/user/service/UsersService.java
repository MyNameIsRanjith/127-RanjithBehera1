package com.marticus.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticus.user.entity.Users;
import com.marticus.user.repo.UsersRepository;

@Service
public class UsersService {
	@Autowired
	UsersRepository usersRepository;

	public void saveUsers(Users ust1) {
		usersRepository.save(ust1);
		
	}

	public Users findUsersById(long id) {
		return usersRepository.findUsersById(id);
	}

	public List<Users> findAllUsers() {
		return usersRepository.findAll();
	}

	public Boolean deleteUsersById(long id) {
		// TODO Auto-generated method stub
		Users ust2=usersRepository.findUsersById(id);
		if(ust2!=null)
		{
			usersRepository.delete(ust2);
			return true;
		}
		return false;
	}

	public void updateUsers(Users userupdate) {
		Users userNew=usersRepository.findUsersById(userupdate.getId());
		userNew.setUserId(userupdate.getUserId());
		userNew.setPassword(userupdate.getPassword());
		usersRepository.save(userNew);		
	}		
	
}