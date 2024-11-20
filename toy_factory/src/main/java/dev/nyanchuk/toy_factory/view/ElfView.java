package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.controller.ToyController;
import dev.nyanchuk.toy_factory.model.GoodToy;
import dev.nyanchuk.toy_factory.model.BadToy;

import java.util.Scanner;

public class ElfView extends ShortMessage {

    private static final ToyController controller = new ToyController();

    public static void index() {

        System.out.println("Toy Manager (Session Type: Elf)");
        System.out.println("1. Add Toy");
        System.out.println("2. View all Toys");
        System.out.println("3. Delete toy");
        System.out.println("4. Log out");
        System.out.println("5. Exit the program");
        selectOption();

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addToy(scanner); // Now calls addToy to choose between Good or Bad Toy first
                break;
            case 2:
                controller.showToys(); // Show all toys
                break;
            case 3:
                System.out.println("Toy deleting is not implemented yet");
                break;
            case 4:
                System.out.println("Logging out...");
                closeSession();
                break;
            case 5:
                quitMessage();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void addToy(Scanner scanner) {
        // Ask for the toy type
        System.out.println("For child ...:");
        System.out.println("1. Good Toy");
        System.out.println("2. Bad Toy");
        selectOption();

        int type = scanner.nextInt();

        if (type == 1) {
            // Good Toy
            System.out.println("Enter Title: ");
            String title = scanner.next();
            System.out.println("Enter Brand: ");
            String brand = scanner.next();
            System.out.println("Enter Age: ");
            int age = scanner.nextInt();
            System.out.println("Enter Category: ");
            String category = scanner.next();

            // Create the good toy
            GoodToy goodToy = new GoodToy(title, brand, age, category);
            controller.postToy(goodToy); // Post the good toy
        } else if (type == 2) {
            // Bad Toy
            System.out.println("Enter Title: ");
            String title = scanner.next();
            System.out.println("Enter Content: ");
            String content = scanner.next();

            // Create the bad toy
            BadToy badToy = new BadToy(title, content);
            controller.postToy(badToy); // Post the bad toy
        }

        index();
    }
}
