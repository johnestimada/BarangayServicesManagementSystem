package com.barangay.ui;

public class MenuNavigator {

    public static void showMainMenu() {
        System.out.println("=== Barangay Service System ===");
        System.out.println("1. Resident Registration Menu");
        System.out.println("2. Document Request Dispatcher Menu");
        System.out.println("3. Payment Simulation Menu");
        System.out.println("4. Service Lifecycle Tracking");
        System.out.println("5. View Residents");
        System.out.println("6. View Requests");
        System.out.println("7. View Transaction Logs");
        System.out.println("8. Admin Approve Requests");
        System.out.println("9. Clerk Assign Requests");
        System.out.println("10. Exit");
    }

    public static void showResidentMenu() {
        System.out.println("=== Resident Registration Menu ===");
        System.out.println("1. Register New Resident");
        System.out.println("2. Back to Main Menu");
    }

    public static void showRequestMenu() {
        System.out.println("=== Document Request  Dispatcher Menu ===");
        System.out.println("1. Document Request");
        System.out.println("2. Clearance Request");
        System.out.println("3. Back to Main Menu");
    }

    public static void showPaymentMenu() {
        System.out.println("=== Payment Simulation Menu ===");
        System.out.println("1. Cash Payment");
        System.out.println("2. GCash Payment");
        System.out.println("3. Back to Main Menu");
    }
}