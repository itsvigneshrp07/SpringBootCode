package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.ApplicationLeads;

@Repository
public interface ApplicationLeadsRepo extends JpaRepository<ApplicationLeads, Long> {

}
