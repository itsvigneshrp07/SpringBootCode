package com.st.mdm.controllers;

import java.util.List;

import javax.validation.Valid;

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
import com.st.mdm.models.Bucket;
import com.st.mdm.models.UcicMaster;
import com.st.mdm.repository.BucketRepository;
import com.st.mdm.repository.UcicRepository;
import com.st.mdm.services.BucketServiceImpl;
import com.st.mdm.services.UcicService;
import com.st.mdm.services.UcicServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class BucketController {
	@Autowired
	private BucketRepository repo;
	@Autowired
	private BucketServiceImpl service;
	
	@PostMapping("/createbucket")
	public ResponseEntity<List<Bucket>> createBucketDetails(@RequestBody String inputData)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(service.createBucketDetails(inputData));
	}
	@PostMapping("/createBucket")
	public ResponseEntity<Bucket> createBucketDetails(@RequestBody Bucket bucket)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(bucket));
	}
	
	@GetMapping("/getBucket/{id}")
	public ResponseEntity<List<Bucket>>getBucketDetails(@PathVariable(value = "id") long id)
	throws JSONException,JSONException,JsonMappingException,JsonProcessingException{
	
	return ResponseEntity.ok().body(service.getBucketDetails(id));
	}
	@GetMapping("/getBucket")
	public ResponseEntity<List<Bucket>>getBucketDetails( Bucket Bucket)
	throws JSONException,JSONException,JsonMappingException,JsonProcessingException{
	
	return ResponseEntity.ok().body(repo.findAll());
	}
	
	@DeleteMapping("/deleteBucket/{id}")
	public HttpStatus deleteBucket(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}
	@PutMapping("/updateBucket/{id}")
	public ResponseEntity<Bucket> updateBucketDetails(@PathVariable(value = "id") Long id,@RequestBody Bucket bucket) {
		bucket.setId(id);
	return ResponseEntity.ok().body(this.service.updateBucketDetails(bucket));
	}
}

