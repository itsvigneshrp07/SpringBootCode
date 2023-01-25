package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.Agreements;

public interface AgreementService {
	List<Agreements> createAgreementDetails(String inputData);

	public Agreements updateAgreementDetails(Agreements data);

	List<Agreements> getAgreementDetails(long id);
	// public UcicMaster updateProjectDetails(UcicMaster data);

}
