package com.barangay.ui;

import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner sc = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
            System.out.print(prompt);
        }
        return sc.nextInt();
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next();
            System.out.print(prompt);
        }
        return sc.nextDouble();
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();
        while (input.trim().isEmpty()) {
            System.out.println("Input cannot be empty. Try again.");
            System.out.print(prompt);
            input = sc.nextLine();
        }
        return input;
    }
}