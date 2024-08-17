package com.jspiders.springbootproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspiders.springbootproject.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
	
	@Query("select u from User u where u.gender ")
	public User findBygender(String gender);

}
