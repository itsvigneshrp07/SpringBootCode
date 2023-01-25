package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
