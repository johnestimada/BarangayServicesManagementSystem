package com.barangay.models;

public class DocumentRequest extends BarangayService {
    public DocumentRequest() { super("Document Request"); }

    @Override
    public void process() {
        setStatus("Approved");
    }
}
