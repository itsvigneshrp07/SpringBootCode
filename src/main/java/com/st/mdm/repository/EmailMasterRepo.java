package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.EmailMaster;

@Repository
public interface EmailMasterRepo extends JpaRepository<EmailMaster, Long> {

}
