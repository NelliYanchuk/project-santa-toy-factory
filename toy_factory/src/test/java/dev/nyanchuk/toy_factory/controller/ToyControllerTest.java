package dev.nyanchuk.toy_factory.controller;

import dev.nyanchuk.toy_factory.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ToyControllerTest {

    private ToyController toyController;

    @BeforeEach
    void setUp() {
        toyController = new ToyController();
    }

    @Test
    void testAddDefaultGoodToy() {
        // Create a good toy and add it to the repository
        toyController.addDefaultGoodToy("Toy 1", "Brand A", 5, "Category A");

        List<Toy> toys = toyController.getAllToys();
        assertEquals(4, toys.size());
        assertFalse(toys.get(0) instanceof GoodToy);
        assertEquals("Toy1", toys.get(0).getTitle());
    }

    @Test
    void testAddDefaultBadToy() {
        // Add a bad toy to the repository
        toyController.addDefaultBadToy("Toy 2", "Missing part");

        List<Toy> toys = toyController.getAllToys();
        assertEquals(9, toys.size());
        assertFalse(toys.get(0) instanceof BadToy);
        assertEquals("Toy1", toys.get(0).getTitle());
    }

    @Test
    void testGenerateToyId() {
        // Add some toys to the repository and test ID generation
        toyController.addDefaultGoodToy("Toy 3", "Brand B", 10, "Category B");
        toyController.addDefaultBadToy("Toy 4", "Damaged");

        String goodToyId = toyController.generateToyId("good");
        String badToyId = toyController.generateToyId("bad");

        assertEquals("G5", goodToyId); 
        assertEquals("B2", badToyId); 
    }

    @Test
    void testShowToys() {
        toyController.addDefaultGoodToy("Toy 7", "Brand D", 6, "Category D");
        toyController.addDefaultBadToy("Toy 8", "Noisy");

        // Test the method to show all toys
        toyController.showToys();
    }

    @Test
    void testSaveToysToCsv() {
        toyController.addDefaultGoodToy("Toy 9", "Brand E", 3, "Category E");
        toyController.addDefaultBadToy("Toy 10", "Cracked");

        // This test will save the toys into a CSV file.
        toyController.saveToysToCsv("toys.csv");
    }

    @Test
    void testShowGoodToys() {
        // Add some good toys
        toyController.addDefaultGoodToy("Toy 1", "Brand A", 5, "Category A");
        toyController.addDefaultGoodToy("Toy 2", "Brand B", 8, "Category B");

        // Capture the output from showGoodToys
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Show only good toys
        toyController.showGoodToys();

        // Verify the output contains the correct toy information
        String output = outputStream.toString();
        assertTrue(output.contains("Brand A"));
        assertTrue(output.contains("Brand B"));
    }

    @Test
    void testShowBadToys() {
        // Add some bad toys
        toyController.addDefaultBadToy("Bad Toy 1", "Content A");
        toyController.addDefaultBadToy("Bad Toy 2", "Content B");

        // Capture the output from showBadToys
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Show only bad toys
        toyController.showBadToys();

        // Verify the output contains the correct toy information
        String output = outputStream.toString();
        assertTrue(output.contains("Content A"));
        assertTrue(output.contains("Content B"));
    }

}