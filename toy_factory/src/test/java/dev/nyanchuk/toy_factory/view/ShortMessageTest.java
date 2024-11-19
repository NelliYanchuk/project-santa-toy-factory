package dev.nyanchuk.toy_factory.view;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class ShortMessageTest {

    @Test
    public void testShortMessage() {
        // Set up a stream to capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // ----- selectOption -----
        String expectedOption = "Please select an option: ";

        ShortMessage.selectOption();

        assertTrue(outContent.toString().contains(expectedOption));

        // ----- printErrorMessage -----
        String expectedIncorrectInput1 = "Incorrect input";
        String expectedIncorrectInput2 = "Please choose the option from the list below:";

        ShortMessage.printErrorMessage();

        assertTrue(outContent.toString().contains(expectedIncorrectInput1));
        assertTrue(outContent.toString().contains(expectedIncorrectInput2));

        // ----- quitMessage -----
        String expectedQuitMessage = "Good bye! Have a nice day!";

        ShortMessage.quitMessage();

        assertTrue(outContent.toString().contains(expectedQuitMessage));

        // ----- closeSession -----
        // String expectedHomeMenu = "Log in as:";
        // ShortMessage.closeSession();
        // assertTrue(outContent.toString().contains(expectedHomeMenu));

        // Restore original System.out
        System.setOut(originalOut);
    }
}
