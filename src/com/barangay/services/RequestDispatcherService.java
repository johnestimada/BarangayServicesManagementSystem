package com.barangay.services;

import com.barangay.models.BarangayService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RequestDispatcherService {
    private List<BarangayService> requests = new ArrayList<>();

    public void addRequest(BarangayService service) {
        requests.add(service);
    }

    public List<BarangayService> getRequests() {
        return requests;
    }

    public List<BarangayService> sortByStatus() {
        requests.sort(Comparator.comparing(BarangayService::getStatus));
        return requests;
    }
}
