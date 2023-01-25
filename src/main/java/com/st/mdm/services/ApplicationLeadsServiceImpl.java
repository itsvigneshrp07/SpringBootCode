
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
import com.st.mdm.models.ApplicationLeads;
import com.st.mdm.repository.ApplicationLeadsRepo;

@Service
@Transactional
public class ApplicationLeadsServiceImpl implements ApplicationLeadsService {
	@Autowired
	private ApplicationLeadsRepo repo;

	@Override
	public List<ApplicationLeads> createApplicationLeadsDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<ApplicationLeads> list = new ArrayList<ApplicationLeads>();
		JSONObject json;
		ApplicationLeads AddressData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AddressData = objectMapper.readValue(json.toString(), ApplicationLeads.class);
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
	public List<ApplicationLeads> getApplicationLeadsDetails(long id) {

		return repo.findAll();
	}

	@Override
	public ApplicationLeads updateApplicationLeadsDetails(ApplicationLeads applicationLeads) {
		Optional<ApplicationLeads> isDb = this.repo.findById(applicationLeads.getId());
		if (isDb.isPresent()) {
			ApplicationLeads isUpdate = isDb.get();

			isUpdate.setId(applicationLeads.getId());
			isUpdate.setLeadSourceName(applicationLeads.getLeadSourceName());
			isUpdate.setApplicationReferenceId(applicationLeads.getApplicationReferenceId());
			isUpdate.setApplicationDate(applicationLeads.getApplicationDate());
			isUpdate.setCustomerNumber(applicationLeads.getCustomerNumber());
			isUpdate.setLeadStatus(applicationLeads.getLeadStatus());
			isUpdate.setPartnerName(applicationLeads.getPartnerName());
			isUpdate.setDsaName(applicationLeads.getDsaName());
			isUpdate.setRmName(applicationLeads.getRmName());
			isUpdate.setLastUpdateDate(applicationLeads.getLastUpdateDate());
			isUpdate.setLastUpdateStatus(applicationLeads.getLastUpdateStatus());

			repo.save(isUpdate);
			return isUpdate;

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + applicationLeads.getId());
		}
	}
}