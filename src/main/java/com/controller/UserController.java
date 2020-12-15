package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;
@Component
@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class UserController {
	@Autowired
	UserService userService;
  
	@PostMapping("/login")
	private User getUser(@RequestBody User user)   
	{  
	return userService.findUser(user);  
	} 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	private boolean saveUser(@RequestBody User user)   
	{  
	  return userService.saveUser(user);
	 
	} 
	
}
