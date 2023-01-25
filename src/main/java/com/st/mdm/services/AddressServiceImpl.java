
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
import com.st.mdm.models.Address;
import com.st.mdm.repository.AddressRepo;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepo repo;

	@Override
	public List<Address> createAddressDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<Address> list = new ArrayList<Address>();
		JSONObject json;
		Address AddressData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AddressData = objectMapper.readValue(json.toString(), Address.class);
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
	public List<Address> getAddressDetails(long id) {

		return repo.findAll();
	}

	@Override
	public Address updateAddressDetails(Address address) {
		Optional<Address> isDb = this.repo.findById(address.getId());
		if (isDb.isPresent()) {
			Address isUpdate = isDb.get();
			isUpdate.setId(address.getId());
			isUpdate.setCustomerNumber(address.getCustomerNumber());
			isUpdate.setTypeOfAddress(address.getTypeOfAddress());
			isUpdate.setAddress1(address.getAddress1());
			isUpdate.setAddress2(address.getAddress2());
			isUpdate.setAddress3(address.getAddress3());
			isUpdate.setAddress4(address.getAddress4());
			isUpdate.setCity(address.getCity());
			isUpdate.setState(address.getState());
			isUpdate.setZipcode(address.getZipcode());
			repo.save(isUpdate);
			return isUpdate;

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + address.getId());
		}
	}
}