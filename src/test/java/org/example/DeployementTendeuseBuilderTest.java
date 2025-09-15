package org.example;

import org.example.Enumerations.Orientation;
import org.example.Exceptions.LigneInvalideException;
import org.junit.jupiter.api.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeployementTendeuseBuilderTest {

    private static Path tempFile;
    private static DeployementTendeuseBuilder builder;

    @BeforeAll
    static void setUp() throws IOException {
        tempFile = Files.createTempFile("builderTest", ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            // Pelouse valide
            writer.write("5 5\n");
            // Tondeuse valide
            writer.write("1 2 N\n");
            // comandes valide
            writer.write("AGD\n");
            // Pelouse invalid
            writer.write("5 N\n");
            // Tondeuse invalide
            writer.write("1 G N\n");
            // comandes invalide
            writer.write(
                    "AGD 1\n");
        }

        builder = new DeployementTendeuseBuilder(tempFile);
    }

    @Test
    @Order(1)
    void buildOrchestrateurTendeuse_dataCorrect_ShouldReturnOrchestrateurTendeuse() {
        OrchestrateurTondeuses orchestrateurTondeuses = builder.buildOrchestrateurTendeuse();
        assertNotNull(orchestrateurTondeuses);
        assertNotNull(orchestrateurTondeuses.getPelouse());
        assertEquals(5, orchestrateurTondeuses.getPelouse().getMaxX());
        assertEquals(5, orchestrateurTondeuses.getPelouse().getMaxY());
    }

    @Test
    @Order(2)
    void buildTondeuse_dataCorrect_ShouldReturnTondeuse() {
        Tondeuse tondeuse = builder.buildTondeuse();
        assertNotNull(tondeuse);
        assertNotNull(tondeuse.getPosition());
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.NORD, tondeuse.getOrientation());

    }


    @Test
    @Order(3)
    void buildCommandesTendeuse_dataCorrect_ShouldReturnCommandes() {
        String commandesTondeuse = builder.buildCommandesTendeuse();
        assertEquals("AGD", commandesTondeuse);
    }

    @Test
    @Order(4)
    void buildOrchestrateurTendeuse_dataIncorrect_ShouldThrowException() {
        assertThrows(LigneInvalideException.class, () -> builder.buildOrchestrateurTendeuse());

    }

    @Test
    @Order(5)
    void buildTondeuse_dataIncorrect_ShouldThrowException() {
        assertThrows(LigneInvalideException.class, () -> builder.buildTondeuse());
    }

    @Test
    @Order(6)
    void buildCommandesTendeuse_dataIncorrect_ShouldThrowException() {
        assertThrows(LigneInvalideException.class, () -> builder.buildCommandesTendeuse());
    }
}
