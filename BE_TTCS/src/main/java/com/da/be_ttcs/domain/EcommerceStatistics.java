package com.da.be_ttcs.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "ecommerce_statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EcommerceStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "revenue_usd_billion", precision = 10, scale = 2, nullable = false)
    private BigDecimal revenueUsdBillion;

    @Column(name = "transaction_count_million", precision = 10, scale = 2, nullable = false)
    private BigDecimal transactionCountMillion;

    @Column(name = "participating_businesses", nullable = false)
    private int participatingBusinesses;

    @Column(name = "online_shopping_user_rate", precision = 3, scale = 2, nullable = false)
    private BigDecimal onlineShoppingUserRate;

}
