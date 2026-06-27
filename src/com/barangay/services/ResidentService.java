package com.barangay.services;

import com.barangay.models.Resident;
import java.util.ArrayList;
import java.util.List;

public class ResidentService {
    private List<Resident> residents = new ArrayList<>();

    public void registerResident(Resident resident) {
        residents.add(resident);
        System.out.println("Registered successfully!");
    }

    public List<Resident> getAllResidents() {
        return residents;
    }
}