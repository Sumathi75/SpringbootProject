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

import com.jspiders.springbootproject.Entity.Adhar;
import com.jspiders.springbootproject.service.AdharService;
import com.jspiders.springbootproject.util.ResponseStructure;

@RestController
@RequestMapping("/adhar")
public class AdharController {

	@Autowired
	AdharService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Adhar>> saveAdhar(@RequestBody Adhar adhar) {
		return service.saveAdhar(adhar);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Adhar>> find(@RequestParam int id) {
		return service.find(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Adhar>> deleteAdhar(@RequestParam int id) {
		return service.deleteById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Adhar>> update(@RequestBody Adhar adhar,@RequestParam int id) {
		return service.updateAdhar(adhar, id);
	}
	
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<Adhar>>> findAll(){
		return service.findAll();
	}
	
	
}
