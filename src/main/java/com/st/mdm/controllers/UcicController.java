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

import com.st.mdm.models.UcicMaster;
import com.st.mdm.repository.UcicRepository;
import com.st.mdm.services.UcicService;
import com.st.mdm.services.UcicServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class UcicController {
	@Autowired
	private UcicRepository repo;
	@Autowired
	private UcicServiceImpl service;
	
	@PostMapping("/createucic")
	public ResponseEntity<UcicMaster> createUcicDetails(@RequestBody UcicMaster ucicMaster)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(ucicMaster));
	}
	@GetMapping("/getUcic")
	public List<UcicMaster> getUcicDetails(UcicMaster ucicMaster){
	return repo.findAll();
}
	@GetMapping("/getUcic/{id}")
	public ResponseEntity<List<UcicMaster>>getUcicDetails(@PathVariable(value = "id") long id)
	throws JSONException,JSONException,JsonMappingException,JsonProcessingException{
	return ResponseEntity.ok().body(service.getUcicDetails(id));
	}
	

	@DeleteMapping("/deleteucic/{id}")
	public HttpStatus deleteUcic(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}
	@PutMapping("/updateucic/{id}")
	public ResponseEntity<UcicMaster> updateUcicDetails(@PathVariable(value = "id") Long id,@RequestBody UcicMaster ucicMasters) {
	ucicMasters.setId(id);
	return ResponseEntity.ok().body(this.service.updateUcicDetails(ucicMasters));
	}
}

