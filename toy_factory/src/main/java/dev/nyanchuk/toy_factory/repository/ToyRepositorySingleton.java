package dev.nyanchuk.toy_factory.repository;

public class ToyRepositorySingleton {

    // Singleton instance of ToyRepository
    private static final ToyRepository INSTANCE = new ToyRepository();  

    // Private constructor to prevent instantiation
    private ToyRepositorySingleton() {
    }

    // Public method to get the singleton instance of ToyRepository
    public static ToyRepository getInstance() {
        return INSTANCE;
    }
}
