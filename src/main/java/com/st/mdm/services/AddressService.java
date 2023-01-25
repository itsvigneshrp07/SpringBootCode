package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.Address;

public interface AddressService {
	List<Address> createAddressDetails(String inputData);

	public Address updateAddressDetails(Address data);

	List<Address> getAddressDetails(long id);
}
