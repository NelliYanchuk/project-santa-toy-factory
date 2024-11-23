package dev.nyanchuk.toy_factory.singleton;

import dev.nyanchuk.toy_factory.db.ToyDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToyDatabaseSingletonTest {

    @Test
    void testGetInstance() {
        // Get the first instance of the ToyDatabase singleton
        ToyDatabase firstInstance = ToyDatabaseSingleton.getInstance();

        // Get another instance of the ToyDatabase singleton
        ToyDatabase secondInstance = ToyDatabaseSingleton.getInstance();

        // Verify that both instances are the same (singleton behavior)
        assertSame(firstInstance, secondInstance, "The instances should be the same (singleton).");
    }
}
