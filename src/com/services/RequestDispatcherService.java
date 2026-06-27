package com.barangay.services;

import com.barangay.models.BarangayService;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class RequestDispatcherService {
    private List<BarangayService> requests = new ArrayList<>();

    public void addRequest(BarangayService service) { requests.add(service); }

    public List<BarangayService> sortByStatus() {
        return requests.stream()
                .sorted(Comparator.comparing(BarangayService::getStatus))
                .toList();
    }

    public List<BarangayService> getAllRequests() { return requests; }
}