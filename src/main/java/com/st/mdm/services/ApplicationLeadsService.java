package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.ApplicationLeads;

public interface ApplicationLeadsService {
	List<ApplicationLeads> createApplicationLeadsDetails(String inputData);

	public ApplicationLeads updateApplicationLeadsDetails(ApplicationLeads data);

	List<ApplicationLeads> getApplicationLeadsDetails(long id);
}
