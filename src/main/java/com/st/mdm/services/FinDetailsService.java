package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.FinDetails;

public interface FinDetailsService {
	List<FinDetails> createFinDetails(String inputData);

	public FinDetails updateFinDetails(FinDetails data);

	List<FinDetails> getFinDetails(long id);
}
