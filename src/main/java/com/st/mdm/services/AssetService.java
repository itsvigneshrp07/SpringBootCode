package com.st.mdm.services;

import java.util.List;

import com.st.mdm.models.Asset;

public interface AssetService {
	List<Asset> createAssetDetails(String inputData);

	public Asset updateAssetDetails(Asset data);

	List<Asset> getAssetDetails(long id);
	// public UcicMaster updateProjectDetails(UcicMaster data);

}
