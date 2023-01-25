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
import com.st.mdm.repository.BucketRepository;

@Service
@Transactional
public class BucketServiceImpl implements BucketService {
	@Autowired
	private BucketRepository repo;

	@Override
	public List<Bucket> createBucketDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<Bucket> list = new ArrayList<Bucket>();
		JSONObject json;
		Bucket BucketData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				BucketData = objectMapper.readValue(json.toString(), Bucket.class);
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
	public List<Bucket> getBucketDetails(long id) {

		return repo.findAll();
	}

	@Override
	public Bucket updateBucketDetails(Bucket id) {
		Optional<Bucket> isDb = this.repo.findById(id.getId());
		if (isDb.isPresent()) {
			Bucket isUpdate = isDb.get();
			isUpdate.setCreatedDate(isUpdate.getCreatedDate());
			isUpdate.setCustomerNumber(isUpdate.getCustomerNumber());
			isUpdate.setEmailId(isUpdate.getEmailId());
			isUpdate.setEmailType(isUpdate.getEmailType());
			isUpdate.setPrioirty(isUpdate.getPrioirty());
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id.getId());
		}
	}
}
