package com.barangay.models;

public class ClearanceRequest extends BarangayService {
    private Resident requester;

    public ClearanceRequest(Resident requester) {
        this.requester = requester;
        this.setServiceName("Clearance Request");
        this.setStatus("Pending");
        System.out.println("\nClearance request created for " + requester.getName());
    }

    public Resident getRequester() { return requester; }

    @Override
    public void process() {
        System.out.println("Processing clearance request for " + requester.getName());
        this.setStatus("Processed");
    }

    @Override
    public String toString() {
        return "ClearanceRequest{requester=" + requester.getName() + ", status=" + getStatus() + "}";
    }
}