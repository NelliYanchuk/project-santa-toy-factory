package dev.nyanchuk.toy_factory.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
