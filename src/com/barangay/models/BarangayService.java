package com.barangay.models;

import java.util.Objects;

public abstract class BarangayService {
    protected String serviceName;
    protected String status;

    public String getServiceName() {return serviceName;}
    public void setServiceName(String serviceName) {this.serviceName = serviceName;}    

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public abstract void process();

    @Override
    public String toString() {
        return "BarangayService{serviceName='" + serviceName + "', status='" + status + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BarangayService)) return false;
        BarangayService other = (BarangayService) o;
        return Objects.equals(serviceName, other.serviceName) && Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, status);
    }
}