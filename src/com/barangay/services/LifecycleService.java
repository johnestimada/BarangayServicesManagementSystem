package com.barangay.services;

import java.util.List;
import com.barangay.models.BarangayService;
import com.barangay.models.DocumentRequest;
import com.barangay.models.ClearanceRequest;

public class LifecycleService {
    public void track(List<BarangayService> requests) {
        System.out.println("=== Service Lifecycle Tracking ===");
        for (BarangayService req : requests) {
            String requesterName = "Unknown";
            if (req instanceof ClearanceRequest) {
                requesterName = ((ClearanceRequest) req).getRequester().getName();
            } else if (req instanceof DocumentRequest) {
                requesterName = ((DocumentRequest) req).getRequester().getName();
            }
            System.out.println(req.getServiceName() + " for " + requesterName + " - Status: " + req.getStatus());
        }
    }
}