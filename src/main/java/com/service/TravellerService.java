package com.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Traveller;
import com.repository.TravellerRepository;

@Service
@Transactional
public class TravellerService implements ITravellerService {
	
	@Autowired

	TravellerRepository travellerRepository;
	
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
	public void save(Traveller traveller)   
	{  
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
	public void updateTraveller(Long id, Traveller traveller) {
		String destination=traveller.getDestination();
		java.util.Date enddate=traveller.getEnddate();
		travellerRepository.update(id, destination, enddate);
		
	}
	
	 
	

}
