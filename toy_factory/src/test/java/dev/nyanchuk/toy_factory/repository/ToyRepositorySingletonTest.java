package dev.nyanchuk.toy_factory.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ToyRepositorySingletonTest {

    @Test
    void testGetInstance() {
        // Get the first instance of the ToyRepository singleton
        ToyRepository firstInstance = ToyRepositorySingleton.getInstance();

        // Get another instance of the ToyRepository singleton
        ToyRepository secondInstance = ToyRepositorySingleton.getInstance();

        // Verify that both instances are the same (singleton behavior)
        assertSame(firstInstance, secondInstance, "The instances should be the same (singleton).");
    }
}
