package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.AGRCharges;

@Repository
public interface AGRChargesRepo extends JpaRepository<AGRCharges, Long> {

}
