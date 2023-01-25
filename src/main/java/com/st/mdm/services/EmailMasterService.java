package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.EmailMaster;

public interface EmailMasterService {
	List<EmailMaster> createEmailMasterDetails(String inputData);

	public EmailMaster updateEmailMasterDetails(EmailMaster data);

	List<EmailMaster> getEmailMasterDetails(long id);
}
