package dev.nyanchuk.toy_factory.view;

import dev.nyanchuk.toy_factory.model.GoodToy;
import dev.nyanchuk.toy_factory.model.Toy;
import dev.nyanchuk.toy_factory.model.BadToy;
import dev.nyanchuk.toy_factory.view.ToyView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToyViewTest {
    private ToyView toyView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        toyView = new ToyView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Redirecting System.out to capture the output
    }

    @Test
    public void testDisplayBadToys() {
        List<BadToy> badToys = Arrays.asList(
                new BadToy("BadToy 1", "Broken"),
                new BadToy("BadToy 2", "Missing parts")
        );

        toyView.displayBadToys(badToys);

        String output = outputStream.toString();
        assertTrue(output.contains("BadToy 1"));
        assertTrue(output.contains("BadToy 2"));
    }

     @Test
    void testDisplayGoodToys() {
        List<GoodToy> goodToys = Arrays.asList(
            new GoodToy("GoodToy 1", "Brand 1", 5, "Action"),
            new GoodToy("GoodToy 2", "Brand 2", 3, "Puzzle")
    );

    toyView.displayGoodToys(goodToys);

    String output = outputStream.toString();
    assertTrue(output.contains("GoodToy 1"));
    assertTrue(output.contains("GoodToy 2"));

    }
@Test
    public void testDisplayToys_withAllToys() {
        List<Toy> toys = Arrays.asList(
                new GoodToy("GoodToy", "Brand 1", 5, "Action"),
                new BadToy("BadToy", "Broken")
        );

        toyView.displayToys(toys);

        String output = outputStream.toString();
        assertTrue(output.contains("GoodToy"));
        assertTrue(output.contains("BadToy"));
    }

    @Test
    public void testDisplayToys_whenNoToys() {
        List<Toy> toys = Arrays.asList();  // Empty list

        toyView.displayToys(toys);

        String output = outputStream.toString();
        assertTrue(output.contains("Stock does not have any toy left."), "Output should indicate no toys are available.");
    }
}
