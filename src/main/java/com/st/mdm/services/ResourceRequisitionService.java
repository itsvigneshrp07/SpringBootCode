
package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.ResourceRequisition;

public interface ResourceRequisitionService {
	List<ResourceRequisition> createResourceRequisition(String inputData);

	public ResourceRequisition updateResourceRequisition(ResourceRequisition data);

	List<ResourceRequisition> getResourceRequisition(long id); // public

}
