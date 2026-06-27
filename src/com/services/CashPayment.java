package com.barangay.services;

public class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid payment");
        System.out.println("Cash payment of " + amount + " processed.");
    }
}
