package com.st.mdm.services;
import java.util.List;

import com.st.mdm.models.Bucket;
import com.st.mdm.models.CustomerRelationship;
import com.st.mdm.models.UcicMaster;
public interface CustomerRelationshipService {
	List<CustomerRelationship> createCustomerRelationshipDetails(String inputData);
	public CustomerRelationship updateCustomerRelationshipDetails(CustomerRelationship data);
	List<CustomerRelationship> getCustomerRelationshipDetails(long id);
	//public UcicMaster updateProjectDetails(UcicMaster data);

}
