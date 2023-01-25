package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.PhoneMaster;

@Repository
public interface PhoneMasterRepo extends JpaRepository<PhoneMaster, Long> {

}
