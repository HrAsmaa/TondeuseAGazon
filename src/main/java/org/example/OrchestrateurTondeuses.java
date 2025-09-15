package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.Exceptions.CommandeInvalideException;

/**
 * Classe responsable du pilotage de la tondeuse sur la pelouse
 */
@RequiredArgsConstructor
@Setter
@Getter
public class OrchestrateurTondeuses {

    private final Pelouse pelouse;
    private final EtatTondeusePrinter etatTondeusePrinter;

    public void executerTendeuse(Tondeuse tondeuse, String commandes) {
        if (commandes != null) {
            for (char cmd : commandes.toCharArray()) {
                switch (cmd) {
                    case 'G':
                        tondeuse.tournerGauche();
                        break;
                    case 'D':
                        tondeuse.tournerDroite();
                        break;
                    case 'A': {
                        Position prochaine = tondeuse.getProchainPosition();
                        if (this.pelouse.estDansLimites(prochaine)) {
                            tondeuse.setPosition(prochaine);
                        }
                        break;
                    }
                    default:
                        throw new CommandeInvalideException(" la commande '" + cmd + "' est invalide");
                }
            }
        }
        this.etatTondeusePrinter.afficherEtatConsole(tondeuse);
    }

}
