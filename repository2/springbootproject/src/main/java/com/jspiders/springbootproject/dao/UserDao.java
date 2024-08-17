package com.jspiders.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.springbootproject.Entity.User;
import com.jspiders.springbootproject.repo.UserRepo;

@Repository
public class UserDao 
{
	@Autowired
	UserRepo repo;
	
	public User saveUser(User user)
	{
		return repo.save(user);
		
	}
	
	public User finfBYId(int uid)
	{
		Optional<User> optionaluser=repo.findById(uid);
		if(optionaluser.isPresent())
		{
			return optionaluser.get();
		}
		return null;
		
	}
	
	public User deleteById(int uid)
	{
		User user=finfBYId(uid);
		if(user!=null)
		{
			repo.delete(user);
			return user;
		}
		
		return null;
		
	}
	public User updateUser(User user,int uid)
	{
	User updateuser=finfBYId(uid);
	if(updateuser!=null)
	{
		updateuser.setUid(uid);
		return repo.save(user);
	}
		return null;
		
	}
	
	public List<User> findAll()
	{
		return repo.findAll();
	}
	

}


