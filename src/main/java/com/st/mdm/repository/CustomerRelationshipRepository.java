package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.mdm.models.CustomerRelationship;

public interface CustomerRelationshipRepository extends JpaRepository<CustomerRelationship,Long> {

}
