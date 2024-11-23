package dev.nyanchuk.toy_factory.db;

import dev.nyanchuk.toy_factory.model.BadToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BadToyDatabaseTest {

    private BadToyDatabase badToyDatabase;

    @BeforeEach
    void setUp() {
        badToyDatabase = new BadToyDatabase(); // Initialize BadToyDatabase before each test
    }

    @Test
    void testSave() {
        BadToy toy = new BadToy("Toy1", "Broken");
        badToyDatabase.save(toy); // Save the bad toy

        // Verify if the bad toy is saved
        List<BadToy> toys = badToyDatabase.getToys();
        assertEquals(1, toys.size());
        assertEquals("Toy1", toys.get(0).getTitle());
    }

    @Test
    void testGetToys() {
        BadToy toy1 = new BadToy("Toy1", "Broken");
        BadToy toy2 = new BadToy("Toy2", "Missing parts");

        badToyDatabase.save(toy1);
        badToyDatabase.save(toy2);

        // Get all bad toys
        List<BadToy> toys = badToyDatabase.getToys();

        // Verify both toys are present in the list
        assertEquals(2, toys.size());
        assertTrue(toys.contains(toy1));
        assertTrue(toys.contains(toy2));
    }
}
