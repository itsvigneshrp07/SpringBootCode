package com.st.mdm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.st.mdm.exception.ResourceNotFoundException;
import com.st.mdm.models.Schedule;
import com.st.mdm.repository.ScheduleRepository;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository repo;

	@Override
	public List<Schedule> createScheduleDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<Schedule> list = new ArrayList<Schedule>();
		JSONObject json;
		Schedule ScheduleData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				ScheduleData = objectMapper.readValue(json.toString(), Schedule.class);
				list.add(ScheduleData);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("data is : " + jsonArray.get(i));
		}
		return repo.saveAll(list);

	}

	@Override
	public List<Schedule> getScheduleDetails(long id) {

		return repo.findAll();
	}

	@Override
	public Schedule updateScheduleDetails(Schedule id) {
		Optional<Schedule> isDb = this.repo.findById(id.getId());
		if (isDb.isPresent()) {
			Schedule isUpdate = isDb.get();
			isUpdate.setCreatedDate(isUpdate.getCreatedDate());
			isUpdate.setUpdatedDate(isUpdate.getUpdatedDate());
			isUpdate.setCustomerNumber(isUpdate.getCustomerNumber());
			isUpdate.setPhoneNumber(isUpdate.getPhoneNumber());
			isUpdate.setPhoneType(isUpdate.getPhoneType());
			isUpdate.setPrioirty(isUpdate.getPrioirty());

			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id.getId());
		}
	}
}
