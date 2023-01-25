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
import com.st.mdm.models.ApplicationLeads;
import com.st.mdm.repository.ApplicationLeadsRepo;
import com.st.mdm.services.ApplicationLeadsServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class ApplicationLeadsController {
	@Autowired
	private ApplicationLeadsRepo repo;
	@Autowired
	private ApplicationLeadsServiceImpl service;

	@PostMapping("/createLead")
	public ResponseEntity<ApplicationLeads> createApplicationLeadsDetails(@RequestBody ApplicationLeads address)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(address));
	}

	@GetMapping("/getLead/{id}")
	public ResponseEntity<List<ApplicationLeads>> getApplicationLeadsDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getApplicationLeadsDetails(id));
	}

	@GetMapping("/getLead")
	public List<ApplicationLeads> getApplicationLeadsDetails(ApplicationLeads address) {
		return repo.findAll();
	}

	@DeleteMapping("/deleteLead/{id}")
	public HttpStatus deleteLead(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateLead/{id}")
	public ResponseEntity<ApplicationLeads> updateApplicationLeadsDetails(@PathVariable(value = "id") Long id,
			@RequestBody ApplicationLeads address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.service.updateApplicationLeadsDetails(address));
	}
}
