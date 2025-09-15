package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Enumerations.Orientation;

/**
 * classe représentant la tondeuse avec une position et une orientation
 */
@Getter
@Setter
@AllArgsConstructor
public class Tondeuse {
    private Position position;
    private Orientation orientation;

    public void tournerGauche() {
        switch (orientation) {
            case EST:
                orientation = Orientation.NORD;
                break;
            case SUD:
                orientation = Orientation.EST;
                break;
            case OUEST:
                orientation = Orientation.SUD;
                break;
            case NORD:
                orientation = Orientation.OUEST;
                break;
        }
    }

    public void tournerDroite() {
        switch (orientation) {
            case EST:
                orientation = Orientation.SUD;
                break;
            case SUD:
                orientation = Orientation.OUEST;
                break;
            case OUEST:
                orientation = Orientation.NORD;
                break;
            case NORD:
                orientation = Orientation.EST;
                break;
        }
    }

    public Position getProchainPosition() {
        switch (orientation) {
            case EST:
                return new Position(position.x + 1, position.y);
            case SUD:
                return new Position(position.x, position.y - 1);
            case OUEST:
                return new Position(position.x - 1, position.y);
            case NORD:
                return new Position(position.x, position.y + 1);
        }

        return null;
    }

    @Override
    public String toString() {
        return position.getX() + " " + position.getY() + " " + orientation.getCode();
    }
}
