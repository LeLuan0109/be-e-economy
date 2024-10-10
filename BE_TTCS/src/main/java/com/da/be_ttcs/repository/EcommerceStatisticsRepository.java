package com.da.be_ttcs.repository;

import com.da.be_ttcs.domain.EcommerceStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceStatisticsRepository extends JpaRepository<EcommerceStatistics, Long> {
}
