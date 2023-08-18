package com.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.modles.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
