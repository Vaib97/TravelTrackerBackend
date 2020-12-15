package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;
	
	public  User findUser(User user)   
	{  
	return userRepository.findUser(user.getUsername(),user.getPassword());  
	}

	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		if(userRepository.findByUsername(user.getUsername())==null)
		{
			userRepository.save(user);
			return true;
		}
		else
			return false;
	} 
	

}
