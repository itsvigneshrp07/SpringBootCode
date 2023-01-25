package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
