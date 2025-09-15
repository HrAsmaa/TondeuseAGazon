package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * classe représentant la pelouse avec maxX,maxY comme coordonnées du coin supérieur droit
 */
@Getter
@Setter
@AllArgsConstructor
public class Pelouse {
    private int maxX;
    private int maxY;


    public Boolean estDansLimites(Position position) {
        return position.getX() >= 0 && position.getY() >= 0
                && position.getX() <= maxX && position.getY() <= maxY;
    }

}
