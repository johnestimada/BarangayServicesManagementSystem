package com.barangay.models;

public class DocumentRequest extends BarangayService {
    public DocumentRequest() {
        this.serviceName = "Document Request";
    }

    @Override
    public void process() {
        this.status = "Processed";
    }
}
