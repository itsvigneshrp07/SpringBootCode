package com.st.mdm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.mdm.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmpId(String empId);

	Optional<User> findByEmail(String email);
	
	Boolean existsByEmpId(String empId);

	Boolean existsByEmail(String email);
}
