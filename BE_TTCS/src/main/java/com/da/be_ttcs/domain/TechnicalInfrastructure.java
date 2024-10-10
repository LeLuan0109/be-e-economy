package com.da.be_ttcs.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "technical_infrastructure")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalInfrastructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "internet_speed_mbps", precision = 10, scale = 2, nullable = false)
    private BigDecimal internetSpeedMbps;

    @Column(name = "broadband_subscribers_million", precision = 10, scale = 2, nullable = false)
    private BigDecimal broadbandSubscribersMillion;

    @Column(name = "mobile_subscribers_million", precision = 10, scale = 2, nullable = false)
    private BigDecimal mobileSubscribersMillion;

}
