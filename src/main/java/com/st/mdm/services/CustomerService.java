package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.Customer;

public interface CustomerService {
	List<Customer> createCustomerDetails(String inputData);

	public Customer updateCustomerDetails(Customer data);

	List<Customer> getCustomerDetails(long id);
}
