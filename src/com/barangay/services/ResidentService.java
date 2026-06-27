package com.barangay.services;

import com.barangay.models.Resident;
import java.util.ArrayList;
import java.util.List;

public class ResidentService {
    private List<Resident> residents = new ArrayList<>();

    public void registerResident(Resident r) {
        residents.add(r);
    }

    public List<Resident> getAllResidents() {
        return residents;
    }

    public Resident searchByName(String name) {
        return residents.stream()
            .filter(r -> r.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }
}