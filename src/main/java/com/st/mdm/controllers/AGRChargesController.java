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
import com.st.mdm.models.AGRCharges;
import com.st.mdm.repository.AGRChargesRepo;
import com.st.mdm.services.AGRChargesServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class AGRChargesController {
	@Autowired
	private AGRChargesRepo repo;
	@Autowired
	private AGRChargesServiceImpl service;

	@PostMapping("/createAgr")
	public ResponseEntity<AGRCharges> createAGRChargesDetails(@RequestBody AGRCharges address)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(address));
	}

	@GetMapping("/getAgr/{id}")
	public ResponseEntity<List<AGRCharges>> getAGRChargesDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getAGRChargesDetails(id));
	}

	@GetMapping("/getAgr")
	public List<AGRCharges> getAGRChargesDetails(AGRCharges address) {
		return repo.findAll();
	}

	@DeleteMapping("/deleteAgr/{id}")
	public HttpStatus deleteAgr(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateAGRCharges/{id}")
	public ResponseEntity<AGRCharges> updateAGRChargesDetails(@PathVariable(value = "id") Long id,
			@RequestBody AGRCharges address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.service.updateAGRChargesDetails(address));
	}
}
