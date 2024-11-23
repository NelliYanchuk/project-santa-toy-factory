package dev.nyanchuk.toy_factory.db;

import dev.nyanchuk.toy_factory.model.Toy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ToyDatabaseTest {

    private ToyDatabase toyDatabase;

    @BeforeEach
    void setUp() {
        toyDatabase = new ToyDatabase(); // Initialize ToyDatabase before each test
    }

    @Test
    void testSave() {
        Toy toy = new Toy("Toy1", true); // Create a new toy
        toyDatabase.save(toy); // Save the toy

        // Verify if the toy is saved by checking the toyStorage
        List<Toy> toys = toyDatabase.getToys();
        assertEquals(1, toys.size(), "Toy should be added to the list");
        assertEquals("Toy1", toys.get(0).getTitle(), "The toy title should match the saved one");
    }

    @Test
    void testGetToys() {
        Toy toy1 = new Toy("Toy1", true);
        Toy toy2 = new Toy("Toy2", true);

        toyDatabase.save(toy1);
        toyDatabase.save(toy2);

        // Get all toys
        List<Toy> toys = toyDatabase.getToys();

        // Verify that both toys are present in the list
        assertEquals(2, toys.size(), "There should be 2 toys in the list");
        assertTrue(toys.contains(toy1), "Toy1 should be in the list");
        assertTrue(toys.contains(toy2), "Toy2 should be in the list");
    }
}
