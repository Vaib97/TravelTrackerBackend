package com.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	@Query("select d from User d where d.username= ?1 and d.password= ?2")
	User findUser(String username, String password);
	
	User findByUsername(String username);
}
