package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;
	
	
	//method to find a user with particular user name and password exist or not
	public  boolean findUserCredentials(User user)   
	{ 
	if( userRepository.findUser(user.getUsername(),user.getPassword())!=null)
		return true;
	else 
		return false;
	}
    
	//method to save a not existing user name during sign up
	public boolean saveUser(User user) {
		
		if(userRepository.findByUsername(user.getUsername())==null)
		{
			userRepository.save(user);
			return true;
		}
		else
			return false;
	} 
	

}
