package com.da.be_ttcs.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "internet_penetration")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InternetPenetration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "internet_users_percent", precision = 5, scale = 2, nullable = false)
    private BigDecimal internetUsersPercent;

    @Column(name = "broadband_coverage_percent", precision = 5, scale = 2, nullable = false)
    private BigDecimal broadbandCoveragePercent;

    @Column(name = "mobile_coverage_percent", precision = 5, scale = 2, nullable = false)
    private BigDecimal mobileCoveragePercent;
}
