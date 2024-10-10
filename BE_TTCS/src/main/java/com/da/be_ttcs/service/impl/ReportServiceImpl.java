package com.da.be_ttcs.service.impl;

import com.da.be_ttcs.domain.*;
import com.da.be_ttcs.repository.*;
import com.da.be_ttcs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private DigitalPaymentsRepository digitalPaymentsRepository;
    @Autowired
    private EcommerceStatisticsRepository ecommerceStatisticsRepository;
    @Autowired
    private HumanResourcesRepository humanResourcesRepository;
    @Autowired
    private InternetPenetrationRepository internetPenetrationRepository;
    @Autowired
    private SecuritySafetyRepository securitySafetyRepository;
    @Autowired
     private TechnicalInfrastructureRepository technicalInfrastructureRepository;


    @Override
    public Object getCombinedDataForPCA() {
        List<EcommerceStatistics> ecommerceData = ecommerceStatisticsRepository.findAll();
        List<DigitalPayments> paymentData = digitalPaymentsRepository.findAll();
        List<TechnicalInfrastructure> techData = technicalInfrastructureRepository.findAll();
        List<InternetPenetration> internetData = internetPenetrationRepository.findAll();
        List<HumanResources> hrData = humanResourcesRepository.findAll();
        List<SecuritySafety> securityData = securitySafetyRepository.findAll();

        // Kết hợp dữ liệu thành Map để thực hiện PCA với nhãn cho từng giá trị
        return combineData(ecommerceData, paymentData, techData, internetData, hrData, securityData);
    }

    private List<Map<String, Object>> combineData(List<EcommerceStatistics> ecommerceData,
                                                  List<DigitalPayments> paymentData,
                                                  List<TechnicalInfrastructure> techData,
                                                  List<InternetPenetration> internetData,
                                                  List<HumanResources> hrData,
                                                  List<SecuritySafety> securityData) {

        int dataSize = ecommerceData.size();  // Lấy số lượng bản ghi
        List<Map<String, Object>> combinedData = new ArrayList<>();  // Tạo danh sách Map

        for (int i = 0; i < dataSize; i++) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("revenue_usd_billion", ecommerceData.get(i).getRevenueUsdBillion().doubleValue());
            dataMap.put("transaction_count_million", ecommerceData.get(i).getTransactionCountMillion().doubleValue());
            dataMap.put("payment_value_billion", paymentData.get(i).getTransactionValueBillion().doubleValue());
            dataMap.put("payment_users_million", paymentData.get(i).getUsersMillion().doubleValue());
            dataMap.put("internet_speed_mbps", techData.get(i).getInternetSpeedMbps().doubleValue());
            dataMap.put("internet_users_percent", internetData.get(i).getInternetUsersPercent().doubleValue());
            dataMap.put("tech_employees_million", hrData.get(i).getTechEmployeesMillion().doubleValue());
            dataMap.put("security_incidents", (double) securityData.get(i).getSecurityIncidents());  // Chuyển về kiểu double
            dataMap.put("security_spending_billion", securityData.get(i).getSecuritySpendingBillion().doubleValue());
            dataMap.put("graduates_thousand", (double) hrData.get(i).getGraduatesThousand());  // Chuyển về kiểu double

            combinedData.add(dataMap);
        }

        return combinedData;
    }
}