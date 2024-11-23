package dev.nyanchuk.toy_factory.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadToyTest {

    private BadToy badToy;

    @BeforeEach
    void setUp() {
        badToy = new BadToy("Bad Toy", "Broken");
    }

    @Test
    void testGetContent() {
        assertEquals("Broken", badToy.getContent());
    }

    @Test
    void testSetContent() {
        badToy.setContent("Damaged");
        assertEquals("Damaged", badToy.getContent());
    }
}
