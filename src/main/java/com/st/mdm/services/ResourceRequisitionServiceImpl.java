
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
import com.st.mdm.models.ResourceRequisition;
import com.st.mdm.repository.ResourceRequisitionRepository;

@Service

@Transactional
public class ResourceRequisitionServiceImpl implements ResourceRequisitionService {

	@Autowired
	private ResourceRequisitionRepository repo;

	@Override
	public List<ResourceRequisition> createResourceRequisition(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<ResourceRequisition> list = new ArrayList<ResourceRequisition>();
		JSONObject json;
		ResourceRequisition BucketData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				BucketData = objectMapper.readValue(json.toString(), ResourceRequisition.class);
				list.add(BucketData);
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
	public List<ResourceRequisition> getResourceRequisition(long id) {
		return repo.findAll();
	}

	@Override
	public ResourceRequisition updateResourceRequisition(ResourceRequisition id) {
		Optional<ResourceRequisition> isDb = this.repo.findById(id.getId());
		if (isDb.isPresent()) {
			ResourceRequisition isUpdate = isDb.get();
			isUpdate.setClientName(isUpdate.getClientName());
			isUpdate.setFunction(isUpdate.getFunction());
			isUpdate.setJobTitle(isUpdate.getJobTitle());
			isUpdate.setNoOfRequirements(isUpdate.getNoOfRequirements());
			isUpdate.setExistingStaffAtPresent(isUpdate.getExistingStaffAtPresent());
			isUpdate.setLocation(isUpdate.getLocation());
			isUpdate.setTypeOfAppointment(isUpdate.getTypeOfAppointment());
			isUpdate.setEducationalQualification(isUpdate.getEducationalQualification());
			isUpdate.setSkills(isUpdate.getSkills());
			isUpdate.setExperience(isUpdate.getExperience());
			isUpdate.setJobDescription(isUpdate.getJobDescription());
			isUpdate.setTentativeDateofJoining(isUpdate.getTentativeDateofJoining());
			isUpdate.setVacancyCausedDueTo(isUpdate.getVacancyCausedDueTo());
			isUpdate.setInternalTransfer(isUpdate.getInternalTransfer());
			isUpdate.setSalaryRange(isUpdate.getSalaryRange());
			isUpdate.setPriorityLevel(isUpdate.getPriorityLevel());
			isUpdate.setCreatedDate(isUpdate.getCreatedDate());
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id.getId());
		}
	}
}
