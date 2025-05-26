package com.polytechnique.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDateTime;

import com.polytechnique.Entités.Concert;
import com.polytechnique.Entités.Participant;
import com.polytechnique.Exceptions.CapaciteMaxAtteinteException;

public class ConcertTest {
    private Concert concert;

    // Classe interne créée pour simuler un participant, par ce que la classe Participant est abstraite
    static class FauxParticipant extends Participant {
        public FauxParticipant(String id, String nom, String email) {
            super(id, nom, email);
        }

        @Override
        public void recevoirNotification(String message) {
            // Ne fait rien ici, juste pour le test
        }
    }

    @BeforeEach
    void setUp() {
        // Initialisation d'un objet Concert avec des valeurs de test
        concert = new Concert(
                "1",
                "Rock Festival",
                LocalDateTime.of(2025, 6, 15, 20, 0),
                "Paris",
                2, // capacité maximale de 2 pour tester les limites
                "Imagine Dragons",
                "Rock"
        );
    }

    @Test
    void testConstructeurEtGetters() {
        // Vérifie que les valeurs sont bien stockées
        assertEquals("1", concert.getId());
        assertEquals("Rock Festival", concert.getNom());
        assertEquals("Paris", concert.getLieu());
        assertEquals(2, concert.getCapaciteMax());
        assertEquals("Imagine Dragons", concert.getArtiste());
        assertEquals("Rock", concert.getGenreMusical());
    }

    @Test
    void testAjouterParticipantAvecSucces() throws CapaciteMaxAtteinteException {
        // Ajoute un participant et vérifie qu'il n'y a pas d'exception
        FauxParticipant p1 = new FauxParticipant("p1", "Lili", "lili@example.com");
        concert.ajouterParticipant(p1);
        // Pas d'assert ici car aucune exception attendue = succès
    }

    @Test
    void testAjouterParticipantDepasseCapacite() throws CapaciteMaxAtteinteException {
        // Ajoute deux participants, puis un troisième et vérifie que l'exception est levée
        concert.ajouterParticipant(new FauxParticipant("p1", "Lili", "lili@example.com"));
        concert.ajouterParticipant(new FauxParticipant("p2", "Bob", "bob@example.com"));

        assertThrows(CapaciteMaxAtteinteException.class, () -> {
            concert.ajouterParticipant(new FauxParticipant("p3", "Anna", "anna@example.com"));
        });
    }

    @Test
    void testAfficherDetails() {
        // Ici on teste que la méthode ne lance pas d'erreur
        // (elle imprime sur la console, donc difficile à tester sans redirection de sortie)
        assertDoesNotThrow(() -> concert.afficherDetails());
    }
}
