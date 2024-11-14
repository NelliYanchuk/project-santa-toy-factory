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
}
