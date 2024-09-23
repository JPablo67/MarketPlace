package com.acostajp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.acostajp.model.User;


public interface IUserRepository  extends JpaRepository<User, Long>{

	
	User findByEmail (String email);
}
