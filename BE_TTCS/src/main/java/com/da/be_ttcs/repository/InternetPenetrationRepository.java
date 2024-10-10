package com.da.be_ttcs.repository;

import com.da.be_ttcs.domain.InternetPenetration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternetPenetrationRepository  extends JpaRepository<InternetPenetration, Long> {
}
