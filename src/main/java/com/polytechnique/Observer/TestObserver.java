package com.polytechnique.Observer;

import java.time.LocalDateTime;

import com.polytechnique.Entités.Conference;
import com.polytechnique.Entités.Intervenant;

public class TestObserver {
    Conference conf = new Conference("C1", "Conférence IA", LocalDateTime.now().plusDays(10), "Paris", 100, "IA", null);

        Intervenant p1 = new Intervenant("P1", "Lili", "lili@mail.com", "Informatique");
        Intervenant p2 = new Intervenant("P2", "Alex", "alex@mail.com", "Robotique");

        // conf.ajouterObservateur(p1);
        // conf.ajouterObservateur(p2);

        // conf.modifier("Lyon", LocalDateTime.now().plusDays(12));
        // conf.annuler();
}
