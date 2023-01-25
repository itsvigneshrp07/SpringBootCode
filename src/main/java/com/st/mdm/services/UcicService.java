package com.st.mdm.services;
import java.util.List;


import com.st.mdm.models.UcicMaster;
public interface UcicService {
	List<UcicMaster> createUcicDetails(String inputData);
	public UcicMaster updateUcicDetails(UcicMaster data);
	List<UcicMaster> getUcicDetails(long id);
	//public UcicMaster updateProjectDetails(UcicMaster data);

}
