package com.barangay.models;

public class ClearanceRequest extends BarangayService {
    public ClearanceRequest() {
        this.serviceName = "Clearance Request";
    }

    @Override
    public void process() {
        this.status = "Processed";
    }
}