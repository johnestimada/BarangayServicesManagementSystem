package com.barangay.models;

public class Clerk extends Staff {
    private BarangayService service;

    public Clerk(String name) {
        super(name);
    }

    public void setBarangayService(BarangayService service) {
        this.service = service;
    }

    public BarangayService getBarangayService() {
        return service;
    }
}