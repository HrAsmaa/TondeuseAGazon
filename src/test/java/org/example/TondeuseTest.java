package org.example;

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
        tondeuse = new Tondeuse(PointCardinal.NORD,1,2);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.EST, tondeuse.getOrientation());


    }

    @Test
    void tournerDroite_DroiteEst_ShouldReturnNouvelleOrientation() {
        tondeuse = new Tondeuse(PointCardinal.EST,1,2);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.SUD, tondeuse.getOrientation());

    }

    @Test
    void tournerDroite_DroiteSud_ShouldReturnNouvelleOrientation() {
        tondeuse = new Tondeuse(PointCardinal.SUD,1,2);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.OUEST, tondeuse.getOrientation());

    }

    @Test
    void tournerDroite_DroiteOuest_ShouldReturnNouvelleOrientation() {
        tondeuse = new Tondeuse(PointCardinal.OUEST,1,2);
        tondeuse.tournerDroite();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.NORD, tondeuse.getOrientation());

    }

    @Test
    void tournerGauche_GaucheNord_ShouldReturnNouvelleOrientation() {
        tondeuse = new Tondeuse(PointCardinal.NORD,1,2);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.OUEST, tondeuse.getOrientation());
    }

    @Test
    void tournerGauche_GaucheEst_ShouldReturnNouvelleOrientation() {
        tondeuse = new Tondeuse(PointCardinal.EST,1,2);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.NORD, tondeuse.getOrientation());
    }

    @Test
    void tournerGauche_GaucheSud_ShouldReturnNouvelleOrientation() {
        tondeuse = new Tondeuse(PointCardinal.SUD,1,2);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.EST, tondeuse.getOrientation());
    }

    @Test
    void tournerGauche_GaucheOuest_ShouldReturnNouvelleOrientation() {
        tondeuse = new Tondeuse(PointCardinal.OUEST,1,2);
        tondeuse.tournerGauche();
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(2, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.SUD, tondeuse.getOrientation());
    }

    @Test
    void getProhainPosition_AvancerNord_ShouldReturnNouvellePosition() {
        tondeuse = new Tondeuse(PointCardinal.NORD,0,0);
        Position position = tondeuse.getProhainPosition();
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
        assertEquals(PointCardinal.NORD, tondeuse.getOrientation());
    }

    @Test
    void getProhainPosition_AvancerSud_ShouldReturnNouvellePosition() {
        tondeuse = new Tondeuse(PointCardinal.SUD,0,1);
        Position position = tondeuse.getProhainPosition();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(PointCardinal.SUD, tondeuse.getOrientation());
    }

    @Test
    void getProhainPosition_AvancerEst_ShouldReturnNouvellePosition() {
        tondeuse = new Tondeuse(PointCardinal.EST,0,0);
        Position position = tondeuse.getProhainPosition();
        assertEquals(1, position.getX());
        assertEquals(0, position.getY());
        assertEquals(PointCardinal.EST, tondeuse.getOrientation());
    }
    @Test
    void getProhainPosition_AvancerOuest_ShouldReturnNouvellePosition() {
        tondeuse = new Tondeuse(PointCardinal.OUEST,1,0);
        Position position = tondeuse.getProhainPosition();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(PointCardinal.OUEST, tondeuse.getOrientation());
    }

    @Test
    void setNouvellePosition_ShouldReturnNouvellePosition() {
        tondeuse = new Tondeuse(PointCardinal.NORD,1,0);
        Position position = new Position(1,1);
        tondeuse.setNouvellePosition(position);
        assertEquals(1, tondeuse.getPosition().getX());
        assertEquals(1, tondeuse.getPosition().getY());
        assertEquals(PointCardinal.NORD, tondeuse.getOrientation());
    }
    

    @Test
    void toString_ShouldDisplayPositionEtOrientation() {
        tondeuse = new Tondeuse(PointCardinal.SUD,3,2);
        String position = tondeuse.toString();
        assertEquals("3 2 S", position);
    }

}
