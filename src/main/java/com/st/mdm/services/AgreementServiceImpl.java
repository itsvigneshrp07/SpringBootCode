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
import com.st.mdm.models.Agreements;
import com.st.mdm.repository.AgreementRepository;

@Service
@Transactional
public class AgreementServiceImpl implements AgreementService {
	@Autowired
	private AgreementRepository repo;

	@Override
	public List<Agreements> createAgreementDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<Agreements> list = new ArrayList<Agreements>();
		JSONObject json;
		Agreements AgreementData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AgreementData = objectMapper.readValue(json.toString(), Agreements.class);
				list.add(AgreementData);
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
	public List<Agreements> getAgreementDetails(long id) {

		return repo.findAll();
	}

	@Override
	public Agreements updateAgreementDetails(Agreements id) {
		Optional<Agreements> isDb = this.repo.findById(id.getId());
		if (isDb.isPresent()) {
			Agreements isUpdate = isDb.get();
			isUpdate.setCreatedDate(isUpdate.getCreatedDate());
			isUpdate.setLoanAccountNumber(isUpdate.getLoanAccountNumber());

			isUpdate.setId(isUpdate.getId());
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id.getId());
		}
	}
}
