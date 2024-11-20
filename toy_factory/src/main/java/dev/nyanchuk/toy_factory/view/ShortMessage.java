package dev.nyanchuk.toy_factory.view;

public class ShortMessage extends ScannerView {

    // Method to ask for user option
    public static void selectOption() {
        System.out.println("\nPlease select an option: ");
    }

    // Method to print an error message when an invalid input is given
    public static void printErrorMessage() {
        System.out.println("\n----- Incorrect input -----\nPlease choose the option from the list below:");
    }

    // Method to return to home menu
    public static void closeSession() {
        HomeView.index();
    }

    // Method to print quit message
    public static void quitMessage() {
        System.out.println("\n----- Good bye! Have a nice day! -----");
    }

    // Methods to print the roles
    public static void managerElf() {
        System.out.println("\n----- Toy Manager (Session Type: Elf) -----");
    }

    public static void managerSanta() {
        System.out.println("\n----- Toy Manager (Session Type: Santa) -----");
    }

    // Methods to print toys info
    public static void toyMessage(String type) {
        System.out.println("\nThe " + type + " toys in stock: ");
    }
}
