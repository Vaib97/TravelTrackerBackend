package com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Traveller;

@Repository
public interface TravellerRepository extends CrudRepository<Traveller,Long> {
 
	
	List<Traveller> findByName(String name);
	
	
	List<Traveller> findByDestination(String destination);
	
	@Modifying
	@Query("update Traveller t set t.destination = ?2, t.enddate = ?3 where t.id = ?1")
	void update(Long id, String destination, Date enddate);
	
	List<Traveller> findByUserUsername(String username);
	

}
