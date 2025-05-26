package com.polytechnique.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.polytechnique.Entités.Intervenant;

public class IntervenantTest {
    private Intervenant intervenant;

    @BeforeEach
    public void setUp() {
        intervenant = new Intervenant("I001", "Jean Dupont", "jean@polytechnique.com", "Cybersécurité");
    }

    @Test
    public void testGetDomaineIntervention() {
        assertEquals("Cybersécurité", intervenant.getDomaineIntervention());
    }

    @Test
    public void testRecevoirNotification() {
        // Vérifie que la méthode ne lève pas d'exception (affiche dans la console)
        assertDoesNotThrow(() -> intervenant.recevoirNotification("Vous êtes invité à intervenir lors d'une conférence."));
    }

    @Test
    public void testConstructeurAvecDomaine() {
        Intervenant i = new Intervenant("IA");
        assertEquals("IA", i.getDomaineIntervention());
    }

    @Test
    public void testConstructeurParDéfaut() {
        Intervenant i = new Intervenant();
        assertNull(i.getDomaineIntervention());
    }
}
