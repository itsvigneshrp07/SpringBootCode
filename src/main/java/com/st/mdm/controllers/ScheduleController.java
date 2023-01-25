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
import com.st.mdm.models.Schedule;
import com.st.mdm.models.UcicMaster;
import com.st.mdm.repository.BucketRepository;
import com.st.mdm.repository.ScheduleRepository;
import com.st.mdm.repository.UcicRepository;
import com.st.mdm.services.BucketServiceImpl;
import com.st.mdm.services.ScheduleServiceImpl;
import com.st.mdm.services.UcicService;
import com.st.mdm.services.UcicServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class ScheduleController {
	@Autowired
	private ScheduleRepository repo;
	@Autowired
	private ScheduleServiceImpl service;
	
	@PostMapping("/createschedule")
	public ResponseEntity<List<Schedule>> createScheduleDetails(@RequestBody String inputData)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(service.createScheduleDetails(inputData));
	}
	@PostMapping("/createSchedule")
	public ResponseEntity<Schedule>createScheduleDetails(@RequestBody Schedule schedule)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(schedule));
	}
	
	@GetMapping("/getSchedule/{id}")
	public ResponseEntity<List<Schedule>>getScheduleDetails(@PathVariable(value = "id") long id)
	throws JSONException,JSONException,JsonMappingException,JsonProcessingException{
	
	return ResponseEntity.ok().body(service.getScheduleDetails(id));
	}
	@GetMapping("/getSchedule")
	public ResponseEntity<List<Schedule>>getScheduleDetails(Schedule schedule)
	throws JSONException,JSONException,JsonMappingException,JsonProcessingException{
	
	return ResponseEntity.ok().body(repo.findAll());
	}
	

	@DeleteMapping("/deleteSchedule/{id}")
	public HttpStatus deleteSchedule(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}
	@PutMapping("/updateSchedule/{id}")
	public ResponseEntity<Schedule> updateScheduleDetails(@PathVariable(value = "id") Long id,@RequestBody Schedule schedule) {
		schedule.setId(id);
	return ResponseEntity.ok().body(this.service.updateScheduleDetails(schedule));
	}
}

