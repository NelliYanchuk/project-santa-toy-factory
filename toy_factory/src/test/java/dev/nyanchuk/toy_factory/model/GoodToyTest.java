package dev.nyanchuk.toy_factory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodToyTest {

    private GoodToy goodToy;

    @BeforeEach
    void setUp() {
        // Initialize the GoodToy object before each test
        goodToy = new GoodToy("Toy Title", "Toy Brand", 12, "Building");
    }

    @Test
    void testGetBrand() {
        // Verify that the brand is correctly retrieved
        assertEquals("Toy Brand", goodToy.getBrand());
    }

    @Test
    void testGetCategory() {
        // Verify that the category is correctly retrieved
        assertEquals("Building", goodToy.getCategory());
    }

    @Test
    void testGetTargetAge() {
        // Verify that the target age is correctly retrieved
        assertEquals(12, goodToy.getTargetAge());
    }

    @Test
    void testSetBrand() {
        // Set a new brand and verify it's updated
        goodToy.setBrand("New Toy Brand");
        assertEquals("New Toy Brand", goodToy.getBrand());
    }

    @Test
    void testSetCategory() {
        // Set a new category and verify it's updated
        goodToy.setCategory("Outdoor");
        assertEquals("Outdoor", goodToy.getCategory());
    }

    @Test
    void testSetTargetAge() {
        // Set a new target age and verify it's updated
        goodToy.setTargetAge(18);
        assertEquals(18, goodToy.getTargetAge());
    }
}
