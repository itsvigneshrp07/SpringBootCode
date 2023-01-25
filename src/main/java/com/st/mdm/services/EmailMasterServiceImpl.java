
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
import com.st.mdm.models.EmailMaster;
import com.st.mdm.repository.EmailMasterRepo;

@Service
@Transactional
public class EmailMasterServiceImpl implements EmailMasterService {
	@Autowired
	private EmailMasterRepo repo;

	@Override
	public List<EmailMaster> createEmailMasterDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<EmailMaster> list = new ArrayList<EmailMaster>();
		JSONObject json;
		EmailMaster AddressData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AddressData = objectMapper.readValue(json.toString(), EmailMaster.class);
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
	public List<EmailMaster> getEmailMasterDetails(long id) {

		return repo.findAll();
	}

	@Override
	public EmailMaster updateEmailMasterDetails(EmailMaster emailMaster) {
		Optional<EmailMaster> isDb = this.repo.findById(emailMaster.getId());
		if (isDb.isPresent()) {
			EmailMaster isUpdate = isDb.get();

			isUpdate.setId(emailMaster.getId());
			isUpdate.setCustomerNumber(emailMaster.getCustomerNumber());
			isUpdate.setEmailType(emailMaster.getEmailType());
			isUpdate.setEmailId(emailMaster.getEmailId());
			isUpdate.setPrioirty(emailMaster.getPrioirty());

			repo.save(isUpdate);
			return isUpdate;

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + emailMaster.getId());
		}
	}

}