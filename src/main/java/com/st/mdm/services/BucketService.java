package com.st.mdm.services;
import java.util.List;

import com.st.mdm.models.Bucket;
import com.st.mdm.models.UcicMaster;
public interface BucketService {
	List<Bucket> createBucketDetails(String inputData);
	public Bucket updateBucketDetails(Bucket data);
	List<Bucket> getBucketDetails(long id);
	//public UcicMaster updateProjectDetails(UcicMaster data);

}
