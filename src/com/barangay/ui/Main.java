package com.barangay.ui;

import com.barangay.models.Resident;
import com.barangay.models.DocumentRequest;
import com.barangay.models.ClearanceRequest;
import com.barangay.models.TransactionLog;
import com.barangay.services.ResidentService;
import com.barangay.services.RequestDispatcherService;
import com.barangay.services.CashPayment;
import com.barangay.services.GCashPayment;
import com.barangay.services.Payment;
import com.barangay.services.TransactionResult;
import com.barangay.services.LifecycleService;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ResidentService residentService = new ResidentService();
        RequestDispatcherService dispatcher = new RequestDispatcherService();
        LifecycleService lifecycle = new LifecycleService();
        List<TransactionLog> logs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            MenuNavigator.showMainMenu();
            System.out.print("Enter choice: ");
            int choice = sc.hasNextInt() ? sc.nextInt() : -1;
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== Resident Registration Menu ===");
                    System.out.println("1. Register New Resident");
                    System.out.println("2. Back to Main Menu");
                    int resChoice = sc.hasNextInt() ? sc.nextInt() : -1;
                    sc.nextLine();
                    if (resChoice == 1) {
                        System.out.print("Enter resident name: ");
                        String name = sc.nextLine();
                        while (name.matches(".*\\d.*") || name.trim().isEmpty()) {
                            System.out.println("Invalid name. Try again.");
                            name = sc.nextLine();
                        }
                        System.out.print("Enter age: ");
                        int age = sc.hasNextInt() ? sc.nextInt() : 0;
                        sc.nextLine();
                        Resident r = new Resident(name, age);
                        residentService.registerResident(r);
                        logs.add(new TransactionLog("Registered resident: " + r));
                    }
                    break;

                case 2:
                    System.out.println("=== Document Request Dispatcher Menu ===");
                    System.out.println("1. Document Request");
                    System.out.println("2. Clearance Request");
                    System.out.println("3. Back to Main Menu");
                    int reqChoice = sc.hasNextInt() ? sc.nextInt() : -1;
                    sc.nextLine();
                    if (reqChoice == 1) {
                        DocumentRequest d = new DocumentRequest();
                        dispatcher.addRequest(d);
                        logs.add(new TransactionLog("Document request created"));
                    } else if (reqChoice == 2) {
                        ClearanceRequest c = new ClearanceRequest();
                        dispatcher.addRequest(c);
                        logs.add(new TransactionLog("Clearance request created"));
                    }
                    break;

                case 3:
                    System.out.println("=== Payment Simulation Menu ===");
                    System.out.println("1. Cash Payment");
                    System.out.println("2. GCash Payment");
                    System.out.println("3. Back to Main Menu");
                    int payChoice = sc.hasNextInt() ? sc.nextInt() : -1;
                    sc.nextLine();
                    if (payChoice == 1) {
                        System.out.print("Enter amount: ");
                        double cashAmount = sc.nextDouble();
                        sc.nextLine();
                        Payment cash = new CashPayment();
                        try {
                            cash.pay(cashAmount);
                            System.out.println(new TransactionResult(true, "Cash payment successful."));
                            logs.add(new TransactionLog("Cash payment of " + cashAmount));
                        } catch (Exception e) {
                            System.out.println(new TransactionResult(false, e.getMessage()));
                        }
                    } else if (payChoice == 2) {
                        System.out.print("Enter amount: ");
                        double gcashAmount = sc.nextDouble();
                        sc.nextLine();
                        Payment gcash = new GCashPayment();
                        try {
                            gcash.pay(gcashAmount);
                            System.out.println(new TransactionResult(true, "GCash payment successful."));
                            logs.add(new TransactionLog("GCash payment of " + gcashAmount));
                        } catch (Exception e) {
                            System.out.println(new TransactionResult(false, e.getMessage()));
                        }
                    }
                    break;

                case 4:
                    lifecycle.track(dispatcher.getRequests());
                    logs.add(new TransactionLog("Lifecycle tracking executed"));
                    break;

                case 5:
                    System.out.println("=== Residents ===");
                    residentService.getAllResidents().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("=== Requests ===");
                    dispatcher.getRequests().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("=== Transaction Logs ===");
                    logs.forEach(System.out::println);
                    break;

                case 8:
                    if (!dispatcher.getRequests().isEmpty()) {
                        dispatcher.getRequests().forEach(req -> {
                            req.setStatus("Approved");
                            System.out.println("Approved: " + req.getServiceName());
                        });
                        logs.add(new TransactionLog("Admin approved requests"));
                    } else {
                        System.out.println("No requests to approve.");
                    }
                    break;

                case 9:
                    if (!dispatcher.getRequests().isEmpty()) {
                        dispatcher.getRequests().forEach(req -> {
                            req.setStatus("Assigned");
                            System.out.println("Assigned: " + req.getServiceName());
                        });
                        logs.add(new TransactionLog("Clerk assigned requests"));
                    } else {
                        System.out.println("No requests to assign.");
                    }
                    break;

                case 10:
                    running = false;
                    System.out.println("Exiting system Program, thank you!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        sc.close();
    }
}