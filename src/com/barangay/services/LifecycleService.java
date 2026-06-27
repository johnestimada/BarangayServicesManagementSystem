package com.barangay.services;

import com.barangay.models.BarangayService;
import java.util.List;

public class LifecycleService {
    public void track(List<BarangayService> services) {
        for (BarangayService s : services) {
            if (s.getStatus().equals("Pending")) {
                s.setStatus("Approved");
            } else if (s.getStatus().equals("Approved")) {
                s.setStatus("Released");
            }
        }
    }
}
