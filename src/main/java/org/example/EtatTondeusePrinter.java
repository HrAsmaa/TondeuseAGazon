package org.example;

/**
 * Classe responsable de l'affichage de l'etat du tondeuse
 */
public class EtatTondeusePrinter {
    public void afficherEtatConsole(Tondeuse tondeuse) {
        if (tondeuse == null) {
            throw new NullPointerException("tondeusse est null");
        }
        System.out.print(tondeuse);
    }
}
