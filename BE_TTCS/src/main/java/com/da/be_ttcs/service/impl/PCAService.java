package com.da.be_ttcs.service.impl;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.springframework.stereotype.Service;

@Service
public class PCAService {
    public PCAResult performPCA(double[][] inputData) {
        RealMatrix matrix = new Array2DRowRealMatrix(inputData);

        SingularValueDecomposition svd = new SingularValueDecomposition(matrix);

        RealMatrix u = svd.getU(); // Principal Components
        double[] singularValues = svd.getSingularValues(); // Eigenvalues
        double totalVariance = 0;
        for (double val : singularValues) {
            totalVariance += val * val;
        }

        double[] explainedVariance = new double[singularValues.length];
        for (int i = 0; i < singularValues.length; i++) {
            explainedVariance[i] = (singularValues[i] * singularValues[i]) / totalVariance;
        }

        RealMatrix v = svd.getV(); // Eigenvectors (Loadings)

        return new PCAResult(u.getData(), explainedVariance, v.getData());
    }
}
