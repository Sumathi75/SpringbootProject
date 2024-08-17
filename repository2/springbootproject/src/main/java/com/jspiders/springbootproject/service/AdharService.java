package com.jspiders.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.springbootproject.Entity.Adhar;
import com.jspiders.springbootproject.dao.AdharDao;
import com.jspiders.springbootproject.exception.AdharNotFoundException;
import com.jspiders.springbootproject.util.ResponseStructure;

@Service
public class AdharService {

	@Autowired
	AdharDao dao;
	
	//save adhar
	public ResponseEntity<ResponseStructure<Adhar>> saveAdhar(Adhar adhar) {
		Adhar saveadhar = dao.saveAdhar(adhar);
		if (saveadhar != null) {

			ResponseStructure<Adhar> structure = new ResponseStructure<Adhar>();
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("data saved success");
			structure.setData(saveadhar);
			return new ResponseEntity<ResponseStructure<Adhar>>(structure,HttpStatus.CREATED);		
		}
		return null;
	}
	
	//find adhar
	public ResponseEntity<ResponseStructure<Adhar>> find(int id) {
		Adhar adhar = dao.findAdharById(id);
		if (adhar != null) {

			ResponseStructure<Adhar> structure = new ResponseStructure<Adhar>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("adhar found successfully by id");
			structure.setData(adhar);
			return new ResponseEntity<ResponseStructure<Adhar>>(structure,HttpStatus.FOUND);
		}
		throw new AdharNotFoundException("Adhar not found with the given id");
	}
	
	//delete adhar
	public ResponseEntity<ResponseStructure<Adhar>> deleteById(int id) {
		Adhar adhar = dao.findAdharById(id);
		if (adhar != null) {
			dao.deleteById(id);
			ResponseStructure<Adhar> structure = new ResponseStructure<Adhar>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("data saved success");
			structure.setData(adhar);
			return new ResponseEntity<ResponseStructure<Adhar>>(structure,HttpStatus.OK);		
			}
		throw new AdharNotFoundException("Adhar not found with the given id");

	}
	
	//update adhar
	public ResponseEntity<ResponseStructure<Adhar>> updateAdhar(Adhar Adhar,int id) {
		Adhar updateadhar =dao.findAdharById(id);
		if (updateadhar != null) {
			dao.updateAdhar(updateadhar, id);
			ResponseStructure<Adhar> structure = new ResponseStructure<Adhar>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("data saved success");
			structure.setData(updateadhar);
			return new ResponseEntity<ResponseStructure<Adhar>>(structure,HttpStatus.OK);		
			}
		return null;
	}
	
	
	//find all adhar list
	public ResponseEntity<ResponseStructure<List<Adhar>>> findAll(){
		ResponseStructure<Adhar> structure = new ResponseStructure<Adhar>();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("all adhar found");
		structure.setData(dao.findAll());
		return new ResponseEntity<ResponseStructure<List<Adhar>>>(HttpStatus.FOUND);
    }
	
	
}



//to change the status code (it return always 200 for every process)to change that use responseentity<Aadhar>
//return new responseEntity<saveaadhar,httpstatus.cretaed>

//public Adhar saveadhar(Adhar adhar)
//{
//	Adhar saveadhar=dao.saveAadhar(adhar);
//	if(saveadhar!=null)
//	{
//		return saveadhar;
//	}
//	return null;
////	


//to change the status code

//public ResponseEntity<Adhar> saveAadhar(Adhar adhar)
//{
//	Adhar saveAadhar=dao.saveAadhar(adhar);
//	if(saveadhar!=null)
//	{
//		return new ResponseEntity<Adhar>(saveadhar, HttpStatus.CREATED);
//	}
//	return null;
