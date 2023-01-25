package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.AGRCharges;

public interface AGRChargesService {
	List<AGRCharges> createAGRChargesDetails(String inputData);

	public AGRCharges updateAGRChargesDetails(AGRCharges data);

	List<AGRCharges> getAGRChargesDetails(long id);
}
