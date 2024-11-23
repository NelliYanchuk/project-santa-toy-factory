package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.model.Toy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ToyRepositoryTest {

    private ToyRepository toyRepository;

    @BeforeEach
    void setUp() {
        toyRepository = new ToyRepository();
    }

    @Test
    void testGetToys() {
        Toy toy1 = new Toy("Toy1", true);
        Toy toy2 = new Toy("Toy2", false);
        toyRepository.saveToy(toy1);
        toyRepository.saveToy(toy2);

        List<Toy> toys = toyRepository.getToys();

        assertNotNull(toys);
        assertEquals(2, toys.size());
        assertTrue(toys.contains(toy1));
        assertTrue(toys.contains(toy2));
    }

    @Test
    void testSaveToy() {
        Toy toy = new Toy("Toy1", true);

        toyRepository.saveToy(toy);
        List<Toy> toys = toyRepository.getToys();

        assertNotNull(toys);
        assertEquals(3, toys.size());
        assertTrue(toys.contains(toy));
    }
}
