package com.library.services;

import com.library.modles.User;

public interface UserService {

	public User createUser(User user); 
	
	public User getUserById(Integer userId);
}
