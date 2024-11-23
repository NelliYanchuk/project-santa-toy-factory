package dev.nyanchuk.toy_factory.db;

import dev.nyanchuk.toy_factory.model.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GoodToyDatabaseTest {

    private GoodToyDatabase goodToyDatabase;

    @BeforeEach
    void setUp() {
        goodToyDatabase = new GoodToyDatabase(); // Initialize GoodToyDatabase before each test
    }

    @Test
    void testSave() {
        GoodToy toy = new GoodToy("Toy1", "Brand1", 5, "Category1");
        goodToyDatabase.save(toy); // Save the good toy

        // Verify if the good toy is saved
        List<GoodToy> toys = goodToyDatabase.getToys();
        assertEquals(1, toys.size());
        assertEquals("Toy1", toys.get(0).getTitle());
    }

    @Test
    void testGetToys() {
        GoodToy toy1 = new GoodToy("Toy1", "Brand1", 5, "Category1");
        GoodToy toy2 = new GoodToy("Toy2", "Brand2", 8, "Category2");

        goodToyDatabase.save(toy1);
        goodToyDatabase.save(toy2);

        // Get all good toys
        List<GoodToy> toys = goodToyDatabase.getToys();

        // Verify both toys are present in the list
        assertEquals(2, toys.size());
        assertTrue(toys.contains(toy1));
        assertTrue(toys.contains(toy2));
    }
}
