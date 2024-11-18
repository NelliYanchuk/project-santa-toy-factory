package dev.nyanchuk.toy_factory.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ScannerViewTest {

    @BeforeEach
    public void setUp() {
        // Ensure that scanner is null before each test
        ScannerView.closeScanner();
    }

    @Test
    public void testOpenCloseScanner() {
        // Open the scanner
        ScannerView.openScanner();
        assertNotNull(ScannerView.scanner);

        // Close the scanner
        ScannerView.closeScanner();
        assertNull(ScannerView.scanner);
    }

    @Test
    public void testPrintErrorMessage() {
        // Set up a stream to capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call method to test
        ScannerView.printErrorMessage();

        // Verify the output contains the expected message
        String expectedMessage1 = "Incorrect input";
        String expectedMessage2 = "Please choose the option from the list below:";
        assertTrue(outContent.toString().contains(expectedMessage1));
        assertTrue(outContent.toString().contains(expectedMessage2));

        // Restore original System.out
        System.setOut(originalOut);
    }

    @Test
    public void testSelectOption() {
        // Set up a stream to capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call method to test
        ScannerView.selectOption();

        // Verify that the output contains the expected message
        String expectedMessage = "Please select an option: ";
        assertTrue(outContent.toString().contains(expectedMessage));

        // Restore original System.out
        System.setOut(originalOut);
    }
}
