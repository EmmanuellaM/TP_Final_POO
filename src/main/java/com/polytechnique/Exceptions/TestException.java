package com.polytechnique.Exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.polytechnique.Entités.Concert;
import com.polytechnique.Entités.Conference;
import com.polytechnique.Entités.Evenement;
import com.polytechnique.Entités.GestionEvenements;
import com.polytechnique.Entités.SimpleParticipant;
import com.polytechnique.Observer.ParticipantObserver;

public class TestException {
    public static void testerCapaciteMax() {
        System.out.println(" Test CapaciteMaxAtteinteException ");

        Evenement concert = new Concert("E1", "Concert Rock", LocalDateTime.now(), "Paris", 1, "Queen", "Rock");

        try {
            ParticipantObserver participant1 = new SimpleParticipant("P1", "Lili", "lili@email.com");
            ParticipantObserver participant2 = new SimpleParticipant("P2", "Max", "max@email.com");

            concert.ajouterParticipant(participant1); // OK
            concert.ajouterParticipant(participant2); // Doit lancer une exception
        } catch (CapaciteMaxAtteinteException e) {
            System.out.println("Exception capturée : " + e.getMessage());
        }
    }

    public static void testerEvenementDejaExistant() {
        System.out.println("\n Test EvenementDejaExistantException ");

        GestionEvenements gestion = GestionEvenements.getInstance();

        Evenement conf1 = new Conference("C1", "Conf Java", LocalDateTime.now(), "Dakar", 50, "Java", new ArrayList<>());
        Evenement conf2 = new Conference("C1", "Conf Python", LocalDateTime.now(), "Lyon", 40, "Python", new ArrayList<>());

        try {
            gestion.ajouterEvenement(conf1); // OK
            gestion.ajouterEvenement(conf2); // Doit lancer une exception
        } catch (EvenementDejaExistantException e) {
            System.out.println(" Exception capturée : " + e.getMessage());
        }
    }
}
