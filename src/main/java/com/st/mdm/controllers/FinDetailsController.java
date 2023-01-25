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
import com.st.mdm.models.FinDetails;
import com.st.mdm.repository.FinDetailsRepo;
import com.st.mdm.services.FinDetailsServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class FinDetailsController {
	@Autowired
	private FinDetailsRepo repo;
	@Autowired
	private FinDetailsServiceImpl service;

	@PostMapping("/createFinDetails")
	public ResponseEntity<FinDetails> createFinDetails(@RequestBody FinDetails address)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(address));
	}

	@GetMapping("/getFinDetails/{id}")
	public ResponseEntity<List<FinDetails>> getFinDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getFinDetails(id));
	}

	@GetMapping("/getFinDetails")
	public List<FinDetails> getFinDetails(FinDetails address) {
		return repo.findAll();
	}

	@DeleteMapping("/deleteFinDetails/{id}")
	public HttpStatus deleteFinDetails(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateFinDetails/{id}")
	public ResponseEntity<FinDetails> updateFinDetails(@PathVariable(value = "id") Long id,
			@RequestBody FinDetails address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.service.updateFinDetails(address));
	}
}
