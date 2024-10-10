package com.da.be_ttcs.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "digital_payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DigitalPayments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "transaction_value_billion", precision = 10, scale = 2, nullable = false)
    private BigDecimal transactionValueBillion;

    @Column(name = "transaction_count_million", precision = 10, scale = 2, nullable = false)
    private BigDecimal transactionCountMillion;

    @Column(name = "users_million", precision = 10, scale = 2, nullable = false)
    private BigDecimal usersMillion;
}
