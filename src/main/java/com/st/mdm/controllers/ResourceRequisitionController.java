
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
import com.st.mdm.models.ResourceRequisition;
import com.st.mdm.repository.ResourceRequisitionRepository;
import com.st.mdm.services.ResourceRequisitionServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")

@RestController
public class ResourceRequisitionController {

	@Autowired
	private ResourceRequisitionRepository repo;

	@Autowired
	private ResourceRequisitionServiceImpl service;

	@PostMapping("/createResource")
	public ResponseEntity<List<ResourceRequisition>> createResourceRequisition(@RequestBody String inputData)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(service.createResourceRequisition(inputData));
	}

	@PostMapping("/createResource1")
	public ResponseEntity<ResourceRequisition> createResourceRequisition(@RequestBody ResourceRequisition bucket)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(bucket));
	}

	@GetMapping("/getResource/{id}")
	public ResponseEntity<List<ResourceRequisition>> getResourceRequisition(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getResourceRequisition(id));
	}

	@GetMapping("/getResource")
	public ResponseEntity<List<ResourceRequisition>> getResourceRequisition(ResourceRequisition Resource)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(repo.findAll());
	}

	@DeleteMapping("/deleteResource/{id}")
	public HttpStatus deleteResource(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateResource/{id}")
	public ResponseEntity<ResourceRequisition> updateResourceRequisition(@PathVariable(value = "id") Long id,

			@RequestBody ResourceRequisition bucket) {
		bucket.setId(id);
		return ResponseEntity.ok().body(this.service.updateResourceRequisition(bucket));
	}
}
