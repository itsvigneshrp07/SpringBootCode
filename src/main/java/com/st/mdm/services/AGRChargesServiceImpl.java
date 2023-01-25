
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
import com.st.mdm.models.AGRCharges;
import com.st.mdm.repository.AGRChargesRepo;

@Service
@Transactional
public class AGRChargesServiceImpl implements AGRChargesService {
	@Autowired
	private AGRChargesRepo repo;

	@Override
	public List<AGRCharges> createAGRChargesDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<AGRCharges> list = new ArrayList<AGRCharges>();
		JSONObject json;
		AGRCharges AGRCharges = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AGRCharges = objectMapper.readValue(json.toString(), AGRCharges.class);
				list.add(AGRCharges);
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
	public List<AGRCharges> getAGRChargesDetails(long id) {

		return repo.findAll();
	}

	@Override
	public AGRCharges updateAGRChargesDetails(AGRCharges address) {
		Optional<AGRCharges> isDb = this.repo.findById(address.getId());
		if (isDb.isPresent()) {
			AGRCharges isUpdate = isDb.get();
			isUpdate.setId(address.getId());
			isUpdate.setLoanAccountNumber(address.getLoanAccountNumber());
			isUpdate.setPaymentHead(address.getPaymentHead());
			isUpdate.setOutstandingAmount(address.getOutstandingAmount());
			isUpdate.setAmountPaidTillNow(address.getAmountPaidTillNow());
			isUpdate.setAmountWaivedTillNow(address.getAmountWaivedTillNow());
			isUpdate.setOrderDueAmount(address.getOrderDueAmount());
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + address.getId());
		}
	}

}