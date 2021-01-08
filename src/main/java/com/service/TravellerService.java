package com.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Traveller;
import com.repository.TravellerRepository;
import com.repository.UserRepository;

@Service
@Transactional
public class TravellerService implements ITravellerService {
	
	@Autowired
    TravellerRepository travellerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	// method to return all journey of a particular user account
	public List<Traveller> getAllTraveller(String username)   
	{  
	List<Traveller> travellers = new ArrayList<Traveller>();  
	travellerRepository.findByUserUsername(username).forEach(traveller -> travellers.add(traveller));  
	return travellers;  
	}
	
	
	//getting a specific record  
	public  Traveller getTravellerById(Long id)   
	{  
	return travellerRepository.findById(id).get();  
	}  
	
	//adding a new journey in a user account
	public void save(Traveller traveller)   
	{  
		
		if(userRepository.findByUsername(traveller.getUser().getUsername())!=null)
			
	    travellerRepository.save(traveller);  
	}  
	
	
	public List<Traveller> findByName(String name) {
		List<Traveller> travellers = (List<Traveller>) travellerRepository.findByName(name);
		return travellers;
	}
	
	public List<Traveller> findByDestination(String destination)
	{
		List<Traveller> travellers = (List<Traveller>) travellerRepository.findByDestination(destination);
		return travellers;
	}
	
	//updating the journey by id 
	public void updateTraveller(Long id, String destination, Date enddate) {
		
		travellerRepository.update(id, destination, enddate);
		
	}
	
	 
	

}
