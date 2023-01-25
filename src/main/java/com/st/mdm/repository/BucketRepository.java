package com.st.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.mdm.models.Bucket;

public interface BucketRepository extends JpaRepository<Bucket, Long> {

}
