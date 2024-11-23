package dev.nyanchuk.toy_factory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToyTest {

    private Toy toy;

    @BeforeEach
    void setUp() {
        toy = new Toy("Toy Title", true);  // Initialize the Toy object before each test
    }

    @Test
    void testGetId() {
        // Test default value of id, which should be null when using the constructor without id
        assertNull(toy.getId());
    }

    @Test
    void testGetTitle() {
        // Test if the title is set correctly during initialization
        assertEquals("Toy Title", toy.getTitle());
    }

    @Test
    void testSetId() {
        // Set a new ID
        toy.setId("G1");
        // Verify if the ID was updated correctly
        assertEquals("G1", toy.getId());
    }

    @Test
    void testSetTitle() {
        // Set a new title
        toy.setTitle("New Toy Title");
        // Verify if the title was updated correctly
        assertEquals("New Toy Title", toy.getTitle());
    }
}
