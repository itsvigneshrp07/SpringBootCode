package com.st.mdm.controllers;

import java.util.List;


import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.st.mdm.models.CustomerRelationship;
import com.st.mdm.models.Schedule;
import com.st.mdm.repository.CustomerRelationshipRepository;
import com.st.mdm.services.CustomerRelationshipServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController

public class CustomerRelationshipController {
	@Autowired
	private CustomerRelationshipServiceImpl service;
	@Autowired
	private CustomerRelationshipRepository repo;
	@PostMapping("/createCustomerRelationship")	
	public ResponseEntity<List<CustomerRelationship>>createCustomerRelatiomnshipDetail(@RequestBody String inputData)
	throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

	return ResponseEntity.ok().body(service.createCustomerRelationshipDetails(inputData)) ;
}
	
	
	@PostMapping("/createcr")	
	public ResponseEntity<CustomerRelationship>createCustomerRelatiomnshipDetail(@RequestBody CustomerRelationship customerRelationship)
	throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
	return ResponseEntity.ok().body(repo.save(customerRelationship)) ;
}
	@GetMapping("/getCustomerRelationship/{id}")
	public ResponseEntity<List<CustomerRelationship>> getCustomerRelationship(@PathVariable (value="id" )long id)
	throws JSONException,JsonMappingException,JsonProcessingException{
		
		return ResponseEntity.ok().body(service.getCustomerRelationshipDetails(id));
	}
	@GetMapping("/getCr")
	public ResponseEntity<List<CustomerRelationship>> getCustomerRelationship(CustomerRelationship customerRelationship)
	throws JSONException,JsonMappingException,JsonProcessingException{
	
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@DeleteMapping("/deleteCr/{id}")
	public HttpStatus deleteCr(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}
@PutMapping("/updateCustomerRelationship/{id}")
public ResponseEntity<CustomerRelationship> updateCustomerRelationship(@PathVariable(value="id")long id ,@RequestBody CustomerRelationship customerRelationship)
throws JSONException,JsonMappingException,JsonProcessingException{
	return ResponseEntity.ok().body(service.updateCustomerRelationshipDetails(customerRelationship));
}
	
}
