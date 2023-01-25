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
import com.st.mdm.models.Asset;
import com.st.mdm.repository.AssetRepository;

@Service
@Transactional
public class AssetServiceImpl implements AssetService {
	@Autowired
	private AssetRepository repo;

	@Override
	public List<Asset> createAssetDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<Asset> list = new ArrayList<Asset>();
		JSONObject json;
		Asset AssetData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AssetData = objectMapper.readValue(json.toString(), Asset.class);
				list.add(AssetData);
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
	public List<Asset> getAssetDetails(long id) {

		return repo.findAll();
	}

	@Override
	public Asset updateAssetDetails(Asset id) {
		Optional<Asset> isDb = this.repo.findById(id.getId());
		if (isDb.isPresent()) {
			Asset isUpdate = isDb.get();
			isUpdate.setCreatedDate(isUpdate.getCreatedDate());
			isUpdate.setCustomerNumber(isUpdate.getCustomerNumber());
			isUpdate.setTypeOfAddress(isUpdate.getTypeOfAddress());
			isUpdate.setAddress1(isUpdate.getAddress1());
			isUpdate.setAddress2(isUpdate.getAddress2());
			isUpdate.setAddress3(isUpdate.getAddress3());
			isUpdate.setAddress4(isUpdate.getAddress4());
			isUpdate.setCity(isUpdate.getCity());
			isUpdate.setState(isUpdate.getState());
			isUpdate.setZipcode(isUpdate.getZipcode());

			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + id.getId());
		}
	}
}
