package dev.nyanchuk.toy_factory.view;

import java.util.Scanner;

public class ScannerView {

    // Static Scanner instance
    protected static Scanner scanner;

    // Method to open the Scanner
    public static void openScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    // Method to close the Scanner
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    // Method to ask for user option
    public static void selectOption() {
        System.out.println("\nPlease select an option: ");
    }

    // Method to print an error message when an invalid input is given
    public static void printErrorMessage() {
        System.out.println("\n----- Incorrect input -----\nPlease choose the option from the list below:");
    }
}
