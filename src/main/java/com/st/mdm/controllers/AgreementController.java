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
import com.st.mdm.models.Agreements;
import com.st.mdm.repository.AgreementRepository;
import com.st.mdm.services.AgreementServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")

@RestController
public class AgreementController {
	@Autowired
	private AgreementRepository repo;
	@Autowired
	private AgreementServiceImpl service;

	@PostMapping("/createagreement")
	public ResponseEntity<List<Agreements>> createAssetDetails(@RequestBody String inputData)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(service.createAgreementDetails(inputData));
	}

	@GetMapping("/getagreement/{id}")
	public ResponseEntity<List<Agreements>> getAgreementDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getAgreementDetails(id));
	}

	@DeleteMapping("/deleteagreement/{id}")
	public HttpStatus deleteAgreement(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateagreement/{id}")
	public ResponseEntity<Agreements> updateAssetDetails(@PathVariable(value = "id") Long id,
			@RequestBody Agreements agreement) {
		agreement.setId(id);
		return ResponseEntity.ok().body(this.service.updateAgreementDetails(agreement));
	}
}
