package dev.nyanchuk.toy_factory.singleton;

import dev.nyanchuk.toy_factory.db.GoodToyDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoodToyDatabaseSingletonTest {

    @Test
    void testGetInstance() {
        // Get the first instance of the GoodToyDatabase singleton
        GoodToyDatabase firstInstance = GoodToyDatabaseSingleton.getInstance();

        // Get another instance of the GoodToyDatabase singleton
        GoodToyDatabase secondInstance = GoodToyDatabaseSingleton.getInstance();

        // Verify that both instances are the same (singleton behavior)
        assertSame(firstInstance, secondInstance, "The instances should be the same (singleton).");
    }
}
