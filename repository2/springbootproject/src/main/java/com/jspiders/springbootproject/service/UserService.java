package com.jspiders.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.springbootproject.Entity.Adhar;
import com.jspiders.springbootproject.Entity.User;
import com.jspiders.springbootproject.dao.AdharDao;
import com.jspiders.springbootproject.dao.UserDao;
import com.jspiders.springbootproject.exception.AdharNotFoundException;
import com.jspiders.springbootproject.exception.UserNotFound;
import com.jspiders.springbootproject.util.ResponseStructure;


@Service
public class UserService 
{
	@Autowired
	UserDao udao;
	
	@Autowired
	AdharDao adao;
	
	//save user
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		User saveuser=udao.saveUser(user);
		if(saveuser!=null)
		{
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(saveuser);
			structure.setMessage("user saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
		}
		return null;
		//exception for user not found
		
	}
	public ResponseEntity<ResponseStructure<User>> findUser(int uid)
	{
		User user=udao.finfBYId(uid);
		if(user!=null)
		{
		ResponseStructure<User> structure=new ResponseStructure<User>();
		structure.setData(user);
		structure.setMessage("user found");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		 throw new UserNotFound("User not found with the given id");
		  //exception for uid not found
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int uid)
	{
		User user=udao.finfBYId(uid);
		if(user!=null)
		{
			udao.finfBYId(uid);
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(user);
			structure.setMessage("user deleted ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
		}
		 
		 throw new UserNotFound("User not found with the given id");
		//user not found
		
	}
	public ResponseEntity<ResponseStructure<User>> assignAAdharToUser(int id,int uid)
	{
		Adhar adhar=adao.findAdharById(id);
		User user=udao.finfBYId(uid);
		if(adhar!=null)
		{
			if(user!=null)
			{
				user.setAdhar(adhar);
				User updateUser=udao.updateUser(user, uid);//marked as yello means not used
				ResponseStructure<User> structure=new ResponseStructure<User>();
				structure.setData(updateUser);
				structure.setMessage("updated successfully");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			}
			 throw new UserNotFound("User not found with the given id");
			//user not found exception
		}
		throw new AdharNotFoundException("Adhar not found with the given id");
		//aadhar not found
		
	}
	public ResponseEntity<ResponseStructure<List<User>>> findAll()
	{
		ResponseStructure<List<User>>structure=new ResponseStructure<List<User>>();
		structure.setData(udao.findAll());
		structure.setMessage("all user found");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		
	}

}




