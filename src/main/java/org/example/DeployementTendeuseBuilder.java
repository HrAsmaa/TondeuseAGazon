package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.Enumerations.Direction;
import org.example.Enumerations.Orientation;
import org.example.Exceptions.LigneInvalideException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Classe Builder responsable de la fabrication des différents composants du système de tondeuse automatique
 */
@RequiredArgsConstructor
@Getter
@Setter
public class DeployementTendeuseBuilder {
    private Path filePath;
    private BufferedReader reader;

    public DeployementTendeuseBuilder(Path filePath) throws IOException {
        this.filePath = filePath;
        reader = Files.newBufferedReader(filePath);

    }

    public OrchestrateurTondeuses buildOrchestrateurTendeuse() throws IOException {
        String ligne = reader.readLine();
        if (ligne == null) {
            return null;
        }
        String[] dimensions = ligne.split(" ");
        if (dimensions.length != 2) {
            throw new LigneInvalideException("La ligne doit contenir exactement 2 entiers (largeur et hauteur): " + Arrays.toString(dimensions));
        }
        Pelouse pelouse;
        try {
            pelouse = new Pelouse(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
        } catch (NumberFormatException e) {
            throw new LigneInvalideException("Les dimensions doivent être des entiers valides: " + Arrays.toString(dimensions));
        }
        return new OrchestrateurTondeuses(pelouse, new EtatTondeusePrinter());
    }

    public Tondeuse buildTondeuse() throws IOException {
        String lignePosition = reader.readLine();
        if (lignePosition == null) {
            return null;
        }
        String[] coordonees = lignePosition.split(" ");
        if (coordonees.length != 3) {
            throw new LigneInvalideException("La ligne de position doit contenir 2 entiers et 1 orientation (ex: '3 4 N'): " + Arrays.toString(coordonees));
        }
        Position position;
        try {
            position = new Position(Integer.parseInt(coordonees[0]), Integer.parseInt(coordonees[1]));
            return new Tondeuse(position, Orientation.fromCode(coordonees[2]));
        } catch (NumberFormatException e) {
            throw new LigneInvalideException("Les deux premiers éléments doivent être des entiers: " + Arrays.toString(coordonees));
        } catch (IllegalArgumentException e) {
            throw new LigneInvalideException("Le troisième élément doit être une orientation valide (N, E, S, O): " + Arrays.toString(coordonees));
        }
    }

    public String buildCommandesTendeuse() throws IOException {
        String commandes = reader.readLine();
        if (commandes == null) {
            return null;
        }
        for (char c : commandes.toCharArray()) {
            try {
                Direction.fromCode(String.valueOf(c));
            } catch (IllegalArgumentException e) {
                throw new LigneInvalideException(
                        "Commande invalide : chaque lettre doit être D, G ou A: " + commandes
                );
            }
        }
        return commandes;
    }
}
