
package com.barangay.models;

public class ClearanceRequest extends BarangayService {
    public ClearanceRequest() { super("Clearance Request"); }

    @Override
    public void process() {
        setStatus("Released");
    }
}