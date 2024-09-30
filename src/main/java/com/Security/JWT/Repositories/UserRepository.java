package com.Security.JWT.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Security.JWT.Entity.User;

public interface UserRepository  extends JpaRepository<User,Integer>{
	
	 Optional<User> findByUsername(String username);

}
