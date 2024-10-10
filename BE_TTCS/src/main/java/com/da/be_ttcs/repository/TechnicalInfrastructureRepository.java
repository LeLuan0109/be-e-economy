package com.da.be_ttcs.repository;

import com.da.be_ttcs.domain.TechnicalInfrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalInfrastructureRepository extends JpaRepository<TechnicalInfrastructure, Long> {
}
