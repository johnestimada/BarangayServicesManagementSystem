
package com.barangay.models;

public class Clerk extends Staff {
    public Clerk(String name) { super(name); }
    public void release(BarangayService service) { service.setStatus("Released"); }
}