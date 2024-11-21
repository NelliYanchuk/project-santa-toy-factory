package dev.nyanchuk.toy_factory.view;


public class SantaView extends ShortMessageView {
    
    //private static final ToyController controller = new ToyController();

    public static void index() {

        managerSanta();
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
                // add showGoodToy method
                break;
            case 2:
                // add showBadToy method
                break;
            case 3:
                System.out.println("This option is in progress now");
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
}