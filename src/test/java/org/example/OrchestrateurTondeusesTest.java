package org.example;

import org.example.Exceptions.CommandeInvalideException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class OrchestrateurTondeusesTest {

    private OrchestrateurTondeuses orchestrateurTondeuses;
    private Pelouse pelouse;
    private Tondeuse tondeuse;
    private EtatTondeusePrinter etatTondeusePrinter;

    @BeforeEach
    void setUp() {
        pelouse = mock(Pelouse.class);
        tondeuse = mock(Tondeuse.class);
        etatTondeusePrinter = mock(EtatTondeusePrinter.class);
        orchestrateurTondeuses = new OrchestrateurTondeuses(pelouse, etatTondeusePrinter);
    }

    @Test
    void executerTendeuse_positionDansLimites_ShouldSetNouvellePosition() {
        Position position = new Position(1, 4);
        when(pelouse.estDansLimites(position)).thenReturn(true);
        when(tondeuse.getProchainPosition()).thenReturn(position);

        orchestrateurTondeuses.executerTendeuse(tondeuse, "A");
        verify(pelouse, times(1)).estDansLimites(position);
        verify(tondeuse, times(1)).getProchainPosition();
        verify(tondeuse, times(1)).setPosition(position);
        verify(etatTondeusePrinter, times(1)).afficherEtatConsole(tondeuse);

        verifyNoMoreInteractions(tondeuse);
        verifyNoMoreInteractions(pelouse);
    }

    @Test
    void executerTendeuse_positionHorsLimites_ShouldNotSetNouvellePosition() {
        Position position = new Position(1, 4);
        when(pelouse.estDansLimites(position)).thenReturn(false);
        when(tondeuse.getProchainPosition()).thenReturn(position);

        orchestrateurTondeuses.executerTendeuse(tondeuse, "A");
        verify(pelouse, times(1)).estDansLimites(position);
        verify(tondeuse, times(1)).getProchainPosition();
        verify(etatTondeusePrinter, times(1)).afficherEtatConsole(tondeuse);
        verifyNoMoreInteractions(tondeuse);
        verifyNoMoreInteractions(pelouse);
    }

    @Test
    void executerTendeuse_Droite_ShouldCallTournerDroite() {
        orchestrateurTondeuses.executerTendeuse(tondeuse, "D");
        verify(tondeuse, times(1)).tournerDroite();
        verify(etatTondeusePrinter, times(1)).afficherEtatConsole(tondeuse);
        verifyNoMoreInteractions(tondeuse);
        verifyNoMoreInteractions(pelouse);
    }

    @Test
    void executerTendeuse_Gauche_ShouldCallTournerGauche() {
        orchestrateurTondeuses.executerTendeuse(tondeuse, "G");
        verify(tondeuse, times(1)).tournerGauche();
        verify(etatTondeusePrinter, times(1)).afficherEtatConsole(tondeuse);
        verifyNoMoreInteractions(tondeuse);
        verifyNoMoreInteractions(pelouse);
    }

    @Test
    void executerTendeuse_sequenceDeCommandes_ShouldCallToutesActions() {
        Position position = new Position(1, 4);
        when(pelouse.estDansLimites(position)).thenReturn(true);
        when(tondeuse.getProchainPosition()).thenReturn(position);

        orchestrateurTondeuses.executerTendeuse(tondeuse, "AGDG");
        verify(pelouse, times(1)).estDansLimites(position);
        verify(tondeuse, times(1)).getProchainPosition();
        verify(tondeuse, times(1)).setPosition(position);
        verify(tondeuse, times(2)).tournerGauche();
        verify(tondeuse, times(1)).tournerDroite();
        verify(etatTondeusePrinter, times(1)).afficherEtatConsole(tondeuse);

        verifyNoMoreInteractions(tondeuse);
        verifyNoMoreInteractions(pelouse);
    }

    @Test
    void executerTendeuse_CommandeInvalide_ShouldThrowException() {
        assertThrows(CommandeInvalideException.class, () -> orchestrateurTondeuses.executerTendeuse(tondeuse, "B"));
    }

}
