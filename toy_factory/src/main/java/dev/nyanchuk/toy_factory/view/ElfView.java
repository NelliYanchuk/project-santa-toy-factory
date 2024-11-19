package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.controller.*;
import dev.nyanchuk.toy_factory.dto.*;

public class ElfView extends ShortMessage {

    private static final ToyController controller = new ToyController();

    public static void index() {
        System.out.println("-----------------------------------------");
        System.out.println("Toy Manager (Session Type: Elf)");
        System.out.println("1. Add toy");
        System.out.println("2. View all toys");
        System.out.println("3. Delete toy");
        System.out.println("4. Log out");
        System.out.println("5. Exit the program");

        selectOption();

        // Check if the input is an integer
        if (scanner.hasNextInt()) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    selectChild();
                    return;
                case 2:
                    System.out.println("All toys are here");
                    return;
                case 3:
                    System.out.println("Delete a toy");
                    return;
                case 4:
                    closeSession();
                    return;
                case 5:
                    closeScanner();
                    quitMessage();
                    return;
                default:
                    // If the number is not in the menu options
                    printErrorMessage();
                    break;
            }
        } else {
            // If the input is not a number
            printErrorMessage();
            scanner.next(); // get invalid input
        }
    }

    public static void selectChild() {
        System.out.println("-----------------------------------------");
        System.out.println("For what child:");
        System.out.println("1. Good");
        System.out.println("2. Bad");
        System.out.println("3. Log out");

        selectOption();

        // Check if the input is an integer
        if (scanner.hasNextInt()) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    postGoodToy();
                    return;
                case 2:
                    postBadToy();
                    return;
                case 3:
                    closeSession();
                    return;
                default:
                    // If the number is not in the menu options
                    printErrorMessage();
                    break;
            }
        } else {
            // If the input is not a number
            printErrorMessage();
            scanner.next(); // get invalid input
        }
    }

    public static void postGoodToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Enter the title:");
        String title = scanner.next(); // Read title
        System.out.println("Enter the brand:");
        scanner.nextLine(); // Get the leftover newline character
        String brand = scanner.next(); // Read brand
        System.out.println("Enter the recommended age:");
        int age = scanner.nextInt(); // Read age
        scanner.nextLine(); // Get the leftover newline character after nextInt()
        System.out.println("Enter the category:");
        String category = scanner.next(); // Read category

        // Dto - Data Transfer Object
        controller.postGoodToy(new GoodToyDTO(title, brand, age, category));
    }

    public static void postBadToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Enter the title:");
        String title = scanner.next();
        System.out.println("Enter the content:");
        String content = scanner.next();

        // Dto - Data Transfert Object
        controller.postBadToy(new BadToyDTO(title, content));
    }

    public static void addToyResponse() {
        System.out.println("Toy added successfully");
        index();
    }
}
