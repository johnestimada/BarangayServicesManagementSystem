package com.barangay.models;

public abstract class BarangayService {
    protected String serviceName;
    protected String status = "Pending";

    public BarangayService(String serviceName) {
        this.serviceName = serviceName;
    }
    
     public abstract void process();

    public String getServiceName() { return serviceName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}