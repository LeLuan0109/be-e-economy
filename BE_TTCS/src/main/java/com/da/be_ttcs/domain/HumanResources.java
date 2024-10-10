package com.da.be_ttcs.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "human_resources")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HumanResources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "tech_employees_million", precision = 10, scale = 2, nullable = false)
    private BigDecimal techEmployeesMillion;

    @Column(name = "graduates_thousand", nullable = false)
    private int graduatesThousand;

    @Column(name = "training_programs", nullable = false)
    private int trainingPrograms;
}