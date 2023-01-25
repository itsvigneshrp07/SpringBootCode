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

import com.st.mdm.models.UcicMaster;
import com.st.mdm.repository.UcicRepository;

@Service
@Transactional
public class UcicServiceImpl implements UcicService{
	@Autowired
	private UcicRepository repo;

	@Override
	public List<UcicMaster> createUcicDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<UcicMaster> list = new ArrayList<UcicMaster>();
		JSONObject json;
		UcicMaster UcicMasterData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				UcicMasterData = objectMapper.readValue(json.toString(), UcicMaster.class);
				list.add(UcicMasterData);
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
	public List<UcicMaster> getUcicDetails(long id) {
		
		return repo.findAll();
	}

	
	

	@Override
	public UcicMaster updateUcicDetails(UcicMaster id) {
		Optional<UcicMaster> isDb = this.repo.findById(id.getId());
		if (isDb.isPresent()) {
			UcicMaster isUpdate = isDb.get();
			isUpdate.setAccountStatus(isUpdate.getAccountStatus());
			isUpdate.setApplicationNumber(isUpdate.getApplicationNumber());
			isUpdate.setCustomerNumber(isUpdate.getCustomerNumber());
			isUpdate.setGucic(isUpdate.getGucic());
			isUpdate.setUcic(isUpdate.getUcic());
			isUpdate.setCreatedDate(isUpdate.getCreatedDate());
			isUpdate.setUpdatedDate(isUpdate.getUpdatedDate());
			isUpdate.setSourceSystemName(isUpdate.getSourceSystemName());
			isUpdate.setLoanAccountNumber(isUpdate.getLoanAccountNumber());
	
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id.getId());
		}
	}
}
	

	

	
	
	


