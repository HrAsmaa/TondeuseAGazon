package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Exceptions.CommandeInvalideException;

@AllArgsConstructor
@Setter
@Getter
public class OrchestrateurTondeuses {

    private Pelouse pelouse;

    public void executerTendeuse(Tondeuse tondeuse, String commandes) {
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
                    if (pelouse.estDansLimites(prochaine)) {
                        tondeuse.setPosition(prochaine);
                    }
                    break;
                }
                default:
                    throw new CommandeInvalideException(" la commande '" + cmd + "' est invalide");
            }
        }
    }

}
