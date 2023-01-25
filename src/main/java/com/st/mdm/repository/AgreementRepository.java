package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.mdm.models.Agreements;

public interface AgreementRepository extends JpaRepository<Agreements,Long> {

}
