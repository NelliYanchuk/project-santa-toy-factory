package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.controller.ToyController;

public class SantaView extends ToyView {

    private static final ToyController controller = new ToyController(); // Ensure ToyController is instantiated

    public static void index() {

        managerSanta(); // You can customize this method to display the Santa menu
        System.out.println("1. View list of toys for GOOD children");
        System.out.println("2. View list of toys for BAD children");
        System.out.println("3. Save list of all toys (.csv)");
        System.out.println("4. Log out");
        System.out.println("5. Exit the program");
        selectOption();

        int option = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        switch (option) {
            case 1:
                controller.showGoodToys();
                index();
                break;
            case 2:
                controller.showBadToys();
                index();
                break;
            case 3:
                controller.saveToysToCsv("toys.csv");
                index();
                break;
            case 4:
                System.out.println("Logging out...");
                closeSession();
                break;
            case 5:
                closeScanner();
                quitMessage();
                return;
            default:
                printErrorMessage();
        }
    }
}
