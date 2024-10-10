package com.da.be_ttcs.repository;

import com.da.be_ttcs.domain.HumanResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanResourcesRepository extends JpaRepository<HumanResources, Long> {
}
