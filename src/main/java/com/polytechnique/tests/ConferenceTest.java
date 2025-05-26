package com.polytechnique.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.polytechnique.Entités.Conference;
import com.polytechnique.Entités.Intervenant;

public class ConferenceTest {
    private Conference conference;
    private List<Intervenant> intervenants;

    @BeforeEach
    public void setUp() {
        Intervenant intervenant1 = new Intervenant("Alice Dupont", "Intelligence Artificielle");
        Intervenant intervenant2 = new Intervenant("Bob Martin", "Sécurité Informatique");
        intervenants = Arrays.asList(intervenant1, intervenant2);

        conference = new Conference(
                "C001",
                "Conférence Tech 2025",
                LocalDateTime.of(2025, 10, 15, 10, 0),
                "Paris",
                300,
                "Technologies émergentes",
                intervenants
        );
    }

    @Test
    public void testGetTheme() {
        assertEquals("Technologies émergentes", conference.getTheme());
    }

    @Test
    public void testGetIntervenants() {
        assertEquals(2, conference.getIntervenants().size());
        assertEquals("Alice Dupont", conference.getIntervenants().get(0).nom);
        assertEquals("Sécurité Informatique", conference.getIntervenants().get(1).getDomaineIntervention());
    }

    @Test
    public void testConstructeurAvecThemeEtIntervenants() {
        Conference conf = new Conference("Éthique de l'IA", intervenants);
        assertEquals("Éthique de l'IA", conf.getTheme());
        assertEquals(intervenants, conf.getIntervenants());
    }

    @Test
    public void testAfficherDetails() {
        assertDoesNotThrow(() -> conference.afficherDetails());
    }
}
