
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
import com.st.mdm.models.PhoneMaster;
import com.st.mdm.repository.PhoneMasterRepo;

@Service
@Transactional
public class PhoneMasterServiceImpl implements PhoneMasterService {
	@Autowired
	private PhoneMasterRepo repo;

	@Override
	public List<PhoneMaster> createPhoneMasterDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<PhoneMaster> list = new ArrayList<PhoneMaster>();
		JSONObject json;
		PhoneMaster AddressData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AddressData = objectMapper.readValue(json.toString(), PhoneMaster.class);
				list.add(AddressData);
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
	public List<PhoneMaster> getPhoneMasterDetails(long id) {

		return repo.findAll();
	}

	@Override
	public PhoneMaster updatePhoneMasterDetails(PhoneMaster phoneMaster) {
		Optional<PhoneMaster> isDb = this.repo.findById(phoneMaster.getId());
		if (isDb.isPresent()) {
			PhoneMaster isUpdate = isDb.get();

			isUpdate.setId(phoneMaster.getId());
			isUpdate.setCustomerNumber(phoneMaster.getCustomerNumber());
			isUpdate.setPhoneNumber(phoneMaster.getPhoneNumber());
			isUpdate.setPhoneType(phoneMaster.getPhoneType());
			isUpdate.setPrioirty(phoneMaster.getPrioirty());

			repo.save(isUpdate);
			return isUpdate;

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + phoneMaster.getId());
		}
	}
}