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
import com.st.mdm.models.PhoneMaster;
import com.st.mdm.repository.PhoneMasterRepo;
import com.st.mdm.services.PhoneMasterServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class PhoneMasterController {
	@Autowired
	private PhoneMasterRepo repo;
	@Autowired
	private PhoneMasterServiceImpl service;

	@PostMapping("/createPhoneMaster")
	public ResponseEntity<PhoneMaster> createPhoneMasterDetails(@RequestBody PhoneMaster address)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(address));
	}

	@GetMapping("/getPhoneMaster/{id}")
	public ResponseEntity<List<PhoneMaster>> getPhoneMasterDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getPhoneMasterDetails(id));
	}

	@GetMapping("/getPhoneMaster")
	public List<PhoneMaster> getPhoneMasterDetails(PhoneMaster address) {
		return repo.findAll();
	}

	@DeleteMapping("/deletePhoneMaster/{id}")
	public HttpStatus deletePhoneMaster(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updatePhoneMaster/{id}")
	public ResponseEntity<PhoneMaster> updatePhoneMasterDetails(@PathVariable(value = "id") Long id,
			@RequestBody PhoneMaster address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.service.updatePhoneMasterDetails(address));
	}
}
