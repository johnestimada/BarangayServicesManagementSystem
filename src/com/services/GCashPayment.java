package com.barangay.services;

public class GCashPayment implements Payment {
    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid payment amount");
        }
        System.out.println("GCash payment of " + amount + " processed.");
    }
}
