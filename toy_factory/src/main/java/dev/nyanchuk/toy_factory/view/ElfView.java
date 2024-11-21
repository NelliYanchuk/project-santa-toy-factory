package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.controller.ToyController;
import dev.nyanchuk.toy_factory.model.GoodToy;
import dev.nyanchuk.toy_factory.model.BadToy;

import java.util.Scanner;

public class ElfView extends ToyView {  // Now extends ToyView

    private static final ToyController controller = new ToyController();

    public static void index() {

        managerElf();
        System.out.println("1. Add Toy");
        System.out.println("2. View all Toys");
        System.out.println("3. Delete toy");
        System.out.println("4. Log out");
        System.out.println("5. Exit the program");
        selectOption();

        int option = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        switch (option) {
            case 1:
                addToy(scanner); // calls addToy to choose Good or Bad Toy
                break;
            case 2:
                controller.showToys(); // Show all toys (good and bad) using inherited method from ToyView
                index();
                break;
            case 3:
                deleteToy(scanner); // Delete toy by ID
                break;
            case 4:
                System.out.println("Logging out...");
                closeSession();
                break;
            case 5:
                closeScanner();
                quitMessage();
                return; // Add this return to exit the method after printing the quit message
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void addToy(Scanner scanner) {
        // Ask for the toy type
        System.out.println("\nFor child ...:");
        System.out.println("1. Good");
        System.out.println("2. Bad");
        selectOption();

        int type = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        if (type == 1) {
            // Good Toy
            System.out.println("Enter Title: ");
            String title = scanner.nextLine();  // Use nextLine() for String input
            System.out.println("Enter Brand: ");
            String brand = scanner.nextLine(); // Read brand as a string
            System.out.println("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input
            System.out.println("Enter Category: ");
            String category = scanner.nextLine(); // Read category as a string

            // Create the good toy
            GoodToy goodToy = new GoodToy(title, brand, age, category);
            controller.postToy(goodToy); // Post the good toy
        } else if (type == 2) {
            // Bad Toy
            System.out.println("Enter Title: ");
            String title = scanner.nextLine();  // Use nextLine() for String input
            System.out.println("Enter Content: ");
            String content = scanner.nextLine(); // Read content as a string

            // Create the bad toy
            BadToy badToy = new BadToy(title, content);
            controller.postToy(badToy); // Post the bad toy
        }

        index();  // After adding, go back to the menu
    }

    // Method to handle toy deletion
    private static void deleteToy(Scanner scanner) {
        // Ask the user for the ID of the toy to delete
        System.out.println("Enter the ID of the toy you want to delete:");
        String toyId = scanner.nextLine();  // Read the toy ID

        // Call the ToyController to delete the toy
        controller.deleteToyById(toyId);

        index();  // After deleting, go back to the menu
    }
}
