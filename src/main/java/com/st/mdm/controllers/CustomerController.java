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
import com.st.mdm.models.Customer;
import com.st.mdm.repository.CustomerRepo;
import com.st.mdm.services.CustomerServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class CustomerController {
	@Autowired
	private CustomerRepo repo;
	@Autowired
	private CustomerServiceImpl service;

	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomerDetails(@RequestBody Customer address)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(address));
	}

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<List<Customer>> getCustomerDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getCustomerDetails(id));
	}

	@GetMapping("/getCustomer")
	public List<Customer> getCustomerDetails(Customer address) {
		return repo.findAll();
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public HttpStatus deleteCustomer(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomerDetails(@PathVariable(value = "id") Long id,
			@RequestBody Customer address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.service.updateCustomerDetails(address));
	}
}
