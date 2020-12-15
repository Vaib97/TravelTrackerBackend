package com.service;

import java.util.List;

import com.model.Traveller;

public interface ITravellerService {
	
	List<Traveller> findByName(String name);
	List<Traveller> findByDestination(String destination);

}
