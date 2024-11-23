package dev.nyanchuk.toy_factory.singleton;

import dev.nyanchuk.toy_factory.db.BadToyDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BadToyDatabaseSingletonTest {

    @Test
    void testGetInstance() {
        // Get the first instance of the BadToyDatabase singleton
        BadToyDatabase firstInstance = BadToyDatabaseSingleton.getInstance();

        // Get another instance of the BadToyDatabase singleton
        BadToyDatabase secondInstance = BadToyDatabaseSingleton.getInstance();

        // Verify that both instances are the same (singleton behavior)
        assertSame(firstInstance, secondInstance, "The instances should be the same (singleton).");
    }
}
