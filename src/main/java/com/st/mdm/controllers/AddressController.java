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
import com.st.mdm.models.Address;
import com.st.mdm.repository.AddressRepo;
import com.st.mdm.services.AddressServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class AddressController {
	@Autowired
	private AddressRepo repo;
	@Autowired
	private AddressServiceImpl service;

	@PostMapping("/createAddress")
	public ResponseEntity<Address> createAddressDetails(@RequestBody Address address)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(address));
	}

	@GetMapping("/getAddress/{id}")
	public ResponseEntity<List<Address>> getAddressDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(service.getAddressDetails(id));
	}

	@GetMapping("/getAddress")
	public List<Address> getAddressDetails(Address address) {
		return repo.findAll();
	}

	@DeleteMapping("/deleteAddress/{id}")
	public HttpStatus deleteAddress(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateAddress/{id}")
	public ResponseEntity<Address> updateAddressDetails(@PathVariable(value = "id") Long id,
			@RequestBody Address address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.service.updateAddressDetails(address));
	}
}
