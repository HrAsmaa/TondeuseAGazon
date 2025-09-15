package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PelouseTest {

    private Pelouse pelouse;

    @BeforeEach
    void setUp() {
        pelouse = new Pelouse(5,5);
    }

    @Test
    void estDansLimites_positionDansLimites_ShouldReturnTrue() {
        Position position = new Position(2,1);
        Boolean dansLimites = pelouse.estDansLimites(position);
        assertEquals(true, dansLimites);
    }

    @Test
    void estDansLimites_positionHorsLimites_ShouldReturnFalse() {
        Position position = new Position(6,1);
        Boolean dansLimites = pelouse.estDansLimites(position);
        assertEquals(false, dansLimites);
    }
}
