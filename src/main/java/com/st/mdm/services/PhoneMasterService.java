package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.PhoneMaster;

public interface PhoneMasterService {
	List<PhoneMaster> createPhoneMasterDetails(String inputData);

	public PhoneMaster updatePhoneMasterDetails(PhoneMaster data);

	List<PhoneMaster> getPhoneMasterDetails(long id);
}
