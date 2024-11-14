package dev.nyanchuk.toy_factory.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorViewTest {

    @Test
    public void testPrintErrorMessage() {
        // Set up a stream to capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the method we want to test
        ErrorView.printErrorMessage();

        // Verify that the output contains the expected message
        String expectedMessage1 = "Incorrect input";
        String expectedMessage2 = "Please choose the option from the list below:";
        assertTrue(outContent.toString().contains(expectedMessage1));
        assertTrue(outContent.toString().contains(expectedMessage2));

        // Restore original System.out
        System.setOut(originalOut);
    }
}
