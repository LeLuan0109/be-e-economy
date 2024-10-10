package com.da.be_ttcs.repository;

import com.da.be_ttcs.domain.SecuritySafety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecuritySafetyRepository extends JpaRepository<SecuritySafety, Long> {
}