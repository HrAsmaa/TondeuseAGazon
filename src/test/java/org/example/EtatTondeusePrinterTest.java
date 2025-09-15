package org.example;

import org.example.Enumerations.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EtatTondeusePrinterTest {
    private EtatTondeusePrinter printer;
    private Tondeuse tondeuse;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        printer = new EtatTondeusePrinter();
        System.setOut(new PrintStream(outContent));
        tondeuse = new Tondeuse(new Position(1, 2), Orientation.NORD);
    }

    @Test
    void afficherEtatConsole_ShouldPrintTondeuseEtat() {
        printer.afficherEtatConsole(tondeuse);
        String output = outContent.toString().trim();
        assertTrue(output.contains("1 2 N"));

    }

    @Test
    void afficherEtatConsole_NullTondeuse_ShouldThrowException() {
        tondeuse = null;
        assertThrows(NullPointerException.class, () -> printer.afficherEtatConsole(tondeuse));
    }
}
