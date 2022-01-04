package com.marticus.auth.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marticus.auth.entity.User;

@Repository
public interface AuthRepo extends JpaRepository<User, Long> {

	List<User> findByUsernameAndPassword(String username, String password);
}
