package dev.nyanchuk.toy_factory.view;

public class HomeView extends ScannerView {

    public static void index() {
        openScanner();

        while (true) {
            // Main Menu
            System.out.println("\n-----Welcome to the Toy Factory! -----");
            System.out.println("Log in as:");
            System.out.println("1. Elf");
            System.out.println("2. Santa Claus");
            System.out.println("3. Exit the program");

            selectOption();

            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        ElfView.index();
                        return;
                    case 2:
                        // SantaView.index();
                        return;
                    case 3:
                        quit();
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
    }

    public static void quit() {
        closeScanner();
        System.out.println("\n----- Good bye! Have a nice day! -----");
    }

}
