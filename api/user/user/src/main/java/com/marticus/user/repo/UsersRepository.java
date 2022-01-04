package com.marticus.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marticus.user.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findUsersById(long id);
	
	

}
