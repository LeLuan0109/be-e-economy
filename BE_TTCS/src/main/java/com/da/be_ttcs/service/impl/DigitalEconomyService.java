package com.da.be_ttcs.service.impl;

import com.da.be_ttcs.domain.*;
import com.da.be_ttcs.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigitalEconomyService {
    private final EcommerceStatisticsRepository ecommerceRepo;
    private final DigitalPaymentsRepository paymentsRepo;
    private final TechnicalInfrastructureRepository infrastructureRepo;
    private final InternetPenetrationRepository internetRepo;
    private final HumanResourcesRepository humanResourcesRepo;
    private final SecuritySafetyRepository securityRepo;
    private final PCAService pcaService;

    public DigitalEconomyService(EcommerceStatisticsRepository ecommerceRepo,
                                 DigitalPaymentsRepository paymentsRepo,
                                 TechnicalInfrastructureRepository infrastructureRepo,
                                 InternetPenetrationRepository internetRepo,
                                 HumanResourcesRepository humanResourcesRepo,
                                 SecuritySafetyRepository securityRepo,
                                 PCAService pcaService) {
        this.ecommerceRepo = ecommerceRepo;
        this.paymentsRepo = paymentsRepo;
        this.infrastructureRepo = infrastructureRepo;
        this.internetRepo = internetRepo;
        this.humanResourcesRepo = humanResourcesRepo;
        this.securityRepo = securityRepo;
        this.pcaService = pcaService;
    }

    public PCAResult analyzeDigitalEconomy() {
        List<EcommerceStatistics> ecommerceData = ecommerceRepo.findAll();
        List<DigitalPayments> paymentsData = paymentsRepo.findAll();
        List<TechnicalInfrastructure> infrastructureData = infrastructureRepo.findAll();
        List<InternetPenetration> internetData = internetRepo.findAll();
        List<HumanResources> humanResourcesData = humanResourcesRepo.findAll();
        List<SecuritySafety> securityData = securityRepo.findAll();

        double[][] dataMatrix = prepareDataMatrix(ecommerceData, paymentsData, infrastructureData, internetData, humanResourcesData, securityData);

        return pcaService.performPCA(dataMatrix);
    }

    private double[][] prepareDataMatrix(List<EcommerceStatistics> ecommerceData,
                                         List<DigitalPayments> paymentsData,
                                         List<TechnicalInfrastructure> infrastructureData,
                                         List<InternetPenetration> internetData,
                                         List<HumanResources> humanResourcesData,
                                         List<SecuritySafety> securityData) {
        int dataSize = ecommerceData.size();
        double[][] dataMatrix = new double[dataSize][6]; // Example with 6 features

        for (int i = 0; i < dataSize; i++) {
            dataMatrix[i][0] = ecommerceData.get(i).getRevenueUsdBillion().doubleValue();  // Convert BigDecimal to double
            dataMatrix[i][1] = paymentsData.get(i).getTransactionValueBillion().doubleValue();  // Convert BigDecimal to double
            dataMatrix[i][2] = infrastructureData.get(i).getInternetSpeedMbps().doubleValue();  // Convert BigDecimal to double
            dataMatrix[i][3] = internetData.get(i).getInternetUsersPercent().doubleValue();  // Convert BigDecimal to double
            dataMatrix[i][4] = humanResourcesData.get(i).getTechEmployeesMillion().doubleValue();  // Convert BigDecimal to double
            dataMatrix[i][5] = securityData.get(i).getSecurityIncidents();
        }

        return dataMatrix;
    }
}
