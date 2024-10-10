package com.da.be_ttcs.controller;

import com.da.be_ttcs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class reportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("report-pca")
    public ResponseEntity<?> getReportPca() {
        return ResponseEntity.ok(
                reportService.getCombinedDataForPCA()
        );
    }
}
