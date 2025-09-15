package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("Fichier manquant");
            System.exit(1);
        }

        Path fichier = Paths.get(args[0]);
        try {
            DeployementTendeuseBuilder deployementTendeuseBuilder = new DeployementTendeuseBuilder(fichier);
            OrchestrateurTondeuses orchestrateurTondeuses = deployementTendeuseBuilder.buildOrchestrateurTendeuse();
            Tondeuse tondeuse = deployementTendeuseBuilder.buildTondeuse();
            while (tondeuse != null) {

                orchestrateurTondeuses.executerTendeuse(tondeuse, deployementTendeuseBuilder.buildCommandesTendeuse());
                tondeuse = deployementTendeuseBuilder.buildTondeuse();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}