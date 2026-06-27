package com.barangay.models;

public class DocumentRequest extends BarangayService {
    private Resident requester;

    public DocumentRequest(Resident requester) {
        this.requester = requester;
        this.setServiceName("Document Request");
        this.setStatus("Pending");
        System.out.println("\nDocument request created for " + requester.getName());
    }

    public Resident getRequester() { return requester; }

    @Override
    public void process() {
        System.out.println("Processing document request for " + requester.getName());
        this.setStatus("Processed");
    }

    @Override
    public String toString() {
        return "DocumentRequest{requester=" + requester.getName() + ", status=" + getStatus() + "}";
    }
}