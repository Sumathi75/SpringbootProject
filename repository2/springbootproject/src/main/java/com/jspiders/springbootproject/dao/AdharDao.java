package com.jspiders.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspiders.springbootproject.Entity.Adhar;
import com.jspiders.springbootproject.repo.AdharRepo;

@Repository
@RequestMapping("adhar")
public class AdharDao {

	@Autowired
	AdharRepo repo;
	
	public Adhar saveAdhar(Adhar adhar)
	{
		return repo.save(adhar);
	}
	
	public Adhar findAdharById(int id) {
		Optional<Adhar> optionalAdhar = repo.findById(id);
		if(optionalAdhar.isPresent()) {
			return optionalAdhar.get();
		}
		return null;
	}
	
	public Adhar deleteById(int id) {
		Adhar adhar = findAdharById(id);
		if (adhar != null) {
			repo.delete(adhar);
			return adhar;
		}
		return null;
	}
	
	public Adhar updateAdhar(Adhar adhar,int id) {
		Adhar dbadhar = findAdharById(id);
		if (dbadhar != null) {
			dbadhar.setId(id);
			return repo.save(adhar);
		}
		return null;
	}
	
	public List<Adhar> findAll(){
		return repo.findAll();
	}
	
}
