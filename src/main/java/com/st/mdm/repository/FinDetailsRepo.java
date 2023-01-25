package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.FinDetails;

@Repository
public interface FinDetailsRepo extends JpaRepository<FinDetails, Long> {

}
