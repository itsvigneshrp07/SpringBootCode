
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
import com.st.mdm.models.FinDetails;
import com.st.mdm.repository.FinDetailsRepo;

@Service
@Transactional
public class FinDetailsServiceImpl implements FinDetailsService {
	@Autowired
	private FinDetailsRepo repo;

	@Override
	public List<FinDetails> createFinDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<FinDetails> list = new ArrayList<FinDetails>();
		JSONObject json;
		FinDetails AddressData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AddressData = objectMapper.readValue(json.toString(), FinDetails.class);
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
	public List<FinDetails> getFinDetails(long id) {

		return repo.findAll();
	}

	@Override
	public FinDetails updateFinDetails(FinDetails finDetails) {
		Optional<FinDetails> isDb = this.repo.findById(finDetails.getId());
		if (isDb.isPresent()) {
			FinDetails isUpdate = isDb.get();
			isUpdate.setId(finDetails.getId());
			isUpdate.setLoanAccountNumber(finDetails.getLoanAccountNumber());
			isUpdate.setPaymentReferenceNumber(finDetails.getPaymentReferenceNumber());
			isUpdate.setPaymentPostingDate(finDetails.getPaymentPostingDate());
			isUpdate.setValueDate(finDetails.getValueDate());
			isUpdate.setTransactionCode(finDetails.getTransactionCode());
			isUpdate.setPaymentMode(finDetails.getPaymentMode());
			isUpdate.setNarration(finDetails.getNarration());
			isUpdate.setDebit(finDetails.getDebit());
			isUpdate.setStatus(finDetails.getStatus());
			isUpdate.setTypeOfInstrument(finDetails.getTypeOfInstrument());
			isUpdate.setInstrumentDate(finDetails.getInstrumentDate());
			isUpdate.setInstrumentNumber(finDetails.getInstrumentNumber());
			isUpdate.setDepositDate(finDetails.getDepositDate());
			isUpdate.setBankName(finDetails.getBankName());
			isUpdate.setBranchName(finDetails.getBranchName());
			isUpdate.setReceiptNumber(finDetails.getReceiptNumber());
			isUpdate.setBounceDate(finDetails.getBounceDate());
			isUpdate.setBounceReason(finDetails.getBounceReason());
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + finDetails.getId());
		}
	}
}