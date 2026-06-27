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
                    MenuNavigator.showResidentMenu();
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
                        System.out.print("Enter address (optional, press Enter to skip): ");
                        String address = sc.nextLine();
                        Resident r = address.isEmpty() ? new Resident(name, age) : new Resident(name, age, address);
                        residentService.registerResident(r);
                        logs.add(new TransactionLog("Registered resident: " + r));
                    }
                    break;

                case 2:
                    MenuNavigator.showRequestMenu();
                    int reqChoice = sc.hasNextInt() ? sc.nextInt() : -1;
                    sc.nextLine();

                    if (reqChoice == 1) { // Document Request
                        if (!residentService.getAllResidents().isEmpty()) {
                            System.out.println("Select resident by name: ");
                            String resName = sc.nextLine();
                            Resident found = residentService.searchByName(resName);
                            if (found != null) {
                                DocumentRequest d = new DocumentRequest(found);
                                dispatcher.addRequest(d);
                                logs.add(new TransactionLog("Document request created by " + found.getName()));
                            } else {
                                System.out.println("Resident not found.");
                            }
                        } else {
                            System.out.println("No residents registered yet.");
                        }
                    }

                    else if (reqChoice == 2) {
                        if (!residentService.getAllResidents().isEmpty()) {
                            System.out.println("Select resident by name: ");
                            String resName = sc.nextLine();
                            Resident found = residentService.searchByName(resName);
                            if (found != null) {
                                ClearanceRequest c = new ClearanceRequest(found);
                                dispatcher.addRequest(c);
                                logs.add(new TransactionLog("Clearance request created by " + found.getName()));
                            } else {
                                System.out.println("Resident not found.");
                            }
                        } else {
                            System.out.println("No residents registered yet.");
                        }
                    }
                    break;

                case 3:
                    MenuNavigator.showPaymentMenu();
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
                    System.out.println("=== Resident List ===");
                    residentService.getAllResidents().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("=== Requests List ===");
                    dispatcher.getRequests().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("=== Transaction Logs ===");
                    logs.forEach(System.out::println);
                    break;

                case 8:
                    if (!dispatcher.getRequests().isEmpty()) {
                        System.out.println("Do you want to approve all requests? (Y/N): ");
                        String confirm = sc.nextLine().trim().toUpperCase();
                        if (confirm.equals("Y")) {
                            dispatcher.getRequests().forEach(req -> {
                                req.setStatus("Approved");
                                System.out.println("Approved: " + req.getServiceName());
                            });
                            logs.add(new TransactionLog("Admin approved requests"));
                        } else {
                            System.out.println("Approval cancelled.");
                        }
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
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}