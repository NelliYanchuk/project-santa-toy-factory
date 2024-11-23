package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.model.BadToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BadToyRepositoryTest {

    private BadToyRepository badToyRepository;

    @BeforeEach
    void setUp() {
        badToyRepository = new BadToyRepository();
    }

    @Test
    void testGetBadToys() {
        BadToy badToy1 = new BadToy("Toy1", "Defective");
        BadToy badToy2 = new BadToy("Toy2", "Missing parts");

        badToyRepository.saveBadToy(badToy1);
        badToyRepository.saveBadToy(badToy2);

        List<BadToy> badToys = badToyRepository.getBadToys();

        assertNotNull(badToys);
        assertEquals(3, badToys.size());
        assertTrue(badToys.contains(badToy1));
        assertTrue(badToys.contains(badToy2));
    }

    @Test
    void testSaveBadToy() {
        BadToy badToy = new BadToy("Toy1", "Defective");

        badToyRepository.saveBadToy(badToy);
        List<BadToy> badToys = badToyRepository.getBadToys();

        assertNotNull(badToys);
        assertEquals(1, badToys.size());
        assertTrue(badToys.contains(badToy));
    }
}
