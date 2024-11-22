package dev.nyanchuk.toy_factory.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodToyDTOTest {

    @Test
    void testTitle() {
        // Create a GoodToyDTO object
        GoodToyDTO goodToyDTO = new GoodToyDTO("Toy 1", "LEGO", 10, "Building");

        // Verify title
        assertEquals("Toy 1", goodToyDTO.title());

        // Verify brand
        assertEquals("LEGO", goodToyDTO.brand());

        // Verify recommended age
        assertEquals(10, goodToyDTO.recommendedAge());

        // Verify category
        assertEquals("Building", goodToyDTO.category());
    }

    @Test
    void testEquals() {
        // Create two GoodToyDTO objects with the same values
        GoodToyDTO goodToyDTO1 = new GoodToyDTO("Toy 1", "LEGO", 10, "Building");
        GoodToyDTO goodToyDTO2 = new GoodToyDTO("Toy 1", "LEGO", 10, "Building");

        // Verify two objects are equal
        assertEquals(goodToyDTO1, goodToyDTO2);

        // Verify two objects have the same hash code
        assertEquals(goodToyDTO1.hashCode(), goodToyDTO2.hashCode());
    }

    @Test
    void testToString() {
        // Create a GoodToyDTO object
        GoodToyDTO goodToyDTO = new GoodToyDTO("Toy 1", "LEGO", 10, "Building");

        // Verify the toString() method works correctly
        assertEquals("GoodToyDTO[title=Toy 1, brand=LEGO, recommendedAge=10, category=Building]",
                goodToyDTO.toString());
    }
}
