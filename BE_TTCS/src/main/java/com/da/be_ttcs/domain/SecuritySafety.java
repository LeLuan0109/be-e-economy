package com.da.be_ttcs.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "security_safety")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SecuritySafety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private int month;
    private int securityIncidents;
    private Long securitySpendingBillion;
    private int cybersecurityProfessionalsThousand;

}
