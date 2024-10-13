package com.da.be_ttcs.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PCAResult {
    private double[][] principalComponents;
    private double[] explainedVariance;
    private double[][] loadings;
}
