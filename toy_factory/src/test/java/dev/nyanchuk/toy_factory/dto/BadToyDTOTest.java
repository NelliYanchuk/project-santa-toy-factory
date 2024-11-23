package dev.nyanchuk.toy_factory.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadToyDTOTest {

    @Test
    void testContent() {
        // Create a BadToyDTO object
        BadToyDTO badToyDTO = new BadToyDTO("Bad Toy", "Broken");

        // Verify that the content is correctly initialized
        assertEquals("Broken", badToyDTO.content());
    }

    @Test
    void testEquals() {
        // Create two BadToyDTO objects with the same values
        BadToyDTO badToyDTO1 = new BadToyDTO("Bad Toy", "Broken");
        BadToyDTO badToyDTO2 = new BadToyDTO("Bad Toy", "Broken");

        // Verify that two objects with the same values are considered equal
        assertEquals(badToyDTO1, badToyDTO2);
    }

    @Test
    void testHashCode() {
        // Create two BadToyDTO objects with the same values
        BadToyDTO badToyDTO1 = new BadToyDTO("Bad Toy", "Broken");
        BadToyDTO badToyDTO2 = new BadToyDTO("Bad Toy", "Broken");

        // Verify that two objects with the same values have the same hash code
        assertEquals(badToyDTO1.hashCode(), badToyDTO2.hashCode());
    }

    @Test
    void testTitle() {
        // Create a BadToyDTO object
        BadToyDTO badToyDTO = new BadToyDTO("Bad Toy", "Broken");

        // Verify that the title is correctly initialized
        assertEquals("Bad Toy", badToyDTO.title());
    }

    @Test
    void testToString() {
        // Create a BadToyDTO object
        BadToyDTO badToyDTO = new BadToyDTO("Bad Toy", "Broken");

        // Verify the toString() method works correctly
        assertEquals("BadToyDTO[title=Bad Toy, content=Broken]", badToyDTO.toString());
    }
}
