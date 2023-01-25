package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.mdm.models.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}
