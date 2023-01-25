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
import com.st.mdm.models.EmailMaster;
import com.st.mdm.repository.EmailMasterRepo;
import com.st.mdm.services.EmailMasterServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class EmailMasterController {
	@Autowired
	private EmailMasterRepo repo;
	@Autowired
	private EmailMasterServiceImpl service;

	@PostMapping("/createEmailMaster")
	public ResponseEntity<EmailMaster> createEmailMasterDetails(@RequestBody EmailMaster address)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(address));
	}

	@GetMapping("/getEmailMaster/{id}")
	public ResponseEntity<List<EmailMaster>> getEmailMasterDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getEmailMasterDetails(id));
	}

	@GetMapping("/getEmailMaster")
	public List<EmailMaster> getEmailMasterDetails(EmailMaster address) {
		return repo.findAll();
	}

	@DeleteMapping("/deleteEmailMaster/{id}")
	public HttpStatus deleteEmailMaster(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateEmailMaster/{id}")
	public ResponseEntity<EmailMaster> updateEmailMasterDetails(@PathVariable(value = "id") Long id,
			@RequestBody EmailMaster address) {
		address.setId(id);
		return ResponseEntity.ok().body(this.service.updateEmailMasterDetails(address));
	}
}
