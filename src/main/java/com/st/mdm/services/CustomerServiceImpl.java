
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
import com.st.mdm.models.Customer;
import com.st.mdm.repository.CustomerRepo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepo repo;

	@Override
	public List<Customer> createCustomerDetails(String inputData) {
		JSONObject jsonObj = new JSONObject(inputData);
		List<Customer> list = new ArrayList<Customer>();
		JSONObject json;
		Customer AddressData = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			try {
				AddressData = objectMapper.readValue(json.toString(), Customer.class);
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
	public List<Customer> getCustomerDetails(long id) {

		return repo.findAll();
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		Optional<Customer> isDb = this.repo.findById(customer.getId());
		if (isDb.isPresent()) {
			Customer isUpdate = isDb.get();
			isUpdate.setId(customer.getId());
			isUpdate.setCompanyCode(customer.getCompanyCode());
			isUpdate.setSourceSystemName(customer.getSourceSystemName());
			isUpdate.setContactAddressType(customer.getContactAddressType());
			isUpdate.setMailingAddressType(customer.getMailingAddressType());
			isUpdate.setCustomerId(customer.getCustomerId());
			isUpdate.setGroupID(customer.getGroupID());
			isUpdate.setGroupName(customer.getGroupName());
			isUpdate.setCustomerCategory(customer.getCustomerCategory());
			isUpdate.setCustomerType(customer.getCustomerType());
			isUpdate.setTitle(customer.getTitle());
			isUpdate.setFirstName(customer.getFirstName());
			isUpdate.setMiddleName(customer.getMiddleName());
			isUpdate.setLastName(customer.getLastName());
			isUpdate.setGender(customer.getGender());
			isUpdate.setDob(customer.getDob());
			isUpdate.setNationality(customer.getNationality());
			isUpdate.setMaritalStatus(customer.getMaritalStatus());
			isUpdate.setFatherName(customer.getFatherName());
			isUpdate.setMotherName(customer.getMotherName());
			isUpdate.setPanNumber(customer.getPanNumber());
			isUpdate.setAadhaarNumber(customer.getAadhaarNumber());
			isUpdate.setPassportNumber(customer.getPassportNumber());
			isUpdate.setDrivingLicenseNumber(customer.getDrivingLicenseNumber());
			isUpdate.setIdentityCardNumber(customer.getIdentityCardNumber());
			isUpdate.setOccupationType(customer.getOccupationType());
			isUpdate.setEmployerName(customer.getEmployerName());
			isUpdate.setDesignation(customer.getDesignation());
			isUpdate.setYearsOfEmployment(customer.getYearsOfEmployment());
			isUpdate.setIndustryName(customer.getIndustryName());
			isUpdate.setAnnualIncome(customer.getAnnualIncome());
			isUpdate.setFamilyIncome(customer.getFamilyIncome());
			isUpdate.setBankAccountNumber(customer.getBankAccountNumber());
			isUpdate.setBankName(customer.getBankName());
			isUpdate.setIfsc(customer.getIfsc());
			isUpdate.setMicr(customer.getMicr());
			isUpdate.setEmailId(customer.getEmailId());
			isUpdate.setMobileNumber(customer.getMobileNumber());
			isUpdate.setContactPerson(customer.getContactPerson());
			isUpdate.setCustomerCategory(customer.getCustomerCategory());
			isUpdate.setCin(customer.getCin());
			isUpdate.setGstin(customer.getGstin());
			isUpdate.setTan(customer.getTan());
			repo.save(isUpdate);
			return isUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + customer.getId());
		}
	}
}