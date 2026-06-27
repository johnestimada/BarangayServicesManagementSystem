package com.barangay.models;

public class Admin extends Staff {
    public Admin(String name) {
        super(name);
    }

    public void approveBarangayService(BarangayService service) {
        service.setStatus("Approved");
    }
}