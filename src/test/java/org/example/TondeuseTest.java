package org.example;

import org.example.Enumerations.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseTest {

    private Tondeuse tondeuse;

    @BeforeEach
    void setUp() {
    }

    @Test
    void tournerDroite_DroiteNord_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.NORD);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.EST, tondeuse.getOrientation());


    }

    @Test
    void tournerDroite_DroiteEst_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.EST);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.SUD, tondeuse.getOrientation());

    }

    @Test
    void tournerDroite_DroiteSud_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.SUD);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.OUEST, tondeuse.getOrientation());

    }

    @Test
    void tournerDroite_DroiteOuest_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.OUEST);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.NORD, tondeuse.getOrientation());

    }

    @Test
    void tournerGauche_GaucheNord_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.NORD);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.OUEST, tondeuse.getOrientation());
    }

    @Test
    void tournerGauche_GaucheEst_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.EST);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }

    @Test
    void tournerGauche_GaucheSud_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.SUD);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.EST, tondeuse.getOrientation());
    }

    @Test
    void tournerGauche_GaucheOuest_ShouldReturnNouvelleOrientation() {
        Position positionActuel = new Position(1, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.OUEST);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(Orientation.SUD, tondeuse.getOrientation());
    }

    @Test
    void getProhainPosition_AvancerNord_ShouldReturnNouvellePosition() {
        Position positionActuel = new Position(0, 0);
        tondeuse = new Tondeuse(positionActuel, Orientation.NORD);
        Position position = tondeuse.getProchainPosition();
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }

    @Test
    void getProhainPosition_AvancerSud_ShouldReturnNouvellePosition() {
        Position positionActuel = new Position(0, 1);
        tondeuse = new Tondeuse(positionActuel, Orientation.SUD);
        Position position = tondeuse.getProchainPosition();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Orientation.SUD, tondeuse.getOrientation());
    }

    @Test
    void getProhainPosition_AvancerEst_ShouldReturnNouvellePosition() {
        Position positionActuel = new Position(0, 0);
        tondeuse = new Tondeuse(positionActuel, Orientation.EST);
        Position position = tondeuse.getProchainPosition();
        assertEquals(1, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Orientation.EST, tondeuse.getOrientation());
    }

    @Test
    void getProhainPosition_AvancerOuest_ShouldReturnNouvellePosition() {
        Position positionActuel = new Position(1, 0);
        tondeuse = new Tondeuse(positionActuel, Orientation.OUEST);
        Position position = tondeuse.getProchainPosition();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Orientation.OUEST, tondeuse.getOrientation());
    }

    @Test
    void setNouvellePosition_ShouldReturnNouvellePosition() {
        Position positionActuel = new Position(1, 0);
        tondeuse = new Tondeuse(positionActuel, Orientation.NORD);
        Position position = new Position(1, 1);
        tondeuse.setPosition(position);
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(1, tondeuse.getPosition().getY());
        assertEquals(Orientation.NORD, tondeuse.getOrientation());
    }


    @Test
    void toString_ShouldDisplayPositionEtOrientation() {
        Position positionActuel = new Position(3, 2);
        tondeuse = new Tondeuse(positionActuel, Orientation.SUD);
        String position = tondeuse.toString();
        assertEquals("3 2 S", position);
    }

}
