package dev.nyanchuk.toy_factory.repository;

import dev.nyanchuk.toy_factory.model.GoodToy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GoodToyRepositoryTest {

    private GoodToyRepository goodToyRepository;

    @BeforeEach
    void setUp() {
        goodToyRepository = new GoodToyRepository();
    }

    @Test
    void testGetGoodToys() {
        GoodToy goodToy1 = new GoodToy("Toy1", "Brand1", 5, "Category1");
        GoodToy goodToy2 = new GoodToy("Toy2", "Brand2", 7, "Category2");

        goodToyRepository.saveGoodToy(goodToy1);
        goodToyRepository.saveGoodToy(goodToy2);

        List<GoodToy> goodToys = goodToyRepository.getGoodToys();

        assertNotNull(goodToys);
        assertEquals(2, goodToys.size());
        assertTrue(goodToys.contains(goodToy1));
        assertTrue(goodToys.contains(goodToy2));
    }

    @Test
    void testSaveGoodToy() {
        GoodToy goodToy = new GoodToy("Toy1", "Brand1", 5, "Category1");

        goodToyRepository.saveGoodToy(goodToy);
        List<GoodToy> goodToys = goodToyRepository.getGoodToys();

        assertNotNull(goodToys);
        assertEquals(3, goodToys.size());
        assertTrue(goodToys.contains(goodToy));
    }
}
