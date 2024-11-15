package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.controller.*;
import dev.nyanchuk.toy_factory.dto.*;

public class ElfView extends ScannerView {

    private static final ToyController controller = new ToyController();

    public static void index() {
        System.out.println("-----------------------------------------");
        System.out.println("Toy Manager (Session Type: Elf)");
        System.out.println("1. Add toy");
        System.out.println("2. View all toys");
        System.out.println("3. Delete toy");
        System.out.println("4. Log out");
        System.out.println("Select an option:");

        int option = scanner.nextInt();

        if (option == 1) selectChild();
        if (option == 4) closeSession();
    }

    public static void selectChild() {
        System.out.println("-----------------------------------------");
        System.out.println("For what child:");
        System.out.println("1. Good");
        System.out.println("2. Bad");
        int option = scanner.nextInt();

        if (option == 1) postGoodToy();
    }

    public static void postGoodToy() {
        System.out.println("-----------------------------------------");
        System.out.println("Enter the title:");
        String title = scanner.next();
        System.out.println("Enter the brand:");
        String brand = scanner.next();
        System.out.println("Enter the recommended age:");
        int age = scanner.nextInt();
        System.out.println("Enter the category:");
        String category = scanner.next();

        // Dto - Data Transfert Object
        controller.postGoodToy(new GoodToyDTO(title, brand, age, category));
    }

    public static void addToyResponse() {
        System.out.println("Toy added successfully");
        index();
    }

    public static void closeSession() {
        HomeView.index();
    }

}
