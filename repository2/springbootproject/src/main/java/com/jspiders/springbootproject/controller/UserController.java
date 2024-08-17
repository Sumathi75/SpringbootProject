package com.jspiders.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springbootproject.Entity.User;
import com.jspiders.springbootproject.service.UserService;
import com.jspiders.springbootproject.util.ResponseStructure;


@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int uid)
	{
		return service.findUser(uid);
		
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> delete(@RequestParam int uid)
	{
		return service.deleteUser(uid);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> assignAadharToUser(@RequestParam int id,@RequestParam int uid)
	{
		return service.assignAAdharToUser(id, uid);
		
	}
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<User>>> findAll()
	{
		return service.findAll();
		
	}

}
