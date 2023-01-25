
package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.ResourceRequisition;

@Repository
public interface ResourceRequisitionRepository extends JpaRepository<ResourceRequisition, Long> {

}
