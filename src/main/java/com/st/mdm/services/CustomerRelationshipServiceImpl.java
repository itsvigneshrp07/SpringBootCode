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
import com.st.mdm.models.Bucket;
import com.st.mdm.models.CustomerRelationship;
import com.st.mdm.models.UcicMaster;
import com.st.mdm.repository.BucketRepository;
import com.st.mdm.repository.CustomerRelationshipRepository;
import com.st.mdm.repository.UcicRepository;

@Service
@Transactional
public class CustomerRelationshipServiceImpl implements CustomerRelationshipService{
	@Autowired
	private CustomerRelationshipRepository repo;

	@Override
	public List<CustomerRelationship> createCustomerRelationshipDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<CustomerRelationship> list = new ArrayList<CustomerRelationship>();
		JSONObject json;
		CustomerRelationship CustomerRelationshipData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				CustomerRelationshipData = objectMapper.readValue(json.toString(), CustomerRelationship.class);
				list.add(CustomerRelationshipData);
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
	public List<CustomerRelationship> getCustomerRelationshipDetails(long id) {
		
		return repo.findAll();
	}

	
	

	@Override
	public CustomerRelationship updateCustomerRelationshipDetails(CustomerRelationship id) {
		Optional<CustomerRelationship> isDb = this.repo.findById(id.getId());
		if (isDb.isPresent()) {
			CustomerRelationship isUpdate = isDb.get();
			isUpdate.setCreatedDate(isUpdate.getCreatedDate());
			isUpdate.setUpdatedDate(isUpdate.getUpdatedDate());
			isUpdate.setLoanAccountNumber(isUpdate.getLoanAccountNumber());
			isUpdate.setCustomerNumber(isUpdate.getCustomerNumber());
			isUpdate.setRoleAssociation(isUpdate.getRoleAssociation());
			isUpdate.setId(isUpdate.getId());
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id.getId());
		}
	}
}
	

	

	
	
	


