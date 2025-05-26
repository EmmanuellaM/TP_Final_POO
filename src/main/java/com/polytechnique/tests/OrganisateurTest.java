package com.polytechnique.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.polytechnique.Entités.Evenement;
import com.polytechnique.Entités.Organisateur;

public class OrganisateurTest {
    private Organisateur organisateur;
    private Evenement evenement1;
    private Evenement evenement2;

    @BeforeEach
    public void setUp() {
        // Création d'évènements fictifs
        evenement1 = new Evenement("E001", "Hackathon", LocalDateTime.of(2025, 6, 15, 9, 0), "Lyon", 150);
        evenement2 = new Evenement("E002", "Conférence Santé", LocalDateTime.of(2025, 9, 10, 14, 0), "Marseille", 200);

        List<Evenement> evenements = new ArrayList<>();
        evenements.add(evenement1);

        organisateur = new Organisateur("O001", "Sophie Morel", "sophie@polytechnique.com", evenements);
    }

    @Test
    public void testGetEvenementsOrganises() {
        List<Evenement> evenements = organisateur.getEvenementsOrganises();
        assertEquals(1, evenements.size());
        assertEquals("Hackathon", evenements.get(0).getNom());
    }

    @Test
    public void testAjouterEvenement() {
        organisateur.ajouterEvenement(evenement2);
        List<Evenement> evenements = organisateur.getEvenementsOrganises();
        assertEquals(2, evenements.size());
        assertEquals("Conférence Santé", evenements.get(1).getNom());
    }

    @Test
    public void testRecevoirNotification() {
        // On vérifie seulement que la méthode ne lève pas d'exception (elle affiche dans la console)
        assertDoesNotThrow(() -> organisateur.recevoirNotification("Nouvel évènement à planifier"));
    }
}
