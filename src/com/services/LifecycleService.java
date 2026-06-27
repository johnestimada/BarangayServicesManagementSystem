package com.barangay.services;

import com.barangay.models.BarangayService;

public class LifecycleService {
    public void approve(BarangayService service) { service.setStatus("Approved"); }
    public void release(BarangayService service) { service.setStatus("Released"); }
}
