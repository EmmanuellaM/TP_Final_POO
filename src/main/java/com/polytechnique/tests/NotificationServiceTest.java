package com.polytechnique.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.polytechnique.Entités.NotificationService;
import com.polytechnique.Entités.Participant;

public class NotificationServiceTest {
    // Implémentation factice de NotificationService
    class FakeNotificationService implements NotificationService {
        private String dernierMessageEnvoye = "";
        private Participant dernierDestinataire = null;

        @Override
        public void envoyerNotification(String message, Participant destinataire) {
            this.dernierMessageEnvoye = message;
            this.dernierDestinataire = destinataire;
        }

        public String getDernierMessageEnvoye() {
            return dernierMessageEnvoye;
        }

        public Participant getDernierDestinataire() {
            return dernierDestinataire;
        }
    }

    // Implémentation factice de Participant pour le test
    class FakeParticipant extends Participant {
        public FakeParticipant(String id, String nom, String email) {
            super(id, nom, email);
        }

        @Override
        public void recevoirNotification(String message) {
            // Ne fait rien pour le test
        }
    }

    @Test
    public void testEnvoyerNotification() {
        FakeNotificationService service = new FakeNotificationService();
        FakeParticipant participant = new FakeParticipant("P001", "Alice", "alice@example.com");

        String testMessage = "Message de test";
        service.envoyerNotification(testMessage, participant);

        assertEquals("Message de test", service.getDernierMessageEnvoye());
        assertEquals(participant, service.getDernierDestinataire());
    }

}
