package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Traveller;
import com.model.User;
import com.service.TravellerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class TravellerController {
	
	@Autowired  
	TravellerService travellerService;
	
	//creating a get mapping that retrieves all the journey detail from the database of a particular user  
	@GetMapping("/{username}/traveller")  
	private List<Traveller> getAllTraveller(@PathVariable("username") String username)   
	{  
	return travellerService.getAllTraveller(username);  
	}  
	
	//creating a get mapping that retrieves the detail of a specific journey  
	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	private Traveller getTraveller(@PathVariable("id") Long id)   
	{  
	return travellerService.getTravellerById(id);  
	}  
	
	//creating a get mapping that retrieves the detail of all person with a specific name
	@RequestMapping(value ="name/{name}",method = RequestMethod.GET)
	private List<Traveller> getTravellerByName(@PathVariable("name") String name)
	{
		return travellerService.findByName(name);
	}
	
	
	@RequestMapping(value = "destination/{destination}", method = RequestMethod.GET)
	private List<Traveller> getTravelleByDestination(@PathVariable("destination") String destination)   
	{  
	return travellerService.findByDestination(destination);  
	}  
	
	//creating a put mapping that update the details of a journey by id
	@PutMapping("update/{id}")
	public void updateTraveller(@PathVariable Long id, @RequestBody Traveller traveller) {
		String destination=traveller.getDestination();
		java.util.Date enddate=traveller.getEnddate();
	        travellerService.updateTraveller(id, destination,enddate);
	}
	
  

}
