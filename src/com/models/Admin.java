package com.barangay.models;

public class Admin extends Staff {
    public Admin(String name) { super(name); }
    public void approve(BarangayService service) { service.setStatus("Approved"); }
}
